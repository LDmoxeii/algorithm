package com.only4.algorithm.version4j.leetcode;

public class ClimbStairs {
    public int climbStairs(int n) {
        if (n <= 2) return n;

        // 到达前两阶楼梯的方法数
        int waysToReachTwoStepsBack = 1;
        // 到达前一阶楼梯的方法数
        int waysToReachOneStepBack = 2;

        // 从第3阶开始逐步计算到第n阶
        for (int currentStair = 3; currentStair <= n; currentStair++) {
            // 当前阶梯的方法数 = 前一阶的方法数 + 前两阶的方法数
            int waysToReachCurrentStair = waysToReachOneStepBack + waysToReachTwoStepsBack;

            // 更新状态：为计算下一阶做准备
            waysToReachTwoStepsBack = waysToReachOneStepBack;
            waysToReachOneStepBack = waysToReachCurrentStair;
        }

        return waysToReachOneStepBack;
    }
}
