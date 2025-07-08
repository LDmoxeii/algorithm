package com.only4.algorithm.version4j.leetcode;

import org.junit.jupiter.api.Test;

class ThreeSumTest {

    private ThreeSum target = new ThreeSum();

    @Test
    void TC001() {
        target.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
    }

    @Test
    void TC002() {
        target.threeSum(new int[]{2, -3, 0, -2, -5, -5, -4, 1, 2, -2, 2, 0, 2, -4, 5, 5, -10});
    }

}
