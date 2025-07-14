package com.only4.algorithm.version4j.leetcode;

import com.only4.algorithm.version4j.extra.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * MaxPathSum的测试类
 * 测试LeetCode第124题：二叉树中的最大路径和
 */
public class MaxPathSumTest {

    /**
     * 根据数组创建二叉树，数组中的null表示没有节点
     *
     * @param values 节点值数组，按层序遍历顺序排列，null表示没有节点
     * @return 根节点
     */
    private TreeNode createTreeFromArray(Integer[] values) {
        if (values == null || values.length == 0 || values[0] == null) {
            return null;
        }

        TreeNode root = new TreeNode(values[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;
        while (!queue.isEmpty() && i < values.length) {
            TreeNode node = queue.poll();

            // 左子节点
            if (i < values.length && values[i] != null) {
                node.left = new TreeNode(values[i]);
                queue.offer(node.left);
            }
            i++;

            // 右子节点
            if (i < values.length && values[i] != null) {
                node.right = new TreeNode(values[i]);
                queue.offer(node.right);
            }
            i++;
        }

        return root;
    }

    /**
     * 测试简单的树结构
     * 例如：
     * 1
     * / \
     * 2   3
     */
    @Test
    public void testSimpleTree() {
        Integer[] nodes = {1, 2, 3};
        TreeNode root = createTreeFromArray(nodes);

        MaxPathSum solution = new MaxPathSum();
        int maxSum = solution.maxPathSum(root);

        // 最大路径和应为 1+2+3 = 6
        assertEquals(6, maxSum);
    }

    /**
     * 测试含有负值的树
     * 例如：
     * -10
     * /  \
     * 9    20
     * / \
     * 15  7
     */
    @Test
    public void testTreeWithNegativeValues() {
        Integer[] nodes = {-10, 9, 20, null, null, 15, 7};
        TreeNode root = createTreeFromArray(nodes);

        MaxPathSum solution = new MaxPathSum();
        int maxSum = solution.maxPathSum(root);

        // 最大路径和应为 20+15+7 = 42
        assertEquals(42, maxSum);
    }

    /**
     * 测试单节点树
     */
    @Test
    public void testSingleNodeTree() {
        Integer[] nodes = {5};
        TreeNode root = createTreeFromArray(nodes);

        MaxPathSum solution = new MaxPathSum();
        int maxSum = solution.maxPathSum(root);

        // 最大路径和应为 5
        assertEquals(5, maxSum);
    }

    /**
     * 测试最大路径不通过根节点的情况
     * 例如：
     * 1
     * / \
     * 2   3
     * / \
     * 4   5
     * 最大路径为 4->2->5，和为 11
     */
    @Test
    public void testMaxPathNotThroughRoot() {
        Integer[] nodes = {1, 2, 3, 4, 5};
        TreeNode root = createTreeFromArray(nodes);

        MaxPathSum solution = new MaxPathSum();
        int maxSum = solution.maxPathSum(root);

        // 最大路径和应为 4+2+5 = 11
        assertEquals(11, maxSum);
    }

    /**
     * 测试路径中全是负数的情况
     * 例如：
     * 2
     * /
     * -1
     */
    @Test
    public void testAllNegativeValues() {
        Integer[] nodes = {2, -1};
        TreeNode root = createTreeFromArray(nodes);

        MaxPathSum solution = new MaxPathSum();
        int maxSum = solution.maxPathSum(root);

        // 最大路径和应为单个节点 2
        assertEquals(2, maxSum);
    }

    /**
     * 测试最大路径只包含一条边的情况
     * 例如：
     * -10
     * /  \
     * 9    20
     * / \   / \
     * -3 -4 15  7
     */
    @Test
    public void testMaxPathAsSingleEdge() {
        Integer[] nodes = {-10, 9, 20, -3, -4, 15, 7};
        TreeNode root = createTreeFromArray(nodes);

        MaxPathSum solution = new MaxPathSum();
        int maxSum = solution.maxPathSum(root);

        // 最大路径和应为 20+15 = 35 或 20+7 = 27，取较大的 35
        assertEquals(42, maxSum);
    }

    /**
     * 测试分支有较大负值的情况
     * 例如：
     * 10
     * /  \
     * -20  30
     * /  \
     * 40   50
     */
    @Test
    public void testBranchWithLargeNegativeValue() {
        Integer[] nodes = {10, -20, 30, 40, 50};
        TreeNode root = createTreeFromArray(nodes);

        MaxPathSum solution = new MaxPathSum();
        int maxSum = solution.maxPathSum(root);

        // 最大路径和可能是 40+(-20)+50 = 70，或者就是 30
        assertEquals(70, maxSum);
    }
}
