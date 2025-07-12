package com.only4.algorithm.version4j.leetcode;

import com.only4.algorithm.version4j.extra.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LevelOrder {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return Collections.emptyList();

        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        List<List<Integer>> result = new ArrayList<>();

        deque.add(root);

        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> group = new ArrayList<>();

            while (size-- != 0) {
                TreeNode poll = deque.pollFirst();
                if (poll.left != null) deque.addLast(poll.left);
                if (poll.right != null) deque.addLast(poll.right);
                group.add(poll.val);
            }
            result.add(group);
        }
        return result;
    }

}
