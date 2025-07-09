package com.only4.algorithm.version4j.leetcode;

/**
 * @author zhenyu.jiang
 */
public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] prefixSum = new int[nums.length + 1];
        int[] suffixSum = new int[nums.length + 1];
        prefixSum[0] = 1;
        suffixSum[nums.length] = 1;

        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            prefixSum[i + 1] = prefixSum[i] * nums[i];
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] * nums[i];
        }


        for (int left = 0; left < result.length; left++) {
            int right = left == result.length - 1 ? result.length : left + 1;
            result[left] = prefixSum[left] * suffixSum[right];
        }
        return result;
    }
}
