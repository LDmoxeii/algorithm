package com.only4.algorithm.version4j.leetcode;

public class MaxArea {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int result = 0;
        while (left < right) {
            result = Math.max(result, Math.min(height[left], height[right]) * (right - left));
            if (height[left] > height[right]) right--;
            else left++;
        }
        return result;
    }
}
