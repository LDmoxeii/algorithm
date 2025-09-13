package com.only4.algorithm.version4j.extra;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class MinimizeMaxDifference {

    public static int minimizeMaxDiff(int[] nums, int operations) {
        // 使用优先队列（最小堆）来高效找到最小值
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // 将所有元素加入最小堆
        for (int num : nums) {
            minHeap.offer(num);
        }

        // 执行指定次数的操作
        for (int i = 0; i < operations; i++) {
            // 取出最小值，加1后重新放入堆中
            int minVal = minHeap.poll();
            minHeap.offer(minVal + 1);
        }

        // 计算最终的最大绝对值差
        int min = Collections.min(minHeap);
        int max = Collections.max(minHeap);

        return max - min;
    }

    public static void main(String[] args) {
        // 测试示例：[3, 1, 5, 4, 1] 操作 3 次
        int[] nums = {3, 1, 5, 4, 1};
        int operations = 3;

        System.out.println("输入数组: " + Arrays.toString(nums));
        System.out.println("操作次数: " + operations);

        // 显示操作过程
        int[] arr = nums.clone();
        System.out.println("操作过程:");
        System.out.println("初始: " + Arrays.toString(arr));

        for (int i = 0; i < operations; i++) {
            // 找到最小值索引
            int minVal = Integer.MAX_VALUE;
            int minIdx = -1;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] < minVal) {
                    minVal = arr[j];
                    minIdx = j;
                }
            }
            arr[minIdx]++;
            System.out.println("操作" + (i + 1) + ": " + Arrays.toString(arr) +
                    " (对索引 " + minIdx + " 执行 +1)");
        }

        int result = minimizeMaxDiff(nums, operations);
        System.out.println("最终最大绝对值差: " + result);
    }
}
