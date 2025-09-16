package com.only4.algorithm.version4j.leetcode;

public class LengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        // longestLengthEndingAt[i] 表示以nums[i]结尾的最长递增子序列的长度
        int[] longestLengthEndingAt = new int[nums.length];
        int globalMaxLength = 0;

        for (int currentIndex = 0; currentIndex < nums.length; currentIndex++) {
            int currentValue = nums[currentIndex];
            int maxLengthBeforeCurrent = 0;

            // 检查当前元素之前的所有元素，寻找可以接在后面的最长子序列
            for (int previousIndex = currentIndex - 1; previousIndex >= 0; previousIndex--) {
                int previousValue = nums[previousIndex];

                // 如果找到一个更小的元素，当前元素可以接在其最长递增子序列后面
                if (previousValue < currentValue) {
                    maxLengthBeforeCurrent = Math.max(
                            maxLengthBeforeCurrent,
                            longestLengthEndingAt[previousIndex]
                    );
                }
            }

            // 当前位置的最长递增子序列长度 = 之前最长长度 + 1（当前元素）
            longestLengthEndingAt[currentIndex] = maxLengthBeforeCurrent + 1;

            // 更新全局最大长度
            globalMaxLength = Math.max(globalMaxLength, longestLengthEndingAt[currentIndex]);
        }

        return globalMaxLength;
    }
}
