package com.only4.algorithm.version4j.leetcode;

public class Trap {
    public int trap(int[] height) {
        if (height.length < 3) return 0;

        int left = 0, right = height.length - 1;
        int leftMax = height[left], rightMax = height[right];
        int totalWater = 0;

        while (left < right) {
            if (leftMax < rightMax) {
                // 左边较低，移动左指针
                left++;
                if (height[left] < leftMax) {
                    // 当前高度小于左边最大高度，可以接水
                    totalWater += leftMax - height[left];
                } else {
                    // 更新左边最大高度
                    leftMax = height[left];
                }
            } else {
                // 右边较低或相等，移动右指针
                right--;
                if (height[right] < rightMax) {
                    // 当前高度小于右边最大高度，可以接水
                    totalWater += rightMax - height[right];
                } else {
                    // 更新右边最大高度
                    rightMax = height[right];
                }
            }
        }

        return totalWater;
    }
}
