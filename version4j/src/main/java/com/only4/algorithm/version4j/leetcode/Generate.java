package com.only4.algorithm.version4j.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Generate {
    public List<List<Integer>> generate(int numRows) {
        // 参数校验
        if (numRows <= 0) return new ArrayList<>();

        // 创建结果列表
        List<List<Integer>> result = new ArrayList<>();

        // 为每一行创建列表并初始化为1
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                row.add(1);  // 初始值都为1
            }
            result.add(row);
        }

        // 从第3行(索引为2)开始填充中间元素
        for (int i = 2; i < numRows; i++) {
            for (int j = 1; j < i; j++) {
                // 当前元素等于上一行左上方和右上方元素之和
                result.get(i).set(j, result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
            }
        }

        return result;
    }
}
