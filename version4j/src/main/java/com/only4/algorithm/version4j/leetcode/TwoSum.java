package com.only4.algorithm.version4j.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhenyu.jiang
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        // 哈希表：数值 -> 索引
        Map<Integer, Integer> numIndexMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int currentNum = nums[i];
            int complement = target - currentNum;

            // 检查补数是否已存在
            if (numIndexMap.containsKey(complement)) {
                return new int[]{numIndexMap.get(complement), i};
            }

            // 存储当前数值和索引
            numIndexMap.put(currentNum, i);
        }

        throw new IllegalArgumentException("No two sum solution");
    }
}
