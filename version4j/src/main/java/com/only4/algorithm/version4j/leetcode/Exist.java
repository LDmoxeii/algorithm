package com.only4.algorithm.version4j.leetcode;

/**
 * @author zhenyu.jiang
 */
public class Exist {

    // 四个搜索方向：上、下、右、左（用于在网格中进行相邻单元格的搜索）
    private static final int[][] GRID_SEARCH_DIRECTIONS = {
            {-1, 0}, {1, 0}, {0, 1}, {0, -1}
    };

    public boolean exist(char[][] characterGrid, String targetWord) {
        boolean[][] isCellVisitedInCurrentPath = new boolean[characterGrid.length][characterGrid[0].length];

        // 遍历网格中的每个位置作为单词搜索的起始点
        for (int gridRow = 0; gridRow < characterGrid.length; gridRow++) {
            for (int gridCol = 0; gridCol < characterGrid[0].length; gridCol++) {
                if (searchWordFromPositionWithBacktracking(
                        characterGrid,
                        targetWord,
                        gridRow,
                        gridCol,
                        0,  // 从目标单词的第0个字符开始匹配
                        isCellVisitedInCurrentPath
                )) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 使用回溯算法从指定位置开始搜索目标单词
     *
     * @param characterGrid              字符网格
     * @param targetWord                 要搜索的目标单词
     * @param currentGridRow             当前搜索位置的行索引
     * @param currentGridCol             当前搜索位置的列索引
     * @param currentCharacterIndex      当前要匹配的字符在目标单词中的索引
     * @param isCellVisitedInCurrentPath 标记当前搜索路径中已访问的单元格
     * @return 是否找到完整的目标单词
     */
    private boolean searchWordFromPositionWithBacktracking(
            char[][] characterGrid,
            String targetWord,
            int currentGridRow,
            int currentGridCol,
            int currentCharacterIndex,
            boolean[][] isCellVisitedInCurrentPath) {

        // 字符不匹配，当前路径无效
        if (targetWord.charAt(currentCharacterIndex) != characterGrid[currentGridRow][currentGridCol]) {
            return false;
        }

        // 已匹配到目标单词的最后一个字符，找到完整单词
        if (currentCharacterIndex == targetWord.length() - 1) {
            return true;
        }

        // 标记当前单元格为已访问，避免在同一路径中重复使用
        isCellVisitedInCurrentPath[currentGridRow][currentGridCol] = true;

        // 向四个方向搜索下一个字符
        for (int[] searchDirection : GRID_SEARCH_DIRECTIONS) {
            int nextGridRow = currentGridRow + searchDirection[0];
            int nextGridCol = currentGridCol + searchDirection[1];

            // 检查新位置是否有效且未被访问
            if (isValidGridPosition(
                    characterGrid.length,
                    characterGrid[0].length,
                    nextGridRow,
                    nextGridCol,
                    isCellVisitedInCurrentPath
            )) {
                // 递归搜索下一个字符
                if (searchWordFromPositionWithBacktracking(
                        characterGrid,
                        targetWord,
                        nextGridRow,
                        nextGridCol,
                        currentCharacterIndex + 1,
                        isCellVisitedInCurrentPath
                )) {
                    return true;
                }
            }
        }

        // 回溯：恢复当前单元格的访问状态，允许其他路径使用
        isCellVisitedInCurrentPath[currentGridRow][currentGridCol] = false;
        return false;
    }

    /**
     * 检查网格位置是否有效且可访问
     *
     * @param totalGridRows              网格总行数
     * @param totalGridCols              网格总列数
     * @param targetRow                  要检查的行索引
     * @param targetCol                  要检查的列索引
     * @param isCellVisitedInCurrentPath 当前路径的访问状态
     * @return 位置是否有效且可访问
     */
    private boolean isValidGridPosition(
            int totalGridRows,
            int totalGridCols,
            int targetRow,
            int targetCol,
            boolean[][] isCellVisitedInCurrentPath) {
        return targetRow >= 0 &&
                targetRow < totalGridRows &&
                targetCol >= 0 &&
                targetCol < totalGridCols &&
                !isCellVisitedInCurrentPath[targetRow][targetCol];
    }
}
