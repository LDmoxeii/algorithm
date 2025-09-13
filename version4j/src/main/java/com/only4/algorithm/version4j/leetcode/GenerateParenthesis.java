package com.only4.algorithm.version4j.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhenyu.jiang
 */
public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder path = new StringBuilder();
        backtrack(n, 0, 0, path, result);
        return result;
    }

    public void backtrack(int n, int leftCount, int rightCount, StringBuilder path, List<String> result) {
        if (path.length() == n * 2) {
            result.add(path.toString());
            return;
        }

        if (leftCount < n) {
            path.append('(');
            backtrack(n, leftCount + 1, rightCount, path, result);
            path.deleteCharAt(path.length() - 1);
        }

        if (leftCount > rightCount) {
            path.append(')');
            backtrack(n, leftCount, rightCount + 1, path, result);
            path.deleteCharAt(path.length() - 1);
        }
    }
}
