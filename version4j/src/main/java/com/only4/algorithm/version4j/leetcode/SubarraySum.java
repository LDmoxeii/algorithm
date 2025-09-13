package com.only4.algorithm.version4j.leetcode;

import java.util.HashMap;
import java.util.Map;

public class SubarraySum {
    public int subarraySum(int[] nums, int k) {
        // 记录前缀和的出现次数，初始化前缀和0出现1次（空数组）
        Map<Integer, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0, 1);

        int count = 0;
        int currentPrefixSum = 0;

        for (int num : nums) {
            // 计算当前前缀和
            currentPrefixSum += num;

            // 查找是否存在前缀和为 currentPrefixSum - k
            // 如果存在，说明有子数组的和为k
            count += prefixSumCount.getOrDefault(currentPrefixSum - k, 0);

            // 更新当前前缀和的出现次数
            prefixSumCount.put(currentPrefixSum,
                    prefixSumCount.getOrDefault(currentPrefixSum, 0) + 1);
        }

        return count;
    }
}
