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
 * Permute算法的单元测试
 */
public class PermuteTest {

    private Permute permute;

    @BeforeEach
    public void setUp() {
        permute = new Permute();
    }

    @Test
    public void testSingleElement() {
        // 测试单个元素数组
        int[] nums = {1};
        List<List<Integer>> result = permute.permute(nums);
        assertEquals(1, result.size());
        assertEquals(Arrays.asList(1), result.get(0));
    }

    @Test
    public void testMultipleElements() {
        // 测试多元素数组 [1,2,3]
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = permute.permute(nums);

        // 全排列应该有 3! = 6 种可能
        assertEquals(6, result.size());

        // 检查结果是否包含所有可能的排列
        List<List<Integer>> expectedPermutations = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(1, 3, 2),
                Arrays.asList(2, 1, 3),
                Arrays.asList(2, 3, 1),
                Arrays.asList(3, 1, 2),
                Arrays.asList(3, 2, 1)
        );

        // 检查每个预期的排列是否在结果中
        for (List<Integer> expected : expectedPermutations) {
            assertTrue(containsPermutation(result, expected),
                    "结果中应该包含排列: " + expected);
        }
    }

    @Test
    public void testLargerArray() {
        // 测试更大的数组 [1,2,3,4]
        int[] nums = {1, 2, 3, 4};
        List<List<Integer>> result = permute.permute(nums);

        // 全排列应该有 4! = 24 种可能
        assertEquals(24, result.size());

        // 检查所有结果的长度都是4
        for (List<Integer> perm : result) {
            assertEquals(4, perm.size());
        }

        // 验证结果中没有重复的排列
        Set<List<Integer>> uniquePerms = new HashSet<>(result);
        assertEquals(result.size(), uniquePerms.size(), "结果中不应有重复的排列");
    }

    /**
     * 辅助方法：检查结果集中是否包含指定的排列
     */
    private boolean containsPermutation(List<List<Integer>> permutations, List<Integer> targetPerm) {
        for (List<Integer> perm : permutations) {
            if (perm.equals(targetPerm)) {
                return true;
            }
        }
        return false;
    }
}
