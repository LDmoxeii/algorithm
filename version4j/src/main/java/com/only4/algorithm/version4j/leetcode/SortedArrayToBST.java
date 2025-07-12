package com.only4.algorithm.version4j.leetcode;

import com.only4.algorithm.version4j.extra.TreeNode;

public class SortedArrayToBST {

    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    public TreeNode sortedArrayToBST(int[] nums, int left, int right) {
        if (left > right) return null;
        int mid = right - (right - left) / 2;
        TreeNode lTree = sortedArrayToBST(nums, left, mid - 1);
        TreeNode rTree = sortedArrayToBST(nums, mid + 1, right);
        TreeNode root = new TreeNode(nums[mid]);
        root.left = lTree;
        root.right = rTree;
        return root;
    }
}
