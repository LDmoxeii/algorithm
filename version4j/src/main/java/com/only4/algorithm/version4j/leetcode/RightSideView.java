package com.only4.algorithm.version4j.leetcode;

import com.only4.algorithm.version4j.extra.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return Collections.emptyList();
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        int layer = 0;
        List<Integer> result = new ArrayList<>();

        while (!deque.isEmpty()) {
            int size = deque.size();
            layer++;
            while (size-- != 0) {
                TreeNode polled = deque.pollFirst();
                if (layer > result.size()) {
                    result.add(polled.val);
                }
                if (polled.right != null) deque.add(polled.right);
                if (polled.left != null) deque.add(polled.left);
            }
        }
        return result;
    }
}
