package com.only4.algorithm.version4j.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        if (s.isEmpty()) return new ArrayList<>();

        int[] lastPositions = new int[26];

        for (int i = 0; i < s.length(); i++) {
            lastPositions[s.charAt(i) - 'a'] = i;
        }

        List<Integer> result = new ArrayList<>();
        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, lastPositions[s.charAt(i) - 'a']);

            if (i == end) {
                result.add(end - start + 1);
                start = i + 1;
            }
        }
        return result;
    }
}
