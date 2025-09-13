package com.only4.algorithm.version4j.leetcode;

public class MaxArea {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxWater = 0;

        while (left < right) {
            // 计算当前容器面积：宽度 × 高度（取较小值）
            int currentArea = Math.min(height[left], height[right]) * (right - left);
            maxWater = Math.max(maxWater, currentArea);

            // 移动较短的那条边
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxWater;
    }
}
