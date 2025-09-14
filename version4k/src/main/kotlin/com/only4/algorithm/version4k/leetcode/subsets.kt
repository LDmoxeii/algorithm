package com.only4.algorithm.version4k.leetcode

fun subsets(originalElements: IntArray): List<List<Int>> {
    val allPowerSetSubsets = mutableListOf<List<Int>>()
    val currentSubsetPath = mutableListOf<Int>()

    /**
     * 使用回溯算法生成所有子集（幂集）
     * @param nextElementIndex 下一个要考虑的元素索引
     */
    fun generateAllSubsetsWithBacktracking(nextElementIndex: Int) {
        // 将当前子集路径添加到幂集结果中（包括空集）
        allPowerSetSubsets.add(currentSubsetPath.toList())

        // 从nextElementIndex开始，尝试添加每个后续元素到当前子集
        for (candidateIndex in nextElementIndex until originalElements.size) {
            val candidateElement = originalElements[candidateIndex]

            // 选择：将候选元素添加到当前子集路径
            currentSubsetPath.add(candidateElement)

            // 递归：继续构建包含当前元素的所有子集
            // 注意：下次递归从candidateIndex + 1开始，确保不重复选择同一元素
            generateAllSubsetsWithBacktracking(candidateIndex + 1)

            // 回溯：移除刚添加的元素，尝试其他可能的组合
            currentSubsetPath.removeAt(currentSubsetPath.lastIndex)
        }
    }

    generateAllSubsetsWithBacktracking(0)  // 从第0个元素开始考虑
    return allPowerSetSubsets
}
