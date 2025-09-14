package com.only4.algorithm.version4k.leetcode

fun permute(candidateNumbers: IntArray): List<List<Int>> {
    val allPermutations = mutableListOf<List<Int>>()
    val currentPermutationPath = mutableListOf<Int>()
    val isNumberUsedInCurrentPath = BooleanArray(candidateNumbers.size)

    /**
     * 使用回溯算法生成所有排列
     */
    fun generatePermutationsWithBacktracking() {
        // 终止条件：当前路径长度等于候选数字总数，说明找到一个完整排列
        if (currentPermutationPath.size == candidateNumbers.size) {
            allPermutations.add(currentPermutationPath.toList())
            return
        }

        // 遍历所有候选数字，尝试将其加入当前排列路径
        for (candidateIndex in candidateNumbers.indices) {
            // 剪枝：跳过已经在当前路径中使用的数字
            if (isNumberUsedInCurrentPath[candidateIndex]) {
                continue
            }

            // 选择：将候选数字添加到当前路径，并标记为已使用
            val currentCandidateNumber = candidateNumbers[candidateIndex]
            isNumberUsedInCurrentPath[candidateIndex] = true
            currentPermutationPath.add(currentCandidateNumber)

            // 递归：继续构建下一层排列
            generatePermutationsWithBacktracking()

            // 回溯：撤销当前选择，恢复状态以尝试其他可能性
            currentPermutationPath.removeAt(currentPermutationPath.lastIndex)
            isNumberUsedInCurrentPath[candidateIndex] = false
        }
    }

    generatePermutationsWithBacktracking()
    return allPermutations
}
