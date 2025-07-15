package com.only4.algorithm.version4j.leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * LetterCombinations算法的单元测试
 */
public class LetterCombinationsTest {

    private LetterCombinations letterCombinations;

    @BeforeEach
    public void setUp() {
        letterCombinations = new LetterCombinations();
    }

    @Test
    public void testSingleDigit() {
        // 测试单个数字
        String digits = "2";
        List<String> result = letterCombinations.letterCombinations(digits);

        assertEquals(3, result.size());
        assertTrue(result.contains("a"));
        assertTrue(result.contains("b"));
        assertTrue(result.contains("c"));
    }

    @Test
    public void testTwoDigits() {
        // 测试两个数字
        String digits = "23";
        List<String> result = letterCombinations.letterCombinations(digits);

        assertEquals(9, result.size());
        List<String> expected = Arrays.asList(
                "ad", "ae", "af",
                "bd", "be", "bf",
                "cd", "ce", "cf");

        for (String combo : expected) {
            assertTrue(result.contains(combo), "结果应包含组合: " + combo);
        }
    }

    @Test
    public void testMultipleDigits() {
        // 测试多个数字
        String digits = "234";
        List<String> result = letterCombinations.letterCombinations(digits);

        // 应该有 3*3*3 = 27 种组合
        assertEquals(27, result.size());

        // 随机检查几个组合是否存在
        assertTrue(result.contains("adg"));
        assertTrue(result.contains("bfi"));
        assertTrue(result.contains("cei"));
    }

    @Test
    public void testWithDigit7And9() {
        // 测试包含7和9这种有4个字母映射的数字
        String digits = "79";
        List<String> result = letterCombinations.letterCombinations(digits);

        // 应该有 4*4 = 16 种组合
        assertEquals(16, result.size());

        // 检查是否包含7和9的所有组合
        List<Character> letters7 = Arrays.asList('p', 'q', 'r', 's');
        List<Character> letters9 = Arrays.asList('w', 'x', 'y', 'z');

        for (char c7 : letters7) {
            for (char c9 : letters9) {
                String combo = "" + c7 + c9;
                assertTrue(result.contains(combo), "结果应包含组合: " + combo);
            }
        }
    }

    @Test
    public void testLongInput() {
        // 测试较长的输入
        String digits = "5678";
        List<String> result = letterCombinations.letterCombinations(digits);

        // 应该有 3*3*4*3 = 108 种组合
        assertEquals(108, result.size());

        // 检查每个结果的长度
        for (String combo : result) {
            assertEquals(4, combo.length(), "每个组合应该包含4个字符");
        }
    }
}
