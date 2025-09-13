package com.only4.algorithm.version4j.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhenyu.jiang
 */
public class Partition {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        ArrayDeque<String> path = new ArrayDeque<>();
        backtrack(s, 0, path, result);
        return result;
    }

    public void backtrack(String s, int startIndex, ArrayDeque<String> path, List<List<String>> result) {
        if (startIndex == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int endIndex = startIndex; endIndex < s.length(); endIndex++) {
            if (isPalindrome(s, startIndex, endIndex)) {
                path.addLast(s.substring(startIndex, endIndex + 1));
                backtrack(s, endIndex + 1, path, result);
                path.removeLast();
            }
        }
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) return false;
        }
        return true;
    }
}
