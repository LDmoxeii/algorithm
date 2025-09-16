package com.only4.algorithm.version4j.leetcode;

public class MaxProduct {
    public int maxProduct(int[] nums) {
        // productRangeEndingAt[i] 表示以nums[i]结尾的子数组的[最小乘积, 最大乘积]
        long[][] productRangeEndingAt = new long[nums.length][2];
        long globalMaxProduct = nums[0];

        // 初始化第一个元素的最小和最大乘积
        productRangeEndingAt[0][0] = nums[0]; // 最小乘积
        productRangeEndingAt[0][1] = nums[0]; // 最大乘积

        for (int currentIndex = 1; currentIndex < nums.length; currentIndex++) {
            long currentNumber = nums[currentIndex];
            long previousMinProduct = productRangeEndingAt[currentIndex - 1][0];
            long previousMaxProduct = productRangeEndingAt[currentIndex - 1][1];

            // 计算当前位置结尾的子数组可能的最小和最大乘积
            // 考虑三种情况：
            // 1. 当前数乘以前面的最小乘积
            // 2. 当前数乘以前面的最大乘积
            // 3. 当前数单独作为新子数组的开始
            long productWithPreviousMin = currentNumber * previousMinProduct;
            long productWithPreviousMax = currentNumber * previousMaxProduct;

            long currentMinProduct = Math.min(
                    Math.min(productWithPreviousMin, productWithPreviousMax),
                    currentNumber
            );
            long currentMaxProduct = Math.max(
                    Math.max(productWithPreviousMin, productWithPreviousMax),
                    currentNumber
            );

            // 更新当前位置的最小和最大乘积
            productRangeEndingAt[currentIndex][0] = currentMinProduct;
            productRangeEndingAt[currentIndex][1] = currentMaxProduct;

            // 更新全局最大乘积
            globalMaxProduct = Math.max(globalMaxProduct, currentMaxProduct);
        }

        return (int)globalMaxProduct;
    }
}
