package com.only4.algorithm.version4k.leetcode

fun combinationSum(candidateNumbers: IntArray, targetSum: Int): List<List<Int>> {
    // 排序候选数组，便于剪枝优化
    candidateNumbers.sort()
    val allValidCombinations = mutableListOf<List<Int>>()
    val currentCombinationPath = mutableListOf<Int>()

    /**
     * 使用回溯算法寻找所有和等于目标值的组合
     * @param startingCandidateIndex 开始考虑的候选数字索引
     * @param remainingTargetSum 还需要达到的目标和值
     */
    fun findCombinationsWithBacktracking(startingCandidateIndex: Int, remainingTargetSum: Int) {
        // 终止条件1：找到一个有效组合，剩余目标和为0
        if (remainingTargetSum == 0) {
            allValidCombinations.add(currentCombinationPath.toList())
            return
        }

        // 终止条件2：剩余目标和小于0，当前路径无效
        if (remainingTargetSum < 0) {
            return
        }

        // 从startingCandidateIndex开始尝试每个候选数字
        for (candidateIndex in startingCandidateIndex until candidateNumbers.size) {
            val currentCandidateNumber = candidateNumbers[candidateIndex]

            // 剪枝优化：如果当前候选数字大于剩余目标和，由于数组已排序，后续数字也都大于目标和
            if (currentCandidateNumber > remainingTargetSum) {
                break
            }

            // 选择：将当前候选数字添加到组合路径
            currentCombinationPath.add(currentCandidateNumber)

            // 递归：继续寻找组合，注意传入candidateIndex而非candidateIndex + 1，允许重复使用同一数字
            findCombinationsWithBacktracking(
                candidateIndex,  // 允许重复使用当前数字
                remainingTargetSum - currentCandidateNumber
            )

            // 回溯：移除刚添加的数字，尝试其他可能的选择
            currentCombinationPath.removeAt(currentCombinationPath.lastIndex)
        }
    }

    findCombinationsWithBacktracking(0, targetSum)  // 从第0个候选数字开始，目标和为targetSum
    return allValidCombinations
}
