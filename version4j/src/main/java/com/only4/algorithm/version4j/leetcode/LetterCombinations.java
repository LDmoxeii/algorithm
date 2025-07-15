package com.only4.algorithm.version4j.leetcode;

import java.util.*;

/**
 * @author zhenyu.jiang
 */
public class LetterCombinations {

    static Map<Character, List<Character>> digitsMap;

    static {
        digitsMap = new HashMap<>();
        digitsMap.put('2', List.of('a', 'b', 'c'));
        digitsMap.put('3', List.of('d', 'e', 'f'));
        digitsMap.put('4', List.of('g', 'h', 'i'));
        digitsMap.put('5', List.of('j', 'k', 'l'));
        digitsMap.put('6', List.of('m', 'n', 'o'));
        digitsMap.put('7', List.of('p', 'q', 'r', 's'));
        digitsMap.put('8', List.of('t', 'u', 'v'));
        digitsMap.put('9', List.of('w', 'x', 'y', 'z'));
    }

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return Collections.emptyList();
        List<String> result = new ArrayList<>();
        StringBuilder sequence = new StringBuilder(digits.length());
        dfs(digits, 0, sequence, result);
        return result;
    }

    public void dfs(String digits, int start, StringBuilder sequence, List<String> result) {
        if (sequence.length() == digits.length()) {
            result.add(sequence.toString());
            return;
        }

        for (Character c : digitsMap.get(digits.charAt(start))) {
            sequence.append(c);
            dfs(digits, start + 1, sequence, result);
            sequence.deleteCharAt(sequence.length() - 1);
        }
    }
}
