package com.only4.algorithm.version4j.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        int left, mid = 0, right;
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        while (mid < nums.length) {
            int target = -nums[mid];
            left = mid + 1;
            right = nums.length - 1;
            while (left < right) {
                int leftValue = nums[left];
                int rightValue = nums[right];
                int sum = leftValue + rightValue;

                if (sum == target) {
                    result.add(List.of(nums[left], -target, nums[right]));
                    while (++left != nums.length && nums[left] == leftValue) ;
                    while (--right != 0 && nums[right] == rightValue) ;
                } else if (sum < target) while (++left != nums.length && nums[left] == leftValue) ;
                else while (--right != 0 && nums[right] == rightValue) ;
            }
            while (++mid != nums.length && nums[mid] == -target) ;
        }
        return result;
    }
}
