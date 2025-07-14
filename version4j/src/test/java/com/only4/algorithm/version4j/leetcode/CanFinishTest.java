package com.only4.algorithm.version4j.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * CanFinish的测试类
 * 测试LeetCode第207题：课程表
 */
public class CanFinishTest {

    /**
     * 测试没有先修课程要求的情况
     */
    @Test
    public void testNoPrerequisites() {
        int numCourses = 3;
        int[][] prerequisites = new int[0][0]; // 空的先修课程要求

        CanFinish solution = new CanFinish();
        boolean result = solution.canFinish(numCourses, prerequisites);

        // 没有先修要求，肯定可以完成所有课程
        assertTrue(result);
    }

    /**
     * 测试有先修课程但没有形成环的情况
     */
    @Test
    public void testWithoutCycle() {
        int numCourses = 3;
        int[][] prerequisites = {
                {1, 0}, // 要学习课程1，必须先学习课程0
                {2, 1}  // 要学习课程2，必须先学习课程1
        };

        CanFinish solution = new CanFinish();
        boolean result = solution.canFinish(numCourses, prerequisites);

        // 没有形成环，可以完成所有课程：0->1->2
        assertTrue(result);
    }

    /**
     * 测试有先修课程并形成环的情况
     */
    @Test
    public void testWithCycle() {
        int numCourses = 3;
        int[][] prerequisites = {
                {1, 0}, // 要学习课程1，必须先学习课程0
                {2, 1}, // 要学习课程2，必须先学习课程1
                {0, 2}  // 要学习课程0，必须先学习课程2
        };

        CanFinish solution = new CanFinish();
        boolean result = solution.canFinish(numCourses, prerequisites);

        // 形成了环：0->1->2->0，不可能完成所有课程
        assertFalse(result);
    }

    /**
     * 测试只有一门课程的情况
     */
    @Test
    public void testSingleCourse() {
        int numCourses = 1;
        int[][] prerequisites = new int[0][0]; // 没有先修要求

        CanFinish solution = new CanFinish();
        boolean result = solution.canFinish(numCourses, prerequisites);

        // 只有一门课程，没有先修要求，可以完成
        assertTrue(result);
    }

    /**
     * 测试自环的情况（一门课程依赖自己）
     */
    @Test
    public void testSelfLoop() {
        int numCourses = 2;
        int[][] prerequisites = {
                {0, 0} // 要学习课程0，必须先学习课程0（自己依赖自己）
        };

        CanFinish solution = new CanFinish();
        boolean result = solution.canFinish(numCourses, prerequisites);

        // 课程0依赖自己，形成了自环，不可能完成
        assertFalse(result);
    }

    /**
     * 测试多个独立组件的情况
     */
    @Test
    public void testMultipleComponents() {
        int numCourses = 6;
        int[][] prerequisites = {
                {1, 0}, // 组件1：0->1->2
                {2, 1},
                {4, 3}, // 组件2：3->4->5
                {5, 4}
        };

        CanFinish solution = new CanFinish();
        boolean result = solution.canFinish(numCourses, prerequisites);

        // 多个独立组件，都没有环，可以完成所有课程
        assertTrue(result);
    }

    /**
     * 测试一个组件有环，另一个没环的情况
     */
    @Test
    public void testOneComponentWithCycle() {
        int numCourses = 6;
        int[][] prerequisites = {
                {1, 0},  // 组件1：0->1->2
                {2, 1},
                {4, 3},  // 组件2：3->4->5->3 (有环)
                {5, 4},
                {3, 5}
        };

        CanFinish solution = new CanFinish();
        boolean result = solution.canFinish(numCourses, prerequisites);

        // 一个组件有环，不可能完成所有课程
        assertFalse(result);
    }

    /**
     * 测试复杂依赖关系的情况
     */
    @Test
    public void testComplexDependencies() {
        int numCourses = 5;
        int[][] prerequisites = {
                {1, 0},
                {2, 1},
                {3, 1},
                {4, 2},
                {4, 3}
        };

        CanFinish solution = new CanFinish();
        boolean result = solution.canFinish(numCourses, prerequisites);

        // 复杂但无环的依赖关系，可以完成所有课程
        assertTrue(result);
    }
}
