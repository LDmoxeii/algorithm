package com.only4.algorithm.version4j.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhenyu.jiang
 */
public class LongestConsecutive {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        // 哈希表存储所有数字，实现O(1)查找
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int maxLength = 0;

        for (int num : numSet) {
            // 只检查序列的起点（不存在前驱数字num-1）
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentLength = 1;

                // 向后查找连续数字
                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentLength++;
                }

                maxLength = Math.max(maxLength, currentLength);
            }
        }

        return maxLength;
    }
}
