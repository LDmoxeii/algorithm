package com.only4.algorithm.version4j.leetcode;

public class Jump {
    public int jump(int[] nums) {
        if (nums.length <= 1) return 0;

        int currentReach = 0;
        int maxReach = 0;
        int jumps = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            maxReach = Math.max(maxReach, i + nums[i]);

            if (i == currentReach) {
                currentReach = maxReach;
                jumps++;

                if (currentReach >= nums.length - 1) {
                    return jumps;
                }
            }
        }
        return jumps;
    }
}
