package com.only4.algorithm.version4j.leetcode;

/**
 * @author zhenyu.jiang
 */
public class Rotate {
    public void rotate(int[] nums, int k) {
        if (nums.length == 1) return;
        int boundary = nums.length - (k % nums.length);
        // 0, boundary - 1
        // boundary, nums.length -1

        int LL = 0, LR = boundary - 1;
        int RL = boundary, RR = nums.length - 1;

        while (LL < LR) {
            int temp = nums[LL];
            nums[LL++] = nums[LR];
            nums[LR--] = temp;
        }

        while (RL < RR) {
            int temp = nums[RL];
            nums[RL++] = nums[RR];
            nums[RR--] = temp;
        }

        int L = 0, R = nums.length - 1;
        while (L < R) {
            int temp = nums[L];
            nums[L++] = nums[R];
            nums[R--] = temp;
        }
    }

    public void rotate(int[][] matrix) {
        //TODO
    }
}
