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
        ArrayDeque<String> sequence = new ArrayDeque<>();
        dfs(s, 0, 0, sequence, result);
        return result;
    }

    public void dfs(String s, int start, int end, ArrayDeque<String> sequence, List<List<String>> result) {
        if (start == s.length()) {
            result.add(new ArrayList<>(sequence));
            return;
        }

        while (end < s.length()) {
            if (isPartition(s, start, end)) {
                sequence.addLast(s.substring(start, end + 1));
                dfs(s, end + 1, end + 1, sequence, result);
                sequence.removeLast();
            }
            end++;
        }

    }

    private boolean isPartition(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start++) != s.charAt(end--)) return false;
        }
        return true;
    }
}
