package com.only4.algorithm.version4j.leetcode;

import com.only4.algorithm.version4j.extra.TreeNode;

public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildTree(nums, 0, nums.length - 1);
    }

    private TreeNode buildTree(int[] nums, int leftIndex, int rightIndex) {
        if (leftIndex > rightIndex) return null;

        int midIndex = leftIndex + (rightIndex - leftIndex) / 2;
        TreeNode root = new TreeNode(nums[midIndex]);

        root.left = buildTree(nums, leftIndex, midIndex - 1);
        root.right = buildTree(nums, midIndex + 1, rightIndex);

        return root;
    }
}
