package com.only4.algorithm.version4j.leetcode;

import com.only4.algorithm.version4j.extra.TreeNode;

/**
 * [105. 从前序与中序遍历序列构造二叉树](https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/?envType=study-plan-v2&envId=top-100-liked)
 * <p>
 * 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的前序遍历，
 * inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 *
 * @author zhenyu.jiang
 */
public class BuildTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(
                preorder, inorder,
                0, preorder.length - 1,
                0, inorder.length - 1
        );
    }

    public TreeNode buildTree(
            int[] preorder, int[] inorder,
            int preorderStart, int preorderEnd,
            int inorderStart, int inorderEnd
    ) {
        if (preorderStart > preorderEnd) return null;

        int rootV = preorder[preorderStart];
        TreeNode root = new TreeNode(rootV);
        int index = findIndex(inorder, rootV);
        int len = index - inorderStart;

        TreeNode left = buildTree(
                preorder, inorder,
                preorderStart + 1, preorderStart + len,
                inorderStart, index - 1
        );
        TreeNode right = buildTree(
                preorder, inorder,
                preorderStart + 1 + len, preorderEnd,
                inorderStart + len + 1, inorderEnd
        );

        root.left = left;
        root.right = right;
        return root;
    }

    public static int findIndex(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i;
            }
        }
        return -1; // 表示未找到
    }
}
