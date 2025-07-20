package com.only4.algorithm.version4j.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class FindKthLargest {

    public int quickSelect(List<Integer> nums, int k) {
        Random random = new Random();
        int pivot = nums.get(random.nextInt(0, nums.size()));

        ArrayList<Integer> bigger = new ArrayList<>();
        ArrayList<Integer> equal = new ArrayList<>();
        ArrayList<Integer> smaller = new ArrayList<>();

        for (int num : nums) {
            if (num > pivot) bigger.add(num);
            if (num == pivot) equal.add(num);
            if (num < pivot) smaller.add(num);
        }

        if (bigger.size() >= k) {
            return quickSelect(bigger, k);
        } else if (equal.size() >= k - bigger.size()) {
            return equal.get(0);
        } else {
            return quickSelect(smaller, k - bigger.size() - equal.size());
        }
    }

    public int findKthLargest(int[] nums, int k) {
        return quickSelect(Arrays.stream(nums).boxed().toList(), k);
    }
}
