package com.only4.algorithm.version4j.leetcode;

public class LongestPalindrome {
    public String longestPalindrome(String s) {
        int stringLength = s.length();
        if (stringLength < 2) return s;

        // isPalindrome[leftIndex][rightIndex] 表示子串 s[leftIndex...rightIndex] 是否为回文串
        boolean[][] isPalindrome = new boolean[stringLength][stringLength];
        int longestPalindromeStart = 0;
        int longestPalindromeLength = 1;

        // 初始化长度为1的子串（单个字符必然是回文）
        for (int charIndex = 0; charIndex < stringLength; charIndex++) {
            isPalindrome[charIndex][charIndex] = true;
        }

        // 检查长度为2的子串
        for (int leftIndex = 0; leftIndex < stringLength - 1; leftIndex++) {
            int rightIndex = leftIndex + 1;
            if (s.charAt(leftIndex) == s.charAt(rightIndex)) {
                isPalindrome[leftIndex][rightIndex] = true;
                longestPalindromeStart = leftIndex;
                longestPalindromeLength = 2;
            }
        }

        // 检查长度为3及以上的子串
        for (int currentSubstringLength = 3; currentSubstringLength <= stringLength; currentSubstringLength++) {
            for (int leftIndex = 0; leftIndex <= stringLength - currentSubstringLength; leftIndex++) {
                int rightIndex = leftIndex + currentSubstringLength - 1;
                char leftChar = s.charAt(leftIndex);
                char rightChar = s.charAt(rightIndex);
                boolean innerSubstringIsPalindrome = isPalindrome[leftIndex + 1][rightIndex - 1];

                if (leftChar == rightChar && innerSubstringIsPalindrome) {
                    isPalindrome[leftIndex][rightIndex] = true;
                    if (currentSubstringLength > longestPalindromeLength) {
                        longestPalindromeStart = leftIndex;
                        longestPalindromeLength = currentSubstringLength;
                    }
                }
            }
        }

        return s.substring(longestPalindromeStart, longestPalindromeStart + longestPalindromeLength);
    }
}
