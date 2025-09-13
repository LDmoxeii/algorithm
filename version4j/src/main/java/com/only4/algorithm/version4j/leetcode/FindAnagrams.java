package com.only4.algorithm.version4j.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        if (s.length() < p.length()) return result;

        // 统计目标字符串的字符频率
        int[] targetFreq = new int[26];
        for (char c : p.toCharArray()) {
            targetFreq[c - 'a']++;
        }

        // 统计滑动窗口的字符频率
        int[] windowFreq = new int[26];
        int windowSize = p.length();

        // 初始化第一个窗口
        for (int i = 0; i < windowSize; i++) {
            windowFreq[s.charAt(i) - 'a']++;
        }

        // 检查第一个窗口
        if (Arrays.equals(targetFreq, windowFreq)) {
            result.add(0);
        }

        // 滑动窗口
        for (int right = windowSize; right < s.length(); right++) {
            // 添加右边新字符
            windowFreq[s.charAt(right) - 'a']++;
            // 移除左边旧字符
            int left = right - windowSize;
            windowFreq[s.charAt(left) - 'a']--;

            // 检查当前窗口是否为异位词
            if (Arrays.equals(targetFreq, windowFreq)) {
                result.add(left + 1);
            }
        }

        return result;
    }
}
