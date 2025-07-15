package com.only4.algorithm.version4j.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhenyu.jiang
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        ArrayDeque<Integer> sequence = new ArrayDeque<>();
        dfs(nums, 0, sequence, result);
        return result;
    }

    public void dfs(int[] nums, int start, ArrayDeque<Integer> sequence, List<List<Integer>> result) {
        result.add(new ArrayList<>(sequence));

        for (int i = start; i < nums.length; i++) {
            sequence.addLast(nums[i]);
            dfs(nums, i + 1, sequence, result);
            sequence.removeLast();
        }
    }
}
