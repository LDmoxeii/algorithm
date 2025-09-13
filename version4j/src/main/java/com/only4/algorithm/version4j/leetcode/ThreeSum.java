package com.only4.algorithm.version4j.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // 排序便于去重和剪枝

        for (int i = 0; i < nums.length - 2; i++) {
            // 跳过重复的第一个数
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            // 剪枝：如果当前数大于0，后面都是正数，三数之和必然大于0
            if (nums[i] > 0) break;

            int left = i + 1, right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // 跳过重复的左指针值
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    // 跳过重复的右指针值
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    left++;
                    right--;
                } else if (sum < 0) {
                    left++; // 和太小，左指针右移
                } else {
                    right--; // 和太大，右指针左移
                }
            }
        }

        return result;
    }
}
