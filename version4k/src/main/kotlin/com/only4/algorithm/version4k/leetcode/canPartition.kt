package com.only4.algorithm.version4k.leetcode

fun canPartition(nums: IntArray): Boolean {
    // 计算数组元素总和
    val arrayTotalSum = nums.sum()

    // 如果总和为奇数，无法分割成两个和相等的子集
    if (arrayTotalSum % 2 != 0) return false

    // 目标和为总和的一半
    val targetSubsetSum = arrayTotalSum / 2
    val totalElementCount = nums.size

    // canFormSumWithFirstElements[i][j] 表示：使用前i个元素，是否可以组成和为j的子集
    val canFormSumWithFirstElements = Array(totalElementCount + 1) {
        BooleanArray(targetSubsetSum + 1)
    }

    // 基础情况：空子集的和为0
    canFormSumWithFirstElements[0][0] = true

    // 填充DP表格
    for (elementIndex in 0 until totalElementCount) {
        val currentElementValue = nums[elementIndex]

        for (targetSum in 0..targetSubsetSum) {
            // 情况1：不选择当前元素，和前面的状态保持一致
            canFormSumWithFirstElements[elementIndex + 1][targetSum] =
                canFormSumWithFirstElements[elementIndex][targetSum]

            // 情况2：选择当前元素（如果targetSum >= currentElementValue）
            if (targetSum >= currentElementValue) {
                val canFormSumWithCurrentElement =
                    canFormSumWithFirstElements[elementIndex][targetSum - currentElementValue]

                canFormSumWithFirstElements[elementIndex + 1][targetSum] =
                    canFormSumWithFirstElements[elementIndex + 1][targetSum] ||
                            canFormSumWithCurrentElement
            }
        }
    }

    // 返回最终结果：使用所有元素，是否可以组成和为targetSubsetSum的子集
    return canFormSumWithFirstElements[totalElementCount][targetSubsetSum]
}
