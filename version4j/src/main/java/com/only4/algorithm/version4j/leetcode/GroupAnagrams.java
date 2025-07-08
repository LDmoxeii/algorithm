package com.only4.algorithm.version4j.leetcode;

import java.util.*;

/**
 * @author zhenyu.jiang
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramGroups = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);

            anagramGroups.computeIfAbsent(new String(chars), k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(anagramGroups.values());
    }
}
