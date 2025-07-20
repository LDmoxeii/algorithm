package com.only4.algorithm.version4j.leetcode;

import java.util.ArrayDeque;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int[] result = new int[temperatures.length];
        for (int day = 0; day < temperatures.length; day++) {
            while (!deque.isEmpty() && temperatures[deque.peekLast()] < temperatures[day]) {
                result[deque.peekLast()] = day - deque.removeLast();
            }
            deque.add(day);
        }

        return result;
    }
}
