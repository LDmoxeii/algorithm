package com.only4.algorithm.version4j.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhenyu.jiang
 */
public class Permute {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        ArrayDeque<Integer> sequence = new ArrayDeque<>();
        boolean[] used = new boolean[nums.length];
        dfs(nums, used, sequence, result);
        return result;
    }

    public void dfs(int[] nums, boolean[] used, ArrayDeque<Integer> sequence, List<List<Integer>> result) {
        if (sequence.size() == nums.length) result.add(new ArrayList<>(sequence));

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            used[i] = true;
            sequence.addLast(nums[i]);
            dfs(nums, used, sequence, result);
            sequence.removeLast();
            used[i] = false;
        }
    }
}
