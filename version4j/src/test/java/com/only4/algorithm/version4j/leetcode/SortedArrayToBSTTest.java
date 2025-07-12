package com.only4.algorithm.version4j.leetcode;

import com.only4.algorithm.version4j.extra.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SortedArrayToBSTTest {

    @Test
    public void testEmptyArray() {
        SortedArrayToBST solution = new SortedArrayToBST();
        TreeNode result = solution.sortedArrayToBST(new int[]{});
        assertNull(result);
    }

    @Test
    public void testSingleElementArray() {
        SortedArrayToBST solution = new SortedArrayToBST();
        TreeNode result = solution.sortedArrayToBST(new int[]{5});
        assertEquals(5, result.val);
        assertNull(result.left);
        assertNull(result.right);
    }

    @Test
    public void testMultipleElementArray() {
        SortedArrayToBST solution = new SortedArrayToBST();
        int[] nums = {-10, -3, 0, 5, 9};
        TreeNode result = solution.sortedArrayToBST(nums);

        // 验证结果是否为平衡二叉树
        assertTrue(isBalanced(result));

        // 验证结果是否为二叉搜索树
        assertTrue(isValidBST(result, null, null));

        // 验证树中包含所有数组元素
        for (int num : nums) {
            assertTrue(containsValue(result, num));
        }
    }

    @Test
    public void testEvenLengthArray() {
        SortedArrayToBST solution = new SortedArrayToBST();
        int[] nums = {1, 2, 3, 4, 5, 6};
        TreeNode result = solution.sortedArrayToBST(nums);

        // 验证结果是否为平衡二叉树
        assertTrue(isBalanced(result));

        // 验证结果是否为二叉搜索树
        assertTrue(isValidBST(result, null, null));

        // 验证树中包含所有数组元素
        for (int num : nums) {
            assertTrue(containsValue(result, num));
        }
    }

    // 辅助方法：检查树是否平衡（左右子树高度差不超过1）
    private boolean isBalanced(TreeNode root) {
        if (root == null) return true;

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        return Math.abs(leftHeight - rightHeight) <= 1 &&
                isBalanced(root.left) &&
                isBalanced(root.right);
    }

    // 辅助方法：获取树的高度
    private int getHeight(TreeNode node) {
        if (node == null) return 0;
        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }

    // 辅助方法：验证是否为有效的二叉搜索树
    private boolean isValidBST(TreeNode node, Integer min, Integer max) {
        if (node == null) return true;

        // 检查当前节点是否符合BST的规则
        if ((min != null && node.val <= min) || (max != null && node.val >= max)) {
            return false;
        }

        // 递归检查左右子树
        return isValidBST(node.left, min, node.val) &&
                isValidBST(node.right, node.val, max);
    }

    // 辅助方法：检查树是否包含特定值
    private boolean containsValue(TreeNode node, int value) {
        if (node == null) return false;
        if (node.val == value) return true;
        return containsValue(node.left, value) || containsValue(node.right, value);
    }
}
