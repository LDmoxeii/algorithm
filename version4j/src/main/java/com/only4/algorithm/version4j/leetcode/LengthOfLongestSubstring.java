package com.only4.algorithm.version4j.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> windowChars = new HashSet<>();

        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);

            // 如果遇到重复字符，收缩左边界直到去除重复
            while (windowChars.contains(rightChar)) {
                windowChars.remove(s.charAt(left));
                left++;
            }

            // 将当前字符加入窗口
            windowChars.add(rightChar);
            // 更新最大长度
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
