package com.only4.algorithm.version4j.leetcode;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class RotateTest {

    Rotate target = new Rotate();


    @Nested
    class Rotate01 {
        @Test
        void TC001() {
            target.rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 3);
        }
    }

    @Nested
    class Rotate02 {

        @Test
        void TC001() {
            target.rotate(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        }
    }


}
