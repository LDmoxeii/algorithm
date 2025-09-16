package com.only4.algorithm.version4j.leetcode;

public class Rob {
    public int rob(int[] nums) {
        // 处理边界情况
        if (nums.length <= 2) {
            return Math.max(nums.length > 0 ? nums[0] : 0, nums.length > 1 ? nums[1] : 0);
        }

        // 偷到前两个房屋时的最大金额（即不偷上一个房屋的情况）
        int maxMoneyTwoHousesBack = 0;
        // 偷到前一个房屋时的最大金额
        int maxMoneyOneHouseBack = 0;

        for (int currentHouseMoney : nums) {
            // 计算偷到当前房屋时的最大金额
            // 选择：偷当前房屋+前两个房屋的最大金额 vs 不偷当前房屋
            int maxMoneyAtCurrentHouse = Math.max(
                    currentHouseMoney + maxMoneyTwoHousesBack,  // 偷当前房屋
                    maxMoneyOneHouseBack                        // 不偷当前房屋
            );

            // 更新状态：为下一轮计算做准备
            maxMoneyTwoHousesBack = maxMoneyOneHouseBack;
            maxMoneyOneHouseBack = maxMoneyAtCurrentHouse;
        }

        return maxMoneyOneHouseBack;
    }
}
