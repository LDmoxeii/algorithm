package com.only4.algorithm.version4j.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Merge {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals;

        // 按区间起始位置排序
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));

        List<int[]> mergedIntervals = new ArrayList<>();
        mergedIntervals.add(intervals[0]); // 添加第一个区间

        for (int i = 1; i < intervals.length; i++) {
            int[] currentInterval = intervals[i];
            int[] lastMergedInterval = mergedIntervals.get(mergedIntervals.size() - 1);

            // 如果当前区间与上一个区间重叠
            if (currentInterval[0] <= lastMergedInterval[1]) {
                // 合并区间：更新结束位置为两者的最大值
                lastMergedInterval[1] = Math.max(lastMergedInterval[1], currentInterval[1]);
            } else {
                // 不重叠，添加新区间
                mergedIntervals.add(currentInterval);
            }
        }

        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }
}
