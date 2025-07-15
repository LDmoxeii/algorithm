package com.only4.algorithm.version4j.leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Exist算法的单元测试
 * 用于测试单词搜索功能
 */
public class ExistTest {

    private Exist exist;

    @BeforeEach
    public void setUp() {
        exist = new Exist();
    }

    @Test
    public void testBasicCase() {
        // 基本测试用例
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };

        assertTrue(exist.exist(board, "ABCCED"), "应能找到单词 'ABCCED'");
        assertTrue(exist.exist(board, "SEE"), "应能找到单词 'SEE'");
        assertFalse(exist.exist(board, "ABCB"), "不应找到单词 'ABCB'");
    }

    @Test
    public void testSingleCharBoard() {
        // 测试单字符网格
        char[][] board = {{'A'}};

        assertTrue(exist.exist(board, "A"), "应能找到单词 'A'");
        assertFalse(exist.exist(board, "B"), "不应找到单词 'B'");
        assertFalse(exist.exist(board, "AA"), "不应找到单词 'AA'");
    }

    @Test
    public void testEmptyWord() {
        // 测试空单词
        char[][] board = {
                {'A', 'A'}
        };

        assertFalse(exist.exist(board, "AAA"), "不应该找到单词 'AAA'");
    }

    @Test
    public void testLongWordWinding() {
        // 测试需要蜿蜒路径的长单词
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'E', 'S'},
                {'A', 'D', 'E', 'E'}
        };

        assertTrue(exist.exist(board, "ABCESEEEFS"), "应能找到单词 'ABCESEEEFS'");
    }

    @Test
    public void testRepeatedChars() {
        // 测试包含重复字符的网格
        char[][] board = {
                {'A', 'A', 'A', 'A'},
                {'A', 'A', 'A', 'A'},
                {'A', 'A', 'A', 'A'}
        };

        assertTrue(exist.exist(board, "AAA"), "应能找到单词 'AAA'");
        assertTrue(exist.exist(board, "AAAA"), "应能找到单词 'AAAA'");
        assertTrue(exist.exist(board, "AAAAA"), "应能找到单词 'AAAAA'");
    }
}
