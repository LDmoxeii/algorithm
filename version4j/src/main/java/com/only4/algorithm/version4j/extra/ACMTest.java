package com.only4.algorithm.version4j.extra;

import java.util.*;

public class ACMTest {
    public static void main(String[] args) {
        Test.test();
    }

    static class Test {
        public static void test() {
            System.out.println("test");
        }

        static {
            System.out.print("haha");
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numIndexMap = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            int currentNum = nums[i];
            int complement = target - currentNum;
            if (numIndexMap.containsKey(complement)) return new int[]{numIndexMap.get(complement), i};
            numIndexMap.put(currentNum, i);
        }
        return null;
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramGroups = new HashMap();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedStr = new String(chars);
            anagramGroups.computeIfAbsent(sortedStr, k -> new ArrayList<>()).add(str);
        }

        return new ArrayList(anagramGroups.values());
    }
}

