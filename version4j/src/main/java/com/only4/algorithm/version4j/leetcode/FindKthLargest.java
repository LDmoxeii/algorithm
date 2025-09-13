package com.only4.algorithm.version4j.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(Arrays.asList(Arrays.stream(nums).boxed().toArray(Integer[]::new)), k);
    }

    private int quickSelect(List<Integer> nums, int k) {
        Random random = new Random();
        int pivot = nums.get(random.nextInt(nums.size()));

        List<Integer> larger = new ArrayList<>();
        List<Integer> equal = new ArrayList<>();
        List<Integer> smaller = new ArrayList<>();

        for (int num : nums) {
            if (num > pivot) {
                larger.add(num);
            } else if (num == pivot) {
                equal.add(num);
            } else {
                smaller.add(num);
            }
        }

        if (k <= larger.size()) {
            return quickSelect(larger, k);
        } else if (k <= larger.size() + equal.size()) {
            return pivot;
        } else {
            return quickSelect(smaller, k - larger.size() - equal.size());
        }
    }
}
