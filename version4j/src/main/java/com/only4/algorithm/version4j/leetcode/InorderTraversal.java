package com.only4.algorithm.version4j.leetcode;

import com.only4.algorithm.version4j.extra.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderHelper(root, result);
        return result;
    }

    private void inorderHelper(TreeNode node, List<Integer> result) {
        if (node == null) return;

        // 递归遍历左子树
        inorderHelper(node.left, result);
        // 访问当前节点
        result.add(node.val);
        // 递归遍历右子树
        inorderHelper(node.right, result);
    }
}
