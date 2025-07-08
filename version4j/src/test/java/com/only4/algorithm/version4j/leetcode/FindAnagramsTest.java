package com.only4.algorithm.version4j.leetcode;

import org.junit.jupiter.api.Test;

class FindAnagramsTest {

    private FindAnagrams target = new FindAnagrams();

    @Test
    void TC001() {
        target.findAnagrams("cbaebabacd", "abc");
    }

    @Test
    void TC002() {
        target.findAnagrams("abab", "ab");
    }

    @Test
    void TC003() {
        target.findAnagrams("baa", "aa");
    }

}
