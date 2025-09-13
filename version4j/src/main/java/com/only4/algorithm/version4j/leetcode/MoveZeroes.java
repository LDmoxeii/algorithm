package com.only4.algorithm.version4j.leetcode;

/**
 * @author zhenyu.jiang
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int slow = 0; // 指向下一个非零元素应该放置的位置

        for (int fast = 0; fast < nums.length; fast++) {
            // 如果当前元素不为0，将其移动到slow位置
            if (nums[fast] != 0) {
                if (fast != slow) {
                    // 交换元素
                    int temp = nums[fast];
                    nums[fast] = nums[slow];
                    nums[slow] = temp;
                }
                slow++; // 更新下一个非零元素的位置
            }
        }
    }
}
