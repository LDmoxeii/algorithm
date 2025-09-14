package com.only4.algorithm.version4j.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhenyu.jiang
 */
public class SolveNQueens {
    public List<List<String>> solveNQueens(int chessboardSize) {
        List<List<String>> allValidSolutions = new ArrayList<>();
        char[][] chessboard = new char[chessboardSize][chessboardSize];

        // 初始化棋盘为空位置
        for (int row = 0; row < chessboardSize; row++) {
            for (int column = 0; column < chessboardSize; column++) {
                chessboard[row][column] = '.';
            }
        }

        // 优化冲突检测：预计算冲突数组
        boolean[] occupiedColumns = new boolean[chessboardSize];
        boolean[] occupiedMainDiagonals = new boolean[2 * chessboardSize - 1];
        boolean[] occupiedAntiDiagonals = new boolean[2 * chessboardSize - 1];

        findAllQueenPlacementsByBacktracking(chessboard, 0, allValidSolutions,
                occupiedColumns, occupiedMainDiagonals, occupiedAntiDiagonals);
        return allValidSolutions;
    }

    private void findAllQueenPlacementsByBacktracking(char[][] chessboard, int currentRow,
                                                      List<List<String>> allValidSolutions,
                                                      boolean[] occupiedColumns,
                                                      boolean[] occupiedMainDiagonals,
                                                      boolean[] occupiedAntiDiagonals) {
        int boardSize = chessboard.length;

        // 所有皇后都已成功放置
        if (currentRow == boardSize) {
            List<String> currentValidSolution = new ArrayList<>();
            for (char[] rowChars : chessboard) {
                currentValidSolution.add(new String(rowChars));
            }
            allValidSolutions.add(currentValidSolution);
            return;
        }

        // 尝试在当前行的每一列放置皇后
        for (int candidateColumn = 0; candidateColumn < boardSize; candidateColumn++) {
            int mainDiagonalIndex = currentRow + candidateColumn;
            int antiDiagonalIndex = currentRow - candidateColumn + boardSize - 1;

            // 检查是否与已放置的皇后冲突
            if (occupiedColumns[candidateColumn] ||
                    occupiedMainDiagonals[mainDiagonalIndex] ||
                    occupiedAntiDiagonals[antiDiagonalIndex]) {
                continue;
            }

            // 放置皇后并标记冲突区域
            chessboard[currentRow][candidateColumn] = 'Q';
            occupiedColumns[candidateColumn] = true;
            occupiedMainDiagonals[mainDiagonalIndex] = true;
            occupiedAntiDiagonals[antiDiagonalIndex] = true;

            // 递归处理下一行
            findAllQueenPlacementsByBacktracking(chessboard, currentRow + 1, allValidSolutions,
                    occupiedColumns, occupiedMainDiagonals, occupiedAntiDiagonals);

            // 回溯：移除皇后并解除标记
            chessboard[currentRow][candidateColumn] = '.';
            occupiedColumns[candidateColumn] = false;
            occupiedMainDiagonals[mainDiagonalIndex] = false;
            occupiedAntiDiagonals[antiDiagonalIndex] = false;
        }
    }
}
