package com.only4.algorithm.version4j.leetcode;

public class Trap {
    public int trap(int[] height) {
        int result = 0;

        int left = 0, right = height.length - 1;
        int maxL = height[left];
        int maxR = height[right];

        while (left < right) {
            if (maxL < maxR) {
                result += Math.max(maxL - height[++left], 0);
                maxL = Math.max(maxL, height[left]);
            } else {
                result += Math.max(maxR - height[--right], 0);
                maxR = Math.max(maxR, height[right]);
            }
        }
        return result;
    }
}
