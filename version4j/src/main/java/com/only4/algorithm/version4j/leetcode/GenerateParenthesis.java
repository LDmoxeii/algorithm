package com.only4.algorithm.version4j.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhenyu.jiang
 */
public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        dfs(n, 0, 0, new StringBuilder(), result);
        return result;
    }

    public void dfs(int n, int leftCount, int rightCount, StringBuilder sequence, List<String> result) {
        if (sequence.length() == n * 2) {
            result.add(sequence.toString());
            return;
        }

        if (leftCount < n) {
            sequence.append('(');
            dfs(n, leftCount + 1, rightCount, sequence, result);
            sequence.deleteCharAt(sequence.length() - 1);
        }

        if (leftCount > rightCount) {
            sequence.append(')');
            dfs(n, leftCount, rightCount + 1, sequence, result);
            sequence.deleteCharAt(sequence.length() - 1);
        }
    }
}
