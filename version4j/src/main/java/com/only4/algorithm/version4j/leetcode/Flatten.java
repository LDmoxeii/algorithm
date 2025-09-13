package com.only4.algorithm.version4j.leetcode;

import com.only4.algorithm.version4j.extra.TreeNode;

/**
 * @author zhenyu.jiang
 */
public class Flatten {
    public void flatten(TreeNode root) {
        if (root == null) return;

        TreeNode leftSubtree = root.left;
        TreeNode rightSubtree = root.right;

        // 先将左右子树分别展平
        flatten(leftSubtree);
        flatten(rightSubtree);

        // 将左子树接到根节点的右侧
        root.left = null; // 将左指针设为null

        if (leftSubtree != null) {
            // 将左子树接到右侧
            root.right = leftSubtree;

            // 找到左子树展平后的最右节点
            TreeNode current = leftSubtree;
            while (current.right != null) {
                current = current.right;
            }

            // 将原来的右子树接到当前右侧末尾
            current.right = rightSubtree;
        } else {
            // 如果没有左子树，保持原来的右子树
            root.right = rightSubtree;
        }
    }
}
