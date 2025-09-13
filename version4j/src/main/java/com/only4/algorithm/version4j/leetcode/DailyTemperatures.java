package com.only4.algorithm.version4j.leetcode;

import java.util.ArrayDeque;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int[] result = new int[temperatures.length];

        for (int day = 0; day < temperatures.length; day++) {
            while (!stack.isEmpty() && temperatures[stack.peekLast()] < temperatures[day]) {
                int prevDay = stack.removeLast();
                result[prevDay] = day - prevDay;
            }
            stack.addLast(day);
        }

        return result;
    }
}
