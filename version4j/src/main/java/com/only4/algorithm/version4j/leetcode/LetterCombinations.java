package com.only4.algorithm.version4j.leetcode;

import java.util.*;

/**
 * @author zhenyu.jiang
 */
public class LetterCombinations {

    static Map<Character, List<Character>> phoneMap;

    static {
        phoneMap = new HashMap<>();
        phoneMap.put('2', List.of('a', 'b', 'c'));
        phoneMap.put('3', List.of('d', 'e', 'f'));
        phoneMap.put('4', List.of('g', 'h', 'i'));
        phoneMap.put('5', List.of('j', 'k', 'l'));
        phoneMap.put('6', List.of('m', 'n', 'o'));
        phoneMap.put('7', List.of('p', 'q', 'r', 's'));
        phoneMap.put('8', List.of('t', 'u', 'v'));
        phoneMap.put('9', List.of('w', 'x', 'y', 'z'));
    }

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return Collections.emptyList();
        List<String> result = new ArrayList<>();
        StringBuilder path = new StringBuilder(digits.length());
        backtrack(digits, 0, path, result);
        return result;
    }

    public void backtrack(String digits, int index, StringBuilder path, List<String> result) {
        if (path.length() == digits.length()) {
            result.add(path.toString());
            return;
        }

        for (Character letter : phoneMap.get(digits.charAt(index))) {
            path.append(letter);
            backtrack(digits, index + 1, path, result);
            path.deleteCharAt(path.length() - 1);
        }
    }
}
