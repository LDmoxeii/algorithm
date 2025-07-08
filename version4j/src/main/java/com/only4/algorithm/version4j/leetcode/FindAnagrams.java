package com.only4.algorithm.version4j.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        int[] matcher = new int[26];
        for (char c : p.toCharArray()) {
            matcher[c - 'a']++;
        }
        int slow = 0;

        List<Integer> result = new ArrayList<>();

        char[] chars = s.toCharArray();
        for (int fast = 0; fast < chars.length; fast++) {
            --matcher[chars[fast] - 'a'];
            while (slow < fast && (matcher[chars[fast] - 'a'] < 0 || matcher[chars[slow] - 'a'] < 0))
                matcher[chars[slow++] - 'a']++;
            if (Arrays.stream(matcher).allMatch(it -> it == 0)) {
                result.add(slow);
            }
        }
        return result;
    }
}
