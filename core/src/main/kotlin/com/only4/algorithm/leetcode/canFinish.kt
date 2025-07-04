package com.only4.algorithm.leetcode

/**
 * [207. 课程表](https://leetcode.cn/problems/course-schedule/?envType=study-plan-v2&envId=top-100-liked)
 *
 * 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
 * 在选修某些课程之前需要一些先修课程。先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程 bi 。
 * 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
 * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
 *
 * 解题思路：
 * 1. 这是一个检测有向图中是否存在环的问题
 * 2. 使用深度优先搜索 (DFS) 来检测环
 * 3. 使用三种状态标记每个节点：
 *    - 0: 未访问
 *    - 1: 访问中（当前DFS路径上的节点）
 *    - 2: 已完成访问
 * 4. 如果在DFS过程中遇到状态为1的节点，说明存在环
 *
 * @param numCourses 课程总数
 * @param prerequisites 课程依赖关系数组，每个元素 [a, b] 表示课程a依赖课程b
 * @return 是否可能完成所有课程学习
 */
fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
    // 构建邻接表表示的有向图，key为课程，value为该课程的所有先修课程
    val graph = prerequisites.groupBy({ it[0] }, { it[1] })
        .withDefault { emptyList() }

    // 用于标记节点状态：0=未访问，1=访问中，2=已完成访问
    val states = IntArray(numCourses)

    // 深度优先搜索函数，检测是否存在环
    fun dfs(course: Int): Boolean {
        // 标记当前节点为"访问中"
        states[course] = 1

        // 遍历当前课程的所有依赖课程
        for (prerequisite in graph.getValue(course)) {
            when (states[prerequisite]) {
                1 -> return false  // 发现环
                2 -> continue      // 已经访问过的节点，跳过
                else -> if (!dfs(prerequisite)) return false  // 递归检查依赖课程
            }
        }

        // 标记当前节点为"已完成访问"
        states[course] = 2
        return true
    }

    // 对每个未访问的节点进行DFS
    return (0 until numCourses).all { states[it] != 0 || dfs(it) }
}
