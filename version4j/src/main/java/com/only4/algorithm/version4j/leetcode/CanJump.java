package com.only4.algorithm.version4j.leetcode;

public class CanJump {
    public boolean canJump(int[] nums) {
        if (nums.length == 1) return true;

        int maxReach = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach) return false;

            maxReach = Math.max(maxReach, i + nums[i]);

            if (maxReach >= nums.length - 1) return true;
        }

        return maxReach >= nums.length - 1;
    }
}
