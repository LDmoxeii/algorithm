package com.only4.algorithm.version4j.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MoveZeroesTest {

    MoveZeroes target = new MoveZeroes();

    @Test
    void case01() {
//        0,1,0,3,12
        int[] nums = {0, 1, 0, 3, 12};
        target.moveZeroes(nums);
        assertArrayEquals(new int[]{1, 3, 12, 0, 0}, nums);
    }

    @Test
    void case02() {
//        1, 0
        int[] nums = {1, 0};
        target.moveZeroes(nums);
        assertArrayEquals(new int[]{1, 0}, nums);
    }

    @Test
    void case03() {
//        2, 1
        int[] nums = {2, 1};
        target.moveZeroes(nums);
        assertArrayEquals(new int[]{2, 1}, nums);
    }

}
