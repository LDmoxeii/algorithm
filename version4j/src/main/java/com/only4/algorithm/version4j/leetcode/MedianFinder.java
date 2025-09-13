package com.only4.algorithm.version4j.leetcode;

import java.util.PriorityQueue;

class MedianFinder {
    // 大顶堆，存储较小的一半数字
    private PriorityQueue<Integer> maxHeap;
    // 小顶堆，存储较大的一半数字
    private PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        maxHeap = new PriorityQueue<>((a, b) -> b - a); // 大顶堆
        minHeap = new PriorityQueue<>((a, b) -> a - b); // 小顶堆
    }

    public void addNum(int num) {
        // 如果两个堆大小相等，添加到大顶堆
        if (maxHeap.size() == minHeap.size()) {
            // 为了保持大顶堆中的元素都小于小顶堆中的元素
            // 先将num添加到小顶堆，然后将小顶堆的最小值移到大顶堆
            minHeap.offer(num);
            maxHeap.offer(minHeap.poll());
        } else {
            // 如果大顶堆比小顶堆大，添加到小顶堆
            // 同样，为了保持有序性，先添加到大顶堆，再将大顶堆的最大值移到小顶堆
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
        }
    }

    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            // 如果两个堆大小相等，中位数是两个堆顶元素的平均值
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else {
            // 如果大顶堆比小顶堆大，中位数是大顶堆的堆顶元素
            return maxHeap.peek();
        }
    }
}
