package com.only4.algorithm.version4j.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * [207. 课程表](https://leetcode.cn/problems/course-schedule/?envType=study-plan-v2&envId=top-100-liked)
 * <p>
 * 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
 * 在选修某些课程之前需要一些先修课程。先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程 bi 。
 * 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
 * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
 */
public class CanFinish {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 构建邻接表表示图
        Set<Integer>[] adjacencyList = buildAdjacencyList(numCourses, prerequisites);

        // 记录已经访问过的节点
        Set<Integer> visited = new HashSet<>();
        // 记录当前DFS路径上的节点，用于检测环
        Set<Integer> onPath = new HashSet<>();

        // 对每个未访问过的节点进行DFS
        for (int i = 0; i < numCourses; i++) {
            if (hasCycle(adjacencyList, i, visited, onPath)) {
                return false; // 如果有环，无法完成所有课程
            }
        }

        return true; // 没有环，可以完成所有课程
    }

    /**
     * 检查以节点i为起点是否存在环
     *
     * @param adjacencyList 邻接表表示的图
     * @param i             当前节点
     * @param visited       已访问过的节点
     * @param onPath        当前DFS路径上的节点
     * @return 是否存在环
     */
    private boolean hasCycle(Set<Integer>[] adjacencyList, int i, Set<Integer> visited, Set<Integer> onPath) {
        // 如果节点已经在当前路径上，说明形成了环
        if (onPath.contains(i)) {
            return true;
        }

        // 如果节点已经被访问过，且确定不在环上，则跳过
        if (visited.contains(i)) {
            return false;
        }

        // 标记节点已访问，并加入当前路径
        visited.add(i);
        onPath.add(i);

        // 遍历所有邻接节点
        for (Integer neighbor : adjacencyList[i]) {
            if (hasCycle(adjacencyList, neighbor, visited, onPath)) {
                return true; // 如果有环，则返回true
            }
        }

        // 回溯，将节点从当前路径中移除
        onPath.remove(i);

        return false; // 没有环
    }

    /**
     * 构建邻接表表示的图
     *
     * @param size  节点数量
     * @param edges 边的列表
     * @return 邻接表
     */
    private Set<Integer>[] buildAdjacencyList(int size, int[][] edges) {
        Set<Integer>[] adjacencyList = new HashSet[size];
        for (int i = 0; i < size; i++) {
            adjacencyList[i] = new HashSet<>();
        }
        for (int[] edge : edges) {
            // prerequisites[i] = [ai, bi] 表示学习ai前必须先学习bi
            // 所以这里是从bi指向ai的有向边
            adjacencyList[edge[1]].add(edge[0]);
        }
        return adjacencyList;
    }
}
