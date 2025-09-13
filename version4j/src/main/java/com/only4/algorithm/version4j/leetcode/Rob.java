package com.only4.algorithm.version4j.leetcode;

public class Rob {
    public int rob(int[] nums) {
        // 处理边界情况
        if (nums.length <= 2) {
            return Math.max(nums.length > 0 ? nums[0] : 0, nums.length > 1 ? nums[1] : 0);
        }

        // prev表示偷到前两个房屋为止的最大金额
        int prev = 0;
        // curr表示偷到前一个房屋为止的最大金额
        int curr = 0;

        for (int money : nums) {
            // 当前房屋的最大金额 = max(偷当前房屋 + 前两个房屋的最大金额, 不偷当前房屋)
            int maxMoney = Math.max(money + prev, curr);
            // 更新状态
            prev = curr;
            curr = maxMoney;
        }

        return curr;
    }
}
