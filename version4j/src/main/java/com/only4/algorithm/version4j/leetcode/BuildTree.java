package com.only4.algorithm.version4j.leetcode;

import com.only4.algorithm.version4j.extra.TreeNode;

public class BuildTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeHelper(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode buildTreeHelper(int[] preorder, int[] inorder,
                                     int preorderStart, int preorderEnd,
                                     int inorderStart, int inorderEnd) {
        if (preorderStart > preorderEnd) return null;

        int rootValue = preorder[preorderStart];
        TreeNode root = new TreeNode(rootValue);
        int inorderRootIndex = findInorderIndex(inorder, rootValue);
        int leftSubtreeSize = inorderRootIndex - inorderStart;

        TreeNode leftSubtree = buildTreeHelper(preorder, inorder,
                preorderStart + 1, preorderStart + leftSubtreeSize,
                inorderStart, inorderRootIndex - 1);
        TreeNode rightSubtree = buildTreeHelper(preorder, inorder,
                preorderStart + leftSubtreeSize + 1, preorderEnd,
                inorderRootIndex + 1, inorderEnd);

        root.left = leftSubtree;
        root.right = rightSubtree;
        return root;
    }

    private int findInorderIndex(int[] inorder, int target) {
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == target) {
                return i;
            }
        }
        throw new IllegalArgumentException("Target not found in array");
    }
}
