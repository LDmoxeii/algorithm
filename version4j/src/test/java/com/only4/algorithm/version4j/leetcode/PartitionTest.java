package com.only4.algorithm.version4j.leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Partition算法的单元测试
 * 用于测试字符串的回文分割
 */
public class PartitionTest {

    private Partition partition;

    @BeforeEach
    public void setUp() {
        partition = new Partition();
    }

    @Test
    public void testBasicExample() {
        // 基本测试用例
        String s = "aab";
        List<List<String>> result = partition.partition(s);

        // 预期结果为 [["a","a","b"], ["aa","b"]]
        assertEquals(2, result.size(), "应有两种分割方式");

        // 验证包含所有预期的分割方式
        assertTrue(containsPartition(result, Arrays.asList("a", "a", "b")),
                "应包含分割方式 [a,a,b]");
        assertTrue(containsPartition(result, Arrays.asList("aa", "b")),
                "应包含分割方式 [aa,b]");
    }

    @Test
    public void testEmptyString() {
        // 测试空字符串
        String s = "";
        List<List<String>> result = partition.partition(s);

        // 空字符串应该返回一个包含空列表的列表
        assertEquals(1, result.size(), "空字符串应有一种分割方式");
        assertEquals(0, result.get(0).size(), "空字符串的分割结果应为空列表");
    }

    @Test
    public void testSingleChar() {
        // 测试单个字符
        String s = "a";
        List<List<String>> result = partition.partition(s);

        // 单个字符应该只有一种分割方式
        assertEquals(1, result.size(), "单字符应有一种分割方式");
        assertEquals(Arrays.asList("a"), result.get(0), "单字符的分割结果应为[a]");
    }

    @Test
    public void testAllSameChars() {
        // 测试所有字符相同的字符串
        String s = "aaa";
        List<List<String>> result = partition.partition(s);

        // 预期结果: ["a","a","a"], ["a","aa"], ["aa","a"], ["aaa"]
        assertEquals(4, result.size(), "应有四种分割方式");

        assertTrue(containsPartition(result, Arrays.asList("a", "a", "a")),
                "应包含分割方式 [a,a,a]");
        assertTrue(containsPartition(result, Arrays.asList("a", "aa")),
                "应包含分割方式 [a,aa]");
        assertTrue(containsPartition(result, Arrays.asList("aa", "a")),
                "应包含分割方式 [aa,a]");
        assertTrue(containsPartition(result, Arrays.asList("aaa")),
                "应包含分割方式 [aaa]");
    }

    @Test
    public void testComplexString() {
        // 测试更复杂的字符串
        String s = "abba";
        List<List<String>> result = partition.partition(s);

        // 预期结果: ["a","b","b","a"], ["a","bb","a"], ["abba"]
        assertEquals(3, result.size(), "应有三种分割方式");

        assertTrue(containsPartition(result, Arrays.asList("a", "b", "b", "a")),
                "应包含分割方式 [a,b,b,a]");
        assertTrue(containsPartition(result, Arrays.asList("a", "bb", "a")),
                "应包含分割方式 [a,bb,a]");
        assertTrue(containsPartition(result, Arrays.asList("abba")),
                "应包含分割方式 [abba]");
    }

    @Test
    public void testNoInnerPalindromes() {
        // 测试不包含内部回文的字符串
        String s = "abc";
        List<List<String>> result = partition.partition(s);

        // 预期结果: ["a","b","c"]，因为没有更长的回文子串
        assertEquals(1, result.size(), "应有一种分割方式");
        assertEquals(Arrays.asList("a", "b", "c"), result.get(0),
                "分割结果应为[a,b,c]");
    }

    /**
     * 辅助方法：检查结果中是否包含指定的分割方式
     */
    private boolean containsPartition(List<List<String>> partitions, List<String> targetPartition) {
        for (List<String> partition : partitions) {
            if (partition.equals(targetPartition)) {
                return true;
            }
        }
        return false;
    }
}
