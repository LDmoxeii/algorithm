package com.only4.algorithm.version4k.leetcode

fun sortColors(nums: IntArray) {
    // 荷兰国旗算法：使用三个指针将数组分为三个区域
    // [0...redBoundary-1] 为红色区域(0)
    // [redBoundary...currentIndex-1] 为白色区域(1)
    // [blueBoundary+1...lastIndex] 为蓝色区域(2)
    var redBoundary = 0      // 红色区域的右边界
    var currentIndex = 0     // 当前处理元素的索引
    var blueBoundary = nums.lastIndex  // 蓝色区域的左边界

    while (currentIndex <= blueBoundary) {
        val currentColor = nums[currentIndex]

        when (currentColor) {
            0 -> { // 红色
                // 将红色元素交换到红色区域，扩展红色区域
                nums.swap(redBoundary, currentIndex)
                redBoundary++
                currentIndex++
            }

            1 -> { // 白色
                // 白色元素已在正确区域，直接前进
                currentIndex++
            }

            2 -> { // 蓝色
                /// 将蓝色元素交换到蓝色区域，扩展蓝色区域
                // 注意：currentIndex不前进，需要重新判断交换来的元素
                nums.swap(currentIndex, blueBoundary)
                blueBoundary--
            }
        }
    }
}

private fun IntArray.swap(firstIndex: Int, secondIndex: Int) {
    val tempValue = this[firstIndex]
    this[firstIndex] = this[secondIndex]
    this[secondIndex] = tempValue
}
