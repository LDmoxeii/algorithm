package com.only4.algorithm.version4j.leetcode;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        // Boyer-Moore 投票算法：候选人和投票计数器
        int majorityCandidate = 0;
        int voteCount = 0;

        for (int currentElement : nums) {
            if (voteCount == 0) {
                // 投票数为0时，选择当前元素作为新的候选人
                majorityCandidate = currentElement;
            }

            // 如果当前元素支持候选人则+1票，否则-1票
            if (currentElement == majorityCandidate) {
                voteCount++;
            } else {
                voteCount--;
            }
        }

        // 由于题目保证多数元素存在，最终的候选人就是多数元素
        return majorityCandidate;
    }
}
