package com.only4.algorithm.version4j.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * OrangesRotting的测试类
 * 测试LeetCode第994题：腐烂的橘子
 */
public class OrangesRottingTest {

    /**
     * 测试标准情况：腐烂的橘子使新鲜橘子腐烂，最终所有橘子都腐烂
     */
    @Test
    public void testNormalCase() {
        int[][] grid = {
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };

        OrangesRotting solution = new OrangesRotting();
        int result = solution.orangesRotting(grid);

        // 期望的最小分钟数为4
        assertEquals(4, result);
    }

    /**
     * 测试所有橘子都已经腐烂的情况
     */
    @Test
    public void testAllAlreadyRotten() {
        int[][] grid = {
                {2, 2, 2},
                {2, 2, 2},
                {2, 2, 2}
        };

        OrangesRotting solution = new OrangesRotting();
        int result = solution.orangesRotting(grid);

        // 所有橘子已腐烂，不需要时间
        assertEquals(0, result);
    }

    /**
     * 测试没有橘子的情况（全是空格子）
     */
    @Test
    public void testNoOranges() {
        int[][] grid = {
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        };

        OrangesRotting solution = new OrangesRotting();
        int result = solution.orangesRotting(grid);

        // 没有橘子，不需要时间
        assertEquals(0, result);
    }

    /**
     * 测试无法使所有橘子腐烂的情况
     */
    @Test
    public void testImpossible() {
        int[][] grid = {
                {2, 1, 1},
                {0, 1, 0},
                {1, 0, 1}
        };

        OrangesRotting solution = new OrangesRotting();
        int result = solution.orangesRotting(grid);

        // 由于有隔离的新鲜橘子，不可能全部腐烂，返回-1
        assertEquals(-1, result);
    }

    /**
     * 测试只有一个新鲜橘子的情况
     */
    @Test
    public void testSingleFresh() {
        int[][] grid = {{1}};

        OrangesRotting solution = new OrangesRotting();
        int result = solution.orangesRotting(grid);

        // 只有一个新鲜橘子，没有腐烂橘子，不可能腐烂，返回-1
        assertEquals(-1, result);
    }

    /**
     * 测试只有一个腐烂橘子的情况
     */
    @Test
    public void testSingleRotten() {
        int[][] grid = {{2}};

        OrangesRotting solution = new OrangesRotting();
        int result = solution.orangesRotting(grid);

        // 只有一个腐烂橘子，不需要时间
        assertEquals(0, result);
    }

    /**
     * 测试边界值情况：在网格边缘的腐烂橘子和新鲜橘子
     */
    @Test
    public void testBoundaryCase() {
        int[][] grid = {
                {2, 1, 0},
                {1, 1, 0},
                {0, 0, 0}
        };

        OrangesRotting solution = new OrangesRotting();
        int result = solution.orangesRotting(grid);

        // 腐烂橘子在左上角，需要2分钟使所有新鲜橘子腐烂
        assertEquals(2, result);
    }

    /**
     * 测试复杂的网格排列
     */
    @Test
    public void testComplexGrid() {
        int[][] grid = {
                {2, 0, 1, 0, 0},
                {1, 0, 1, 0, 0},
                {0, 0, 1, 0, 1},
                {0, 0, 0, 0, 1}
        };

        OrangesRotting solution = new OrangesRotting();
        int result = solution.orangesRotting(grid);

        // 一些新鲜橘子无法被腐烂，返回-1
        assertEquals(-1, result);
    }

    /**
     * 测试多个腐烂橘子同时扩散的情况
     */
    @Test
    public void testMultipleSourcesOfRot() {
        int[][] grid = {
                {2, 1, 1},
                {1, 1, 1},
                {1, 1, 2}
        };

        OrangesRotting solution = new OrangesRotting();
        int result = solution.orangesRotting(grid);

        // 两个角落有腐烂橘子，同时开始扩散，需要2分钟
        assertEquals(2, result);
    }
}
