package com.only4.algorithm.version4j.leetcode;

import java.util.HashSet;
import java.util.Set;

public class CanFinish {

    private static final int UNVISITED = 0;
    private static final int VISITING = 1;
    private static final int VISITED = 2;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 构建邻接表表示的有向图
        Set<Integer>[] graph = buildGraph(numCourses, prerequisites);

        // 节点状态数组：0=未访问，1=访问中，2=已访问
        int[] states = new int[numCourses];

        // 对每个未访问的节点进行DFS检查
        for (int course = 0; course < numCourses; course++) {
            if (states[course] == UNVISITED && hasCycle(graph, course, states)) {
                return false;
            }
        }

        return true;
    }

    /**
     * 使用DFS检查从指定课程开始是否存在环
     *
     * @param graph   邻接表表示的图
     * @param course  当前课程
     * @param states  节点状态数组
     * @return 是否存在环
     */
    private boolean hasCycle(Set<Integer>[] graph, int course, int[] states) {
        // 如果当前课程正在访问中，说明形成了环
        if (states[course] == VISITING) {
            return true;
        }

        // 如果当前课程已经访问完成，跳过
        if (states[course] == VISITED) {
            return false;
        }

        // 标记当前课程为访问中
        states[course] = VISITING;

        // 递归检查所有依赖的课程
        for (int prerequisite : graph[course]) {
            if (hasCycle(graph, prerequisite, states)) {
                return true;
            }
        }

        // 标记当前课程为已访问
        states[course] = VISITED;
        return false;
    }

    /**
     * 根据先修课程关系构建邻接表
     *
     * @param numCourses    课程总数
     * @param prerequisites 先修课程关系
     * @return 邻接表表示的图
     */
    private Set<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
        Set<Integer>[] graph = new HashSet[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph[i] = new HashSet<>();
        }

        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int prereq = prerequisite[1];
            // course依赖于prereq，在图中从course指向prereq
            graph[course].add(prereq);
        }

        return graph;
    }
}
