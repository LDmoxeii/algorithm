package com.only4.algorithm.version4j.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> memo = new HashSet<>();

        char[] chars = s.toCharArray();
        int slow = 0;

        int result = 0;

        for (int fast = 0; fast < chars.length; fast++) {
            while (memo.contains(chars[fast])) memo.remove(chars[slow++]);
            memo.add(chars[fast]);
            result = Math.max(result, fast - slow + 1);
        }

        return result;
    }
}
