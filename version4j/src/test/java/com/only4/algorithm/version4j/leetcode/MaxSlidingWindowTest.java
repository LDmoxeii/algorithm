package com.only4.algorithm.version4j.leetcode;

import org.junit.jupiter.api.Test;

class MaxSlidingWindowTest {

    private MaxSlidingWindow target = new MaxSlidingWindow();

    @Test
    void TC001() {
        target.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
    }

    @Test
    void TC002() {
        target.maxSlidingWindow(new int[]{1, 3, 1, 2, 0, 5}, 3);
    }

    @Test
    void TC003() {
        target.maxSlidingWindow(new int[]{9, 10, 9, -7, -4, -8, 2, -6}, 5);
    }

}
