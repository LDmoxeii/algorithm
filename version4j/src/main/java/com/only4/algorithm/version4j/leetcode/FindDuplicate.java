package com.only4.algorithm.version4j.leetcode;

public class FindDuplicate {
    public int findDuplicate(int[] nums) {
        // 使用弗洛伊德判圈法（快慢指针）查找环的入口
        int slow = nums[0];
        int fast = nums[0];

        // 第一步：快慢指针相遇，找到环中的一个相遇点
        do {
            slow = nums[slow];         // 慢指针每次走一步
            fast = nums[nums[fast]];   // 快指针每次走两步
        } while (slow != fast);

        // 第二步：将慢指针重新指向起点，快慢指针同步前进
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        // 相遇点即为重复数字
        return slow;
    }
}
