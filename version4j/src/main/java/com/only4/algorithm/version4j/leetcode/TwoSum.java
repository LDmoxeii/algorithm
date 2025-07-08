package com.only4.algorithm.version4j.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhenyu.jiang
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> complementMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (complementMap.containsKey(nums[i])) return new int[]{i, complementMap.get(nums[i])};
            complementMap.put(target - nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
