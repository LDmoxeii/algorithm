package com.only4.algorithm.version4j.leetcode;

public class SortColors {
    public void sortColors(int[] nums) {
        // 荷兰国旗算法：使用三个指针将数组分为三个区域
        // [0...redBoundary-1] 为红色区域(0)
        // [redBoundary...currentIndex-1] 为白色区域(1)
        // [blueBoundary+1...length-1] 为蓝色区域(2)
        int redBoundary = 0;      // 红色区域的右边界
        int currentIndex = 0;     // 当前处理元素的索引
        int blueBoundary = nums.length - 1;  // 蓝色区域的左边界

        while (currentIndex <= blueBoundary) {
            int currentColor = nums[currentIndex];

            switch (currentColor) {
                case 0: // 红色
                    // 将红色元素交换到红色区域，扩展红色区域
                    swap(nums, redBoundary, currentIndex);
                    redBoundary++;
                    currentIndex++;
                    break;
                case 1: // 白色
                    // 白色元素已在正确区域，直接前进
                    currentIndex++;
                    break;
                case 2: // 蓝色
                    // 将蓝色元素交换到蓝色区域，扩展蓝色区域
                    // 注意：currentIndex不前进，需要重新判断交换来的元素
                    swap(nums, currentIndex, blueBoundary);
                    blueBoundary--;
                    break;
            }
        }
    }

    private void swap(int[] nums, int firstIndex, int secondIndex) {
        int tempValue = nums[firstIndex];
        nums[firstIndex] = nums[secondIndex];
        nums[secondIndex] = tempValue;
    }
}
