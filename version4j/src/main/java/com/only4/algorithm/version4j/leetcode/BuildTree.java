package com.only4.algorithm.version4j.leetcode;

import com.only4.algorithm.version4j.extra.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class BuildTree {
    // 中序遍历值到索引的映射，优化查找效率
    private Map<Integer, Integer> inorderIndexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 创建中序遍历的索引映射，避免重复查找
        inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        return buildTreeHelper(preorder, inorder,
                0, preorder.length - 1,
                0, inorder.length - 1);
    }

    private TreeNode buildTreeHelper(int[] preorder, int[] inorder,
                                     int preorderStart, int preorderEnd,
                                     int inorderStart, int inorderEnd) {
        // 边界条件：前序遍历范围为空
        if (preorderStart > preorderEnd) return null;

        // 前序遍历的第一个元素是根节点
        int rootValue = preorder[preorderStart];
        TreeNode root = new TreeNode(rootValue);

        // 在中序遍历中找到根节点的位置
        int inorderRootIndex = inorderIndexMap.get(rootValue);

        // 计算左子树的大小
        int leftSubtreeSize = inorderRootIndex - inorderStart;

        // 递归构建左子树
        TreeNode leftSubtree = buildTreeHelper(preorder, inorder,
                preorderStart + 1,                      // 左子树前序遍历的起始位置
                preorderStart + leftSubtreeSize,        // 左子树前序遍历的结束位置
                inorderStart,                           // 左子树中序遍历的起始位置
                inorderRootIndex - 1);                  // 左子树中序遍历的结束位置

        // 递归构建右子树
        TreeNode rightSubtree = buildTreeHelper(preorder, inorder,
                preorderStart + leftSubtreeSize + 1,    // 右子树前序遍历的起始位置
                preorderEnd,                            // 右子树前序遍历的结束位置
                inorderRootIndex + 1,                   // 右子树中序遍历的起始位置
                inorderEnd);                            // 右子树中序遍历的结束位置

        // 连接左右子树
        root.left = leftSubtree;
        root.right = rightSubtree;

        return root;
    }
}
