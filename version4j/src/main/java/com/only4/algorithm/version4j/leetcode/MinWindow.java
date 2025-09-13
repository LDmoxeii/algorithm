package com.only4.algorithm.version4j.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhenyu.jiang
 */
public class MinWindow {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        // 统计目标字符串中每个字符的出现频率
        Map<Character, Integer> targetFreq = new HashMap<>();
        for (char c : t.toCharArray()) {
            targetFreq.put(c, targetFreq.getOrDefault(c, 0) + 1);
        }

        // 统计当前窗口中每个字符的出现频率
        Map<Character, Integer> windowFreq = new HashMap<>();

        int left = 0;
        int matchCount = 0; // 已匹配的字符种类数
        int minLength = Integer.MAX_VALUE;
        int minStart = 0;

        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);

            // 如果当前字符在目标字符串中
            if (targetFreq.containsKey(rightChar)) {
                windowFreq.put(rightChar, windowFreq.getOrDefault(rightChar, 0) + 1);

                // 如果当前字符的频率刚好匹配目标频率
                if (windowFreq.get(rightChar).equals(targetFreq.get(rightChar))) {
                    matchCount++;
                }
            }

            // 当所有字符都匹配时，尝试收缩窗口
            while (matchCount == targetFreq.size()) {
                // 更新最小覆盖子串
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    minStart = left;
                }

                char leftChar = s.charAt(left);
                left++;

                // 如果左边界字符在目标字符串中
                if (targetFreq.containsKey(leftChar)) {
                    // 如果移除前字符频率刚好匹配，移除后就不匹配了
                    if (windowFreq.get(leftChar).equals(targetFreq.get(leftChar))) {
                        matchCount--;
                    }
                    windowFreq.put(leftChar, windowFreq.get(leftChar) - 1);
                }
            }
        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLength);
    }
}
