package com.only4.algorithm.version4j.leetcode;

/**
 * @author zhenyu.jiang
 */
public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        // 第一次遍历：计算左侧乘积
        result[0] = 1; // 第一个元素左侧没有元素，乘积为1
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        // 第二次遍历：计算右侧乘积并与左侧乘积相乘
        int rightProduct = 1; // 右侧乘积的累积值
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= rightProduct; // 左侧乘积 × 右侧乘积
            rightProduct *= nums[i]; // 更新右侧乘积
        }

        return result;
    }
}
