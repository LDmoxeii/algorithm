package com.only4.algorithm.version4j.leetcode;

/**
 * @author zhenyu.jiang
 */
public class Rotate {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n; // 避免无效轮转

        if (k == 0) return;

        // 反转整个数组
        reverse(nums, 0, n - 1);
        // 反转前k个元素
        reverse(nums, 0, k - 1);
        // 反转后n-k个元素
        reverse(nums, k, n - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // 分层处理，每次处理一个同心圆环
        for (int layer = 0; layer < n / 2; layer++) {
            int first = layer;
            int last = n - 1 - layer;

            // 处理当前层的每个位置
            for (int offset = first; offset < last; offset++) {
                // 保存top位置的值
                int temp = matrix[first][offset];

                // left → top
                matrix[first][offset] = matrix[last - (offset - first)][first];

                // bottom → left
                matrix[last - (offset - first)][first] = matrix[last][last - (offset - first)];

                // right → bottom
                matrix[last][last - (offset - first)] = matrix[offset][last];

                // temp(top) → right
                matrix[offset][last] = temp;
            }
        }
    }
}
