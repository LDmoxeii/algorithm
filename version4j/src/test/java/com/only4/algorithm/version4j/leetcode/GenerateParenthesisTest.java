package com.only4.algorithm.version4j.leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * GenerateParenthesis算法的单元测试
 */
public class GenerateParenthesisTest {

    private GenerateParenthesis generateParenthesis;

    @BeforeEach
    public void setUp() {
        generateParenthesis = new GenerateParenthesis();
    }

    @Test
    public void testN1() {
        // 测试n=1的情况
        int n = 1;
        List<String> result = generateParenthesis.generateParenthesis(n);

        // 期望结果: ["()"]
        assertEquals(1, result.size());
        assertTrue(result.contains("()"), "结果应包含 ()");
    }

    @Test
    public void testN2() {
        // 测试n=2的情况
        int n = 2;
        List<String> result = generateParenthesis.generateParenthesis(n);

        // 期望结果: ["(())", "()()"]
        assertEquals(2, result.size());
        assertTrue(result.contains("(())"), "结果应包含 (())");
        assertTrue(result.contains("()()"), "结果应包含 ()()");
    }

    @Test
    public void testN3() {
        // 测试n=3的情况
        int n = 3;
        List<String> result = generateParenthesis.generateParenthesis(n);

        // 期望结果: ["((()))", "(()())", "(())()", "()(())", "()()()"]
        assertEquals(5, result.size());
        assertTrue(result.contains("((()))"), "结果应包含 ((()))");
        assertTrue(result.contains("(()())"), "结果应包含 (()())");
        assertTrue(result.contains("(())()"), "结果应包含 (())()");
        assertTrue(result.contains("()(())"), "结果应包含 ()(())");
        assertTrue(result.contains("()()()"), "结果应包含 ()()()");
    }

    @Test
    public void testN4() {
        // 测试n=4的情况
        int n = 4;
        List<String> result = generateParenthesis.generateParenthesis(n);

        // n=4时应该有14种可能的组合
        assertEquals(14, result.size());

        // 检查一些典型的组合
        assertTrue(result.contains("(((())))"), "结果应包含 (((())))");
        assertTrue(result.contains("()()()()"), "结果应包含 ()()()()");
        assertTrue(result.contains("(())()()"), "结果应包含 (())()()");
    }

    @Test
    public void testValidParentheses() {
        // 测试生成的括号是否都是有效的
        int n = 3;
        List<String> result = generateParenthesis.generateParenthesis(n);

        // 检查每个生成的括号组合是否都是有效的
        for (String parenthesis : result) {
            assertTrue(isValidParenthesis(parenthesis),
                    "生成的括号组合应该是有效的: " + parenthesis);
        }
    }

    @Test
    public void testDistinct() {
        // 测试生成的括号组合是否都是不重复的
        int n = 3;
        List<String> result = generateParenthesis.generateParenthesis(n);

        Set<String> uniqueResults = new HashSet<>(result);
        assertEquals(result.size(), uniqueResults.size(),
                "生成的括号组合应该没有重复");
    }

    /**
     * 辅助方法：检查括号组合是否有效
     */
    private boolean isValidParenthesis(String s) {
        int balance = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                balance++;
            } else if (c == ')') {
                balance--;
                if (balance < 0) return false;
            }
        }
        return balance == 0;
    }
}
