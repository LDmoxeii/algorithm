package com.only4.algorithm.version4j.leetcode;

/**
 * @author zhenyu.jiang
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int zero, nonZero = 0;

        for (zero = 0; zero < nums.length; zero++) {
            if (nums[zero] == 0) continue;
            if (zero != nonZero) {
                int temp = nums[zero];
                nums[zero] = nums[nonZero];
                nums[nonZero] = temp;
            }
            nonZero++;
        }
    }
}
