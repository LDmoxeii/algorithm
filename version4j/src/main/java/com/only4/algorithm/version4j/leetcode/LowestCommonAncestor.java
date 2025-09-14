package com.only4.algorithm.version4j.leetcode;

import com.only4.algorithm.version4j.extra.TreeNode;

/**
 * @author zhenyu.jiang
 */
public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode currentNode, TreeNode p, TreeNode q) {
        // 判断点1：基础情况 - 发现LCA候选
        // 空节点返回null，目标节点返回自身（节点可以是自己的祖先）
        if (currentNode == null || currentNode == p || currentNode == q) {
            return currentNode;  // 生成LCA候选并向上传递
        }

        // 递归搜索左右子树
        TreeNode leftCandidate = lowestCommonAncestor(currentNode.left, p, q);
        TreeNode rightCandidate = lowestCommonAncestor(currentNode.right, p, q);

        // 判断点2：分岔点 - p和q分别在左右子树 直接发现LCA
        if (leftCandidate != null && rightCandidate != null) {
            return currentNode;
        }

        // 判断点3：传递点 - 将找到的LCA候选向上传递
        // 只有一个子树找到了LCA，继续向上传递
        return leftCandidate != null ? leftCandidate : rightCandidate;
    }
}
