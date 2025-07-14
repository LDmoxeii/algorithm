package com.only4.algorithm.version4j.leetcode;

import com.only4.algorithm.version4j.extra.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * BuildTree的测试类
 * 测试LeetCode第105题：从前序与中序遍历序列构造二叉树
 */
public class BuildTreeTest {

    /**
     * 执行二叉树的前序遍历
     *
     * @param root 根节点
     * @return 前序遍历的结果列表
     */
    private List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorderHelper(root, result);
        return result;
    }

    /**
     * 前序遍历的辅助方法
     *
     * @param node   当前节点
     * @param result 结果列表
     */
    private void preorderHelper(TreeNode node, List<Integer> result) {
        if (node == null) return;
        result.add(node.val);
        preorderHelper(node.left, result);
        preorderHelper(node.right, result);
    }

    /**
     * 执行二叉树的中序遍历
     *
     * @param root 根节点
     * @return 中序遍历的结果列表
     */
    private List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderHelper(root, result);
        return result;
    }

    /**
     * 中序遍历的辅助方法
     *
     * @param node   当前节点
     * @param result 结果列表
     */
    private void inorderHelper(TreeNode node, List<Integer> result) {
        if (node == null) return;
        inorderHelper(node.left, result);
        result.add(node.val);
        inorderHelper(node.right, result);
    }

    /**
     * 将树转换为字符串表示，方便调试
     *
     * @param root 树的根节点
     * @return 树的字符串表示
     */
    private String treeToString(TreeNode root) {
        if (root == null) return "null";
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        sb.append(" [");
        sb.append(treeToString(root.left));
        sb.append(", ");
        sb.append(treeToString(root.right));
        sb.append("]");
        return sb.toString();
    }

    /**
     * 测试基本功能：构建一个简单的树
     */
    @Test
    public void testBuildSimpleTree() {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        BuildTree solution = new BuildTree();
        TreeNode root = solution.buildTree(preorder, inorder);

        // 验证树的结构
        assertEquals(3, root.val);
        assertEquals(9, root.left.val);
        assertNull(root.left.left);
        assertNull(root.left.right);
        assertEquals(20, root.right.val);
        assertEquals(15, root.right.left.val);
        assertEquals(7, root.right.right.val);

        // 验证重新遍历的结果是否与输入一致
        List<Integer> resultPreorder = preorderTraversal(root);
        List<Integer> resultInorder = inorderTraversal(root);

        assertArrayEquals(preorder, resultPreorder.stream().mapToInt(i -> i).toArray());
        assertArrayEquals(inorder, resultInorder.stream().mapToInt(i -> i).toArray());
    }

    /**
     * 测试只有一个节点的树
     */
    @Test
    public void testSingleNodeTree() {
        int[] preorder = {1};
        int[] inorder = {1};

        BuildTree solution = new BuildTree();
        TreeNode root = solution.buildTree(preorder, inorder);

        assertEquals(1, root.val);
        assertNull(root.left);
        assertNull(root.right);

        List<Integer> resultPreorder = preorderTraversal(root);
        List<Integer> resultInorder = inorderTraversal(root);

        assertArrayEquals(preorder, resultPreorder.stream().mapToInt(i -> i).toArray());
        assertArrayEquals(inorder, resultInorder.stream().mapToInt(i -> i).toArray());
    }

    /**
     * 测试左侧倾斜的树
     */
    @Test
    public void testLeftSkewedTree() {
        int[] preorder = {1, 2, 3, 4};
        int[] inorder = {4, 3, 2, 1};

        BuildTree solution = new BuildTree();
        TreeNode root = solution.buildTree(preorder, inorder);

        assertEquals(1, root.val);
        assertEquals(2, root.left.val);
        assertEquals(3, root.left.left.val);
        assertEquals(4, root.left.left.left.val);
        assertNull(root.right);
        assertNull(root.left.right);
        assertNull(root.left.left.right);

        List<Integer> resultPreorder = preorderTraversal(root);
        List<Integer> resultInorder = inorderTraversal(root);

        assertArrayEquals(preorder, resultPreorder.stream().mapToInt(i -> i).toArray());
        assertArrayEquals(inorder, resultInorder.stream().mapToInt(i -> i).toArray());
    }

    /**
     * 测试右侧倾斜的树
     */
    @Test
    public void testRightSkewedTree() {
        int[] preorder = {1, 2, 3, 4};
        int[] inorder = {1, 2, 3, 4};

        BuildTree solution = new BuildTree();
        TreeNode root = solution.buildTree(preorder, inorder);

        assertEquals(1, root.val);
        assertNull(root.left);
        assertEquals(2, root.right.val);
        assertNull(root.right.left);
        assertEquals(3, root.right.right.val);
        assertEquals(4, root.right.right.right.val);

        List<Integer> resultPreorder = preorderTraversal(root);
        List<Integer> resultInorder = inorderTraversal(root);

        assertArrayEquals(preorder, resultPreorder.stream().mapToInt(i -> i).toArray());
        assertArrayEquals(inorder, resultInorder.stream().mapToInt(i -> i).toArray());
    }

    /**
     * 测试复杂的平衡树
     */
    @Test
    public void testBalancedTree() {
        int[] preorder = {1, 2, 4, 5, 3, 6, 7};
        int[] inorder = {4, 2, 5, 1, 6, 3, 7};

        BuildTree solution = new BuildTree();
        TreeNode root = solution.buildTree(preorder, inorder);

        assertEquals(1, root.val);
        assertEquals(2, root.left.val);
        assertEquals(4, root.left.left.val);
        assertEquals(5, root.left.right.val);
        assertEquals(3, root.right.val);
        assertEquals(6, root.right.left.val);
        assertEquals(7, root.right.right.val);

        List<Integer> resultPreorder = preorderTraversal(root);
        List<Integer> resultInorder = inorderTraversal(root);

        assertArrayEquals(preorder, resultPreorder.stream().mapToInt(i -> i).toArray());
        assertArrayEquals(inorder, resultInorder.stream().mapToInt(i -> i).toArray());
    }

    /**
     * 测试只有左子树的节点
     */
    @Test
    public void testNodeWithOnlyLeftChild() {
        int[] preorder = {1, 2};
        int[] inorder = {2, 1};

        BuildTree solution = new BuildTree();
        TreeNode root = solution.buildTree(preorder, inorder);

        assertEquals(1, root.val);
        assertEquals(2, root.left.val);
        assertNull(root.right);

        List<Integer> resultPreorder = preorderTraversal(root);
        List<Integer> resultInorder = inorderTraversal(root);

        assertArrayEquals(preorder, resultPreorder.stream().mapToInt(i -> i).toArray());
        assertArrayEquals(inorder, resultInorder.stream().mapToInt(i -> i).toArray());
    }

    /**
     * 测试只有右子树的节点
     */
    @Test
    public void testNodeWithOnlyRightChild() {
        int[] preorder = {1, 2};
        int[] inorder = {1, 2};

        BuildTree solution = new BuildTree();
        TreeNode root = solution.buildTree(preorder, inorder);

        assertEquals(1, root.val);
        assertNull(root.left);
        assertEquals(2, root.right.val);

        List<Integer> resultPreorder = preorderTraversal(root);
        List<Integer> resultInorder = inorderTraversal(root);

        assertArrayEquals(preorder, resultPreorder.stream().mapToInt(i -> i).toArray());
        assertArrayEquals(inorder, resultInorder.stream().mapToInt(i -> i).toArray());
    }
}
