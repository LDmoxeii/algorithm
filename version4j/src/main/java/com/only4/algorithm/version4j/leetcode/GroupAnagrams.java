package com.only4.algorithm.version4j.leetcode;

import java.util.*;

/**
 * @author zhenyu.jiang
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        // 哈希表：排序后的字符串 -> 原字符串列表
        Map<String, List<String>> anagramGroups = new HashMap<>();

        for (String str : strs) {
            // 将字符串转换为字符数组并排序
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedStr = new String(chars);

            // 将原字符串添加到对应组中
            anagramGroups.computeIfAbsent(sortedStr, k -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(anagramGroups.values());
    }
}
