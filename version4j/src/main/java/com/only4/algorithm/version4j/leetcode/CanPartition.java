package com.only4.algorithm.version4j.leetcode;

public class CanPartition {
    public boolean canPartition(int[] nums) {
        // 计算数组元素总和
        int arrayTotalSum = 0;
        for (int num : nums) {
            arrayTotalSum += num;
        }

        // 如果总和为奇数，无法分割成两个和相等的子集
        if (arrayTotalSum % 2 != 0) return false;

        // 目标和为总和的一半
        int targetSubsetSum = arrayTotalSum / 2;
        int totalElementCount = nums.length;

        // canFormSumWithFirstElements[i][j] 表示：使用前i个元素，是否可以组成和为j的子集
        boolean[][] canFormSumWithFirstElements = new boolean[totalElementCount + 1][targetSubsetSum + 1];

        // 基础情况：空子集的和为0
        canFormSumWithFirstElements[0][0] = true;

        // 填充DP表格
        for (int elementIndex = 0; elementIndex < totalElementCount; elementIndex++) {
            int currentElementValue = nums[elementIndex];

            for (int targetSum = 0; targetSum <= targetSubsetSum; targetSum++) {
                // 情况1：不选择当前元素，和前面的状态保持一致
                canFormSumWithFirstElements[elementIndex + 1][targetSum] =
                        canFormSumWithFirstElements[elementIndex][targetSum];

                // 情况2：选择当前元素（如果targetSum >= currentElementValue）
                if (targetSum >= currentElementValue) {
                    boolean canFormSumWithCurrentElement =
                            canFormSumWithFirstElements[elementIndex][targetSum - currentElementValue];

                    canFormSumWithFirstElements[elementIndex + 1][targetSum] =
                            canFormSumWithFirstElements[elementIndex + 1][targetSum] ||
                                    canFormSumWithCurrentElement;
                }
            }
        }

        // 返回最终结果：使用所有元素，是否可以组成和为targetSubsetSum的子集
        return canFormSumWithFirstElements[totalElementCount][targetSubsetSum];
    }
}
