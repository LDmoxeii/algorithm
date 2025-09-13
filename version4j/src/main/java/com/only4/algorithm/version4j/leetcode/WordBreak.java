package com.only4.algorithm.version4j.leetcode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        // 计算字典中最长单词的长度
        int maxWordLength = 0;
        for (String word : wordDict) {
            maxWordLength = Math.max(maxWordLength, word.length());
        }

        // 将字典转换为HashSet以提高查找效率
        Set<String> wordSet = new HashSet<>(wordDict);

        // dp[i]表示s的前i个字符是否可以被拆分
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true; // 空字符串可以被拆分

        // 对于每个位置，检查是否可以从之前的某个位置加上字典中的单词得到
        for (int i = 1; i <= s.length(); i++) {
            // 只检查从i-maxWordLength到i-1的范围，优化时间复杂度
            int startPos = Math.max(i - maxWordLength, 0);
            for (int j = i - 1; j >= startPos; j--) {
                String word = s.substring(j, i);
                if (dp[j] && wordSet.contains(word)) {
                    dp[i] = true;
                    break; // 找到一种可行拆分即可停止
                }
            }
        }

        return dp[s.length()];
    }
}
