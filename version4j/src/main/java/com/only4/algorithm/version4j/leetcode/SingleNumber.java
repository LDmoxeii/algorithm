package com.only4.algorithm.version4j.leetcode;

public class SingleNumber {
    public int singleNumber(int[] nums) {
        // 利用异或运算性质：a ^ a = 0, a ^ 0 = a
        // 相同数字异或会抵消，只剩下出现一次的数字
        int uniqueNumber = nums[0];

        for (int arrayIndex = 1; arrayIndex < nums.length; arrayIndex++) {
            int currentNumber = nums[arrayIndex];
            uniqueNumber = uniqueNumber ^ currentNumber;
        }

        return uniqueNumber;
    }
}
