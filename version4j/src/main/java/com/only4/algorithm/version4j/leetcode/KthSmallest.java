package com.only4.algorithm.version4j.leetcode;

import com.only4.algorithm.version4j.extra.TreeNode;

public class KthSmallest {
    int count = 0;

    public int kthSmallest(TreeNode root, int k) {
        if (root == null) return -1;
        int candidates = kthSmallest(root.left, k);
        count++;
        if (count == k) return root.val;
        if (candidates >= 0) return candidates;
        return kthSmallest(root.right, k);
    }

}
