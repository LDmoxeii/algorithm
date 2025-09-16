package com.only4.algorithm.version4j.leetcode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        // 计算字典中最长单词的长度，用于优化搜索范围
        int maxWordLengthInDict = 0;
        for (String dictWord : wordDict) {
            maxWordLengthInDict = Math.max(maxWordLengthInDict, dictWord.length());
        }

        // 将字典转换为HashSet以提高查找效率
        Set<String> dictWordSet = new HashSet<>(wordDict);

        // canBreakUpToPosition[i] 表示字符串s的前i个字符是否可以被拆分
        boolean[] canBreakUpToPosition = new boolean[s.length() + 1];
        canBreakUpToPosition[0] = true; // 空字符串可以被拆分

        // 对于每个位置，检查是否可以从之前的某个位置加上字典中的单词得到
        for (int currentPosition = 1; currentPosition <= s.length(); currentPosition++) {
            // 只检查可能的起始位置范围，优化时间复杂度
            int earliestStartPosition = Math.max(currentPosition - maxWordLengthInDict, 0);

            for (int startPosition = currentPosition - 1; startPosition >= earliestStartPosition; startPosition--) {
                // 提取从startPosition到currentPosition的子串
                String candidateWord = s.substring(startPosition, currentPosition);

                // 如果前面部分可以拆分且当前子串在字典中，则当前位置可以拆分
                if (canBreakUpToPosition[startPosition] && dictWordSet.contains(candidateWord)) {
                    canBreakUpToPosition[currentPosition] = true;
                    break; // 找到一种可行拆分即可停止
                }
            }
        }

        return canBreakUpToPosition[s.length()];
    }
}
