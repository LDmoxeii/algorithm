package com.only4.algorithm.version4j.leetcode;

import java.util.*;

/**
 * @author zhenyu.jiang
 */
public class LetterCombinations {

    // 电话按键到字母的映射表（模拟真实手机键盘）
    private static final Map<Character, List<Character>> DIGIT_TO_LETTERS_MAP;

    static {
        DIGIT_TO_LETTERS_MAP = new HashMap<>();
        DIGIT_TO_LETTERS_MAP.put('2', List.of('a', 'b', 'c'));
        DIGIT_TO_LETTERS_MAP.put('3', List.of('d', 'e', 'f'));
        DIGIT_TO_LETTERS_MAP.put('4', List.of('g', 'h', 'i'));
        DIGIT_TO_LETTERS_MAP.put('5', List.of('j', 'k', 'l'));
        DIGIT_TO_LETTERS_MAP.put('6', List.of('m', 'n', 'o'));
        DIGIT_TO_LETTERS_MAP.put('7', List.of('p', 'q', 'r', 's'));
        DIGIT_TO_LETTERS_MAP.put('8', List.of('t', 'u', 'v'));
        DIGIT_TO_LETTERS_MAP.put('9', List.of('w', 'x', 'y', 'z'));
    }

    public List<String> letterCombinations(String inputPhoneDigits) {
        // 边界条件：如果输入为空，返回空列表
        if (inputPhoneDigits.isEmpty()) {
            return Collections.emptyList();
        }

        List<String> allLetterCombinations = new ArrayList<>();
        StringBuilder currentCombinationPath = new StringBuilder(inputPhoneDigits.length());

        generateCombinationsWithBacktracking(
                inputPhoneDigits,
                0,  // 从第0个数字开始处理
                currentCombinationPath,
                allLetterCombinations
        );
        return allLetterCombinations;
    }

    /**
     * 使用回溯算法生成所有可能的字母组合
     *
     * @param inputPhoneDigits       输入的电话号码数字串
     * @param currentDigitIndex      当前正在处理的数字位置索引
     * @param currentCombinationPath 当前正在构建的字母组合路径
     * @param allLetterCombinations  存储所有可能字母组合的结果集
     */
    private void generateCombinationsWithBacktracking(
            String inputPhoneDigits,
            int currentDigitIndex,
            StringBuilder currentCombinationPath,
            List<String> allLetterCombinations) {

        // 终止条件：已经处理完所有数字，当前路径就是一个完整的字母组合
        if (currentCombinationPath.length() == inputPhoneDigits.length()) {
            allLetterCombinations.add(currentCombinationPath.toString());
            return;
        }

        // 获取当前数字对应的所有可能字母
        char currentDigit = inputPhoneDigits.charAt(currentDigitIndex);
        List<Character> availableLettersForCurrentDigit = DIGIT_TO_LETTERS_MAP.get(currentDigit);

        // 尝试当前数字对应的每个字母
        for (Character candidateLetter : availableLettersForCurrentDigit) {
            // 选择：将候选字母添加到当前组合路径
            currentCombinationPath.append(candidateLetter);

            // 递归：继续处理下一个数字
            generateCombinationsWithBacktracking(
                    inputPhoneDigits,
                    currentDigitIndex + 1,
                    currentCombinationPath,
                    allLetterCombinations
            );

            // 回溯：移除刚添加的字母，尝试其他可能的字母选择
            currentCombinationPath.deleteCharAt(currentCombinationPath.length() - 1);
        }
    }
}
