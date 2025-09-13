package com.only4.algorithm.version4j.leetcode;

import com.only4.algorithm.version4j.extra.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return Collections.emptyList();

        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        List<List<Integer>> result = new ArrayList<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            int currentLevelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();

            while (currentLevelSize-- > 0) {
                TreeNode currentNode = queue.pollFirst();
                currentLevel.add(currentNode.val);

                if (currentNode.left != null) queue.addLast(currentNode.left);
                if (currentNode.right != null) queue.addLast(currentNode.right);
            }
            result.add(currentLevel);
        }
        return result;
    }
}
