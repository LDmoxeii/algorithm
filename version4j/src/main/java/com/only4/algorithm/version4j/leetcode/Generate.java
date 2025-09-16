package com.only4.algorithm.version4j.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Generate {
    public List<List<Integer>> generate(int numRows) {
        // 参数校验
        if (numRows <= 0) return new ArrayList<>();

        // 创建杨辉三角结果列表
        List<List<Integer>> pascalTriangle = new ArrayList<>();

        // 为每一行创建列表并初始化为1（处理边界元素）
        for (int rowIndex = 0; rowIndex < numRows; rowIndex++) {
            List<Integer> currentRow = new ArrayList<>();
            for (int columnIndex = 0; columnIndex <= rowIndex; columnIndex++) {
                currentRow.add(1);  // 边界元素初始值都为1
            }
            pascalTriangle.add(currentRow);
        }

        // 从第3行(索引为2)开始填充中间元素
        for (int rowIndex = 2; rowIndex < numRows; rowIndex++) {
            for (int columnIndex = 1; columnIndex < rowIndex; columnIndex++) {
                // 当前元素 = 上一行左上方元素 + 上一行右上方元素
                int leftParentValue = pascalTriangle.get(rowIndex - 1).get(columnIndex - 1);
                int rightParentValue = pascalTriangle.get(rowIndex - 1).get(columnIndex);
                int currentValue = leftParentValue + rightParentValue;

                pascalTriangle.get(rowIndex).set(columnIndex, currentValue);
            }
        }

        return pascalTriangle;
    }
}
