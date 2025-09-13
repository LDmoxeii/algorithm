package com.only4.algorithm.version4k.leetcode

private const val UNVISITED = 0
private const val VISITING = 1
private const val VISITED = 2
fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
    // 构建邻接表表示的有向图
    val graph = buildGraph(numCourses, prerequisites)

    // 节点状态数组：0=未访问，1=访问中，2=已访问
    val states = IntArray(numCourses)

    /**
     * 使用DFS检查从指定课程开始是否存在环
     */
    fun hasCycle(course: Int): Boolean {
        // 如果当前课程正在访问中，说明形成了环
        if (states[course] == VISITING) {
            return true
        }

        // 如果当前课程已经访问完成，跳过
        if (states[course] == VISITED) {
            return false
        }

        // 标记当前课程为访问中
        states[course] = VISITING

        // 递归检查所有依赖的课程
        for (prerequisite in graph.getValue(course)) {
            if (hasCycle(prerequisite)) {
                return true
            }
        }

        // 标记当前课程为已访问
        states[course] = VISITED
        return false
    }

    // 对每个未访问的节点进行DFS检查
    return (0 until numCourses).all { course ->
        states[course] != UNVISITED || !hasCycle(course)
    }
}

/**
 * 根据先修课程关系构建邻接表
 */
private fun buildGraph(numCourses: Int, prerequisites: Array<IntArray>): Map<Int, List<Int>> {
    return prerequisites.groupBy({ it[0] }, { it[1] }).withDefault { emptyList() }
}
