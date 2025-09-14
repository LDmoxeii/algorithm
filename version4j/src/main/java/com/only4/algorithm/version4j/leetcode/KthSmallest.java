package com.only4.algorithm.version4j.leetcode;

import com.only4.algorithm.version4j.extra.TreeNode;

public class KthSmallest {
    private int targetRank;

    public int kthSmallest(TreeNode root, int k) {
        this.targetRank = k;
        return inorderTraversal(root);
    }

    private int inorderTraversal(TreeNode currentNode) {
        if (currentNode == null) {
            return -1; // 题目保证节点值非负，用 -1 表示没有找到
        }

        // 先搜索左子树
        int leftResult = inorderTraversal(currentNode.left);
        if (leftResult != -1) { // 如果在左子树中找到了答案
            return leftResult;
        }

        // 处理当前节点
        if (--targetRank == 0) { // 当前节点就是第k小的元素
            return currentNode.val;
        }

        // 搜索右子树
        return inorderTraversal(currentNode.right); // 右子树会返回答案或者 -1
    }
}
