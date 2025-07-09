package com.only4.algorithm.version4j.leetcode;

import org.junit.jupiter.api.Test;

class MaxSubArrayTest {

    MaxSubArray target = new MaxSubArray();

    @Test
    void TC001() {
        target.maxSubArray(new int[]{5, 4, -1, 7, 8});
    }

    @Test
    void TC002() {
        target.maxSubArray(new int[]{-1});
    }

}
