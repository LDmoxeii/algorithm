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
        ArrayDeque<Integer> path = new ArrayDeque<>();
        backtrack(nums, 0, path, result);
        return result;
    }

    public void backtrack(int[] nums, int startIndex, ArrayDeque<Integer> path, List<List<Integer>> result) {
        result.add(new ArrayList<>(path));

        for (int i = startIndex; i < nums.length; i++) {
            path.addLast(nums[i]);
            backtrack(nums, i + 1, path, result);
            path.removeLast();
        }
    }
}
