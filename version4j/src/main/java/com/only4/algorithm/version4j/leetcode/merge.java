package com.only4.algorithm.version4j.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author zhenyu.jiang
 */
public class merge {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 1) return intervals;
        Arrays.sort(intervals, Comparator.comparingInt(p -> p[0]));
        List<int[]> result = new ArrayList<>();
        for (int i = 1; i < intervals.length; i++) {
            int size = result.size();
            if (!result.isEmpty() && result.get(size - 1)[1] >= intervals[i][0]) {
                result.get(size - 1)[1] = Math.max(result.get(size - 1)[1], intervals[i][1]);
            } else {
                result.add(intervals[i]);
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}
