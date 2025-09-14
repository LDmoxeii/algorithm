package com.only4.algorithm.version4k.leetcode

fun exist(characterGrid: Array<CharArray>, targetWord: String): Boolean {
    // 四个搜索方向：上、下、左、右
    val gridSearchDirections = arrayOf(
        intArrayOf(-1, 0), intArrayOf(1, 0),
        intArrayOf(0, -1), intArrayOf(0, 1)
    )

    /**
     * 使用回溯算法从指定位置开始搜索目标单词
     * @param currentGridRow 当前搜索位置的行索引
     * @param currentGridCol 当前搜索位置的列索引
     * @param currentCharacterIndex 当前要匹配的字符在目标单词中的索引
     * @return 是否找到完整的目标单词
     */
    fun searchWordFromPositionWithBacktracking(
        currentGridRow: Int,
        currentGridCol: Int,
        currentCharacterIndex: Int,
    ): Boolean {
        // 字符不匹配，当前路径无效
        if (characterGrid[currentGridRow][currentGridCol] != targetWord[currentCharacterIndex]) {
            return false
        }

        // 已匹配到目标单词的最后一个字符，找到完整单词
        if (currentCharacterIndex == targetWord.lastIndex) {
            return true
        }

        // 保存原字符并标记当前单元格为已访问（使用特殊字符标记）
        val originalCharacterAtCurrentPosition = characterGrid[currentGridRow][currentGridCol]
        characterGrid[currentGridRow][currentGridCol] = '0'  // 标记为已访问

        // 向四个方向搜索下一个字符
        for ((rowDirection, colDirection) in gridSearchDirections) {
            val nextGridRow = currentGridRow + rowDirection
            val nextGridCol = currentGridCol + colDirection

            // 检查新位置是否在有效范围内，并递归搜索
            if (nextGridRow in characterGrid.indices &&
                nextGridCol in characterGrid[0].indices &&
                searchWordFromPositionWithBacktracking(
                    nextGridRow,
                    nextGridCol,
                    currentCharacterIndex + 1
                )
            ) {
                return true
            }
        }

        // 回溯：恢复原字符，允许其他搜索路径使用此单元格
        characterGrid[currentGridRow][currentGridCol] = originalCharacterAtCurrentPosition
        return false
    }

    // 遍历网格中的每个位置作为单词搜索的起始点
    for (gridRow in characterGrid.indices) {
        for (gridCol in characterGrid[0].indices) {
            if (searchWordFromPositionWithBacktracking(gridRow, gridCol, 0)) {
                return true
            }
        }
    }
    return false
}
