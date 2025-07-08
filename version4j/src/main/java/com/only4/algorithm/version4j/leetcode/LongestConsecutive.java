package com.only4.algorithm.version4j.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhenyu.jiang
 */
public class LongestConsecutive {
    public int longestConsecutive(int[] nums) {
        int result = 0;
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        for (int num : nums) {
            int current = num;
            if (numSet.contains(num - 1)) continue;

            while (numSet.contains(++current)) {
            }

            result = Math.max(result, current - num);
        }
        return result;
    }
}
