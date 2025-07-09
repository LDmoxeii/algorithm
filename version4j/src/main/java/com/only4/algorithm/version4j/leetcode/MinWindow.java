package com.only4.algorithm.version4j.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhenyu.jiang
 */
public class MinWindow {
    public String minWindow(String s, String t) {

        Map<Character, Integer> matcher = new HashMap<>();
        Map<Character, Integer> searcher = new HashMap<>();

        for (char c : t.toCharArray()) {
            matcher.put(c, matcher.getOrDefault(c, 0) + 1);
        }

        char[] chars = s.toCharArray();
        int matchCount = 0;
        int L = 0;
        int minL = -1, minR = s.length() + 1;
        for (int R = 0; R < chars.length; R++) {
            char currentC = chars[R];

            if (matcher.containsKey(currentC)) {
                searcher.put(currentC, searcher.getOrDefault(currentC, 0) + 1);
                if (matcher.get(currentC).equals(searcher.get(currentC))) {
                    matchCount++;
                }
            }

            while (matchCount == matcher.size()) {
                if (R - L < minR - minL) {
                    minR = R;
                    minL = L;
                }
                char currentL = chars[L++];

                if (matcher.containsKey(currentL)) {
                    if (matcher.get(currentL).equals(searcher.get(currentL))) {
                        matchCount--;
                    }
                    searcher.put(currentL, searcher.get(currentL) - 1);
                }
            }
        }

        return minL == -1 ? "" : s.substring(minL, minR + 1);
    }
}
