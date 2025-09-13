package com.only4.algorithm.version4j.leetcode;

import com.only4.algorithm.version4j.extra.TreeNode;

import java.util.ArrayDeque;

public class KthSmallest {
    public int kthSmallest(TreeNode root, int k) {
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        TreeNode current = root;
        int count = 0;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.addLast(current);
                current = current.left;
            }

            current = stack.removeLast();
            count++;

            if (count == k) {
                return current.val;
            }

            current = current.right;
        }

        return -1;
    }
}
