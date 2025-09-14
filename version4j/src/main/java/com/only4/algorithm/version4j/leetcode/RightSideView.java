package com.only4.algorithm.version4j.leetcode;

import com.only4.algorithm.version4j.extra.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        // 处理空树情况
        if (root == null) return Collections.emptyList();

        // 使用双端队列进行层序遍历
        ArrayDeque<TreeNode> levelQueue = new ArrayDeque<>();
        levelQueue.add(root);
        List<Integer> rightViewResult = new ArrayList<>();

        // 逐层遍历二叉树
        while (!levelQueue.isEmpty()) {
            int currentLevelSize = levelQueue.size();

            // 遍历当前层的所有节点
            for (int nodeIndex = 0; nodeIndex < currentLevelSize; nodeIndex++) {
                TreeNode currentNode = levelQueue.pollFirst();

                // 记录每层最右侧节点的值（第一个处理的节点）
                if (nodeIndex == 0) {
                    rightViewResult.add(currentNode.val);
                }

                // 先添加右子节点，再添加左子节点（确保右节点优先处理）
                if (currentNode.right != null) {
                    levelQueue.add(currentNode.right);
                }
                if (currentNode.left != null) {
                    levelQueue.add(currentNode.left);
                }
            }
        }

        return rightViewResult;
    }
}
