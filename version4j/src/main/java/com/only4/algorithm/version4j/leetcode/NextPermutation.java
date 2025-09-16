package com.only4.algorithm.version4j.leetcode;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int arrayLength = nums.length;
        // 从倒数第二个元素开始查找下降点
        int descendingPointIndex = arrayLength - 2;

        // 第一步：从右向左找到第一个下降点 nums[descendingPointIndex] < nums[descendingPointIndex+1]
        while (descendingPointIndex >= 0 && nums[descendingPointIndex] >= nums[descendingPointIndex + 1]) {
            descendingPointIndex--;
        }

        // 如果存在下降点，需要找到替换元素并交换
        if (descendingPointIndex >= 0) {
            // 从右向左找到第一个比下降点元素大的数字
            int replacementIndex = arrayLength - 1;
            while (nums[replacementIndex] <= nums[descendingPointIndex]) {
                replacementIndex--;
            }
            // 交换下降点元素和替换元素
            swap(nums, descendingPointIndex, replacementIndex);
        }

        // 第三步：反转下降点后面的所有元素，得到字典序中下一个更大的排列
        reverse(nums, descendingPointIndex + 1, arrayLength - 1);
    }

    private void swap(int[] nums, int firstIndex, int secondIndex) {
        int tempValue = nums[firstIndex];
        nums[firstIndex] = nums[secondIndex];
        nums[secondIndex] = tempValue;
    }

    private void reverse(int[] nums, int startIndex, int endIndex) {
        while (startIndex < endIndex) {
            swap(nums, startIndex, endIndex);
            startIndex++;
            endIndex--;
        }
    }
}
