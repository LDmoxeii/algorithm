package com.only4.algorithm.version4j.leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * CombinationSum算法的单元测试
 */
public class CombinationSumTest {

    private CombinationSum combinationSum;

    @BeforeEach
    public void setUp() {
        combinationSum = new CombinationSum();
    }

    @Test
    public void testBasicCase() {
        // 基本测试用例
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> result = combinationSum.combinationSum(candidates, target);

        // 预期结果应该有两种组合：[2,2,3] 和 [7]
        assertEquals(2, result.size());

        // 检查结果是否包含预期的组合
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(2, 2, 3),
                Arrays.asList(7)
        );

        for (List<Integer> combo : expected) {
            assertTrue(containsCombination(result, combo),
                    "结果中应包含组合: " + combo);
        }
    }

    @Test
    public void testAnotherCase() {
        // 另一个测试用例
        int[] candidates = {2, 3, 5};
        int target = 8;
        List<List<Integer>> result = combinationSum.combinationSum(candidates, target);

        // 预期结果：[2,2,2,2], [2,3,3], [3,5]
        assertEquals(3, result.size());

        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(2, 2, 2, 2),
                Arrays.asList(2, 3, 3),
                Arrays.asList(3, 5)
        );

        for (List<Integer> combo : expected) {
            assertTrue(containsCombination(result, combo),
                    "结果中应包含组合: " + combo);
        }
    }

    @Test
    public void testSingleCandidate() {
        // 测试只有一个候选数的情况
        int[] candidates = {3};
        int target = 6;
        List<List<Integer>> result = combinationSum.combinationSum(candidates, target);

        // 预期结果：[3,3]
        assertEquals(1, result.size());
        assertEquals(Arrays.asList(3, 3), result.get(0));
    }

    @Test
    public void testNoSolution() {
        // 测试没有解的情况
        int[] candidates = {2};
        int target = 3;
        List<List<Integer>> result = combinationSum.combinationSum(candidates, target);

        // 预期没有解
        assertEquals(0, result.size());
    }

    @Test
    public void testZeroTarget() {
        // 测试目标值为0的情况
        int[] candidates = {1, 2, 3};
        int target = 0;
        List<List<Integer>> result = combinationSum.combinationSum(candidates, target);

        // 预期结果：空组合 []
        assertEquals(1, result.size());
        assertTrue(result.get(0).isEmpty());
    }

    @Test
    public void testLargeTarget() {
        // 测试较大的目标值
        int[] candidates = {2, 3, 5};
        int target = 20;
        List<List<Integer>> result = combinationSum.combinationSum(candidates, target);

        // 检查所有组合的和是否都等于目标值
        for (List<Integer> combo : result) {
            int sum = combo.stream().mapToInt(Integer::intValue).sum();
            assertEquals(target, sum, "组合" + combo + "的和应等于目标值" + target);
        }
    }

    /**
     * 辅助方法：检查结果中是否包含特定组合
     * 注意：由于组合可能以不同顺序出现，所以需要特殊处理
     */
    private boolean containsCombination(List<List<Integer>> combinations, List<Integer> target) {
        for (List<Integer> combo : combinations) {
            // 对两个列表排序再比较
            List<Integer> sortedCombo = new ArrayList<>(combo);
            List<Integer> sortedTarget = new ArrayList<>(target);
            Collections.sort(sortedCombo);
            Collections.sort(sortedTarget);

            if (sortedCombo.equals(sortedTarget)) {
                return true;
            }
        }
        return false;
    }
}
