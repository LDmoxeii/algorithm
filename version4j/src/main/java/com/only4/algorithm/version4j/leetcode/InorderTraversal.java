package com.only4.algorithm.version4j.leetcode;

import com.only4.algorithm.version4j.extra.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class InorderTraversal {
    List<Integer> result = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        helper(root);
        return result;
    }

    public void helper(TreeNode root) {
        if (root == null) return;
        helper(root.left);
        result.add(root.val);
        helper(root.right);
    }

}
