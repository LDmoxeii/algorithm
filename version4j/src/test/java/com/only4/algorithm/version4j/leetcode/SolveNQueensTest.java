package com.only4.algorithm.version4j.leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * SolveNQueens算法的单元测试
 * 用于测试N皇后问题的求解
 */
public class SolveNQueensTest {

    private SolveNQueens solveNQueens;

    @BeforeEach
    public void setUp() {
        solveNQueens = new SolveNQueens();
    }

    @Test
    public void testN1() {
        // 测试n=1的情况
        int n = 1;
        List<List<String>> result = solveNQueens.solveNQueens(n);

        // n=1时应该只有一个解决方案
        assertEquals(1, result.size(), "n=1应只有一个解决方案");
        assertEquals("Q", result.get(0).get(0), "唯一解决方案应该是一个皇后");
    }

    @Test
    public void testN4() {
        // 测试n=4的情况
        int n = 4;
        List<List<String>> result = solveNQueens.solveNQueens(n);

        // n=4时应该有2个解决方案
        assertEquals(2, result.size(), "n=4应有2个解决方案");

        // 验证两个已知解决方案
        Set<List<String>> expectedSolutions = new HashSet<>();
        expectedSolutions.add(Arrays.asList(
                ".Q..",
                "...Q",
                "Q...",
                "..Q."));
        expectedSolutions.add(Arrays.asList(
                "..Q.",
                "Q...",
                "...Q",
                ".Q.."));

        for (List<String> solution : result) {
            assertTrue(expectedSolutions.contains(solution),
                    "解决方案应该是预期的解决方案之一");
        }
    }

    @Test
    public void testN8() {
        // 测试n=8的情况
        int n = 8;
        List<List<String>> result = solveNQueens.solveNQueens(n);

        // n=8时应该有92个解决方案
        assertEquals(92, result.size(), "n=8应有92个解决方案");
    }

    @Test
    public void testSolutionFormat() {
        // 测试解决方案的格式是否正确
        int n = 4;
        List<List<String>> result = solveNQueens.solveNQueens(n);

        for (List<String> solution : result) {
            // 每个解决方案应该有n行
            assertEquals(n, solution.size(), "每个解决方案应该有" + n + "行");

            // 每行应该有n个字符
            for (String row : solution) {
                assertEquals(n, row.length(), "每行应该有" + n + "个字符");

                // 每行应该只包含一个'Q'和多个'.'
                assertEquals(1, countChar(row, 'Q'), "每行应该只有一个皇后");
                assertEquals(n - 1, countChar(row, '.'), "其余位置应该是'.'");
            }

            // 验证解决方案是有效的（没有皇后能互相攻击）
            assertTrue(isValidSolution(solution), "解决方案应该是有效的");
        }
    }

    /**
     * 辅助方法：计算字符串中指定字符的数量
     */
    private int countChar(String str, char ch) {
        int count = 0;
        for (char c : str.toCharArray()) {
            if (c == ch) count++;
        }
        return count;
    }

    /**
     * 辅助方法：检查解决方案是否有效
     * 每行、每列、每条对角线上最多只能有一个皇后
     */
    private boolean isValidSolution(List<String> solution) {
        int n = solution.size();
        boolean[] cols = new boolean[n];
        boolean[] diag1 = new boolean[2 * n - 1]; // 主对角线
        boolean[] diag2 = new boolean[2 * n - 1]; // 副对角线

        for (int i = 0; i < n; i++) {
            String row = solution.get(i);
            for (int j = 0; j < n; j++) {
                if (row.charAt(j) == 'Q') {
                    // 检查列
                    if (cols[j]) return false;
                    cols[j] = true;

                    // 检查主对角线
                    int d1 = i + j;
                    if (diag1[d1]) return false;
                    diag1[d1] = true;

                    // 检查副对角线
                    int d2 = i - j + n - 1;
                    if (diag2[d2]) return false;
                    diag2[d2] = true;
                }
            }
        }

        return true;
    }
}
