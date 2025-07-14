package com.only4.algorithm.version4j.leetcode;

import com.only4.algorithm.version4j.extra.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Flatten的测试类
 * 测试LeetCode第114题：二叉树展开为链表
 */
public class FlattenTest {

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
     * 检查树是否已正确地展平为链表
     *
     * @param root           根节点
     * @param expectedValues 期望的展平后的值，按顺序排列
     * @return 是否正确展平
     */
    private boolean isCorrectlyFlattened(TreeNode root, int[] expectedValues) {
        int i = 0;
        TreeNode current = root;

        while (current != null && i < expectedValues.length) {
            if (current.val != expectedValues[i] || current.left != null) {
                return false;
            }
            current = current.right;
            i++;
        }

        // 确保遍历完了所有节点
        return current == null && i == expectedValues.length;
    }

    /**
     * 将树转换为字符串表示，方便调试
     *
     * @param root 树的根节点
     * @return 树的字符串表示
     */
    private String treeToString(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        TreeNode current = root;
        while (current != null) {
            sb.append(current.val);
            if (current.right != null) {
                sb.append(" -> ");
            }
            current = current.right;
        }

        sb.append("]");
        return sb.toString();
    }

    @Test
    public void testEmptyTree() {
        // 测试空树
        TreeNode root = null;

        Flatten solution = new Flatten();
        solution.flatten(root);

        assertNull(root, "Empty tree should remain null after flattening");
    }

    @Test
    public void testSingleNode() {
        // 测试只有根节点的树
        Integer[] input = {1};
        int[] expected = {1};

        TreeNode root = createTreeFromArray(input);
        Flatten solution = new Flatten();
        solution.flatten(root);

        assertTrue(isCorrectlyFlattened(root, expected),
                "Expected flattened tree: " + Arrays.toString(expected) + ", but got: " + treeToString(root));
    }

    @Test
    public void testWithLeftAndRightChild() {
        // 测试有左右子节点的树
        Integer[] input = {1, 2, 3};
        int[] expected = {1, 2, 3};

        TreeNode root = createTreeFromArray(input);
        Flatten solution = new Flatten();
        solution.flatten(root);

        assertTrue(isCorrectlyFlattened(root, expected),
                "Expected flattened tree: " + Arrays.toString(expected) + ", but got: " + treeToString(root));
    }

    @Test
    public void testCompleteTree() {
        // 测试完全二叉树
        Integer[] input = {1, 2, 3, 4, 5, 6, 7};
        int[] expected = {1, 2, 4, 5, 3, 6, 7};

        TreeNode root = createTreeFromArray(input);
        Flatten solution = new Flatten();
        solution.flatten(root);

        assertTrue(isCorrectlyFlattened(root, expected),
                "Expected flattened tree: " + Arrays.toString(expected) + ", but got: " + treeToString(root));
    }
}
