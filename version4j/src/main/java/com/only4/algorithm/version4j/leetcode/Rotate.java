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
        int top = 0, bottom = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;

        while (top < bottom) {
            int steps = right - left;
            for (int offset = 0; offset < steps; offset++) {
                int temp = matrix[top][left + offset];

                matrix[top][left + offset] = matrix[bottom - offset][left];
                matrix[bottom - offset][left] = matrix[bottom][right - offset];
                matrix[bottom][right - offset] = matrix[top + offset][right];
                matrix[top + offset][right] = temp;
            }
            top++;
            bottom--;
            left++;
            right--;
        }
    }
}
