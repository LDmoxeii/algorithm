package com.only4.algorithm.version4k.leetcode

fun nextPermutation(nums: IntArray) {
    val arrayLength = nums.size
    // 从倒数第二个元素开始查找下降点
    var descendingPointIndex = arrayLength - 2

    // 第一步：从右向左找到第一个下降点 nums[descendingPointIndex] < nums[descendingPointIndex+1]
    while (descendingPointIndex >= 0 && nums[descendingPointIndex] >= nums[descendingPointIndex + 1]) {
        descendingPointIndex--
    }

    // 如果存在下降点，需要找到替换元素并交换
    if (descendingPointIndex >= 0) {
        // 从右向左找到第一个比下降点元素大的数字
        val replacementIndex = (arrayLength - 1 downTo descendingPointIndex + 1).first {
            nums[it] > nums[descendingPointIndex]
        }
        // 交换下降点元素和替换元素
        nums.swap(descendingPointIndex, replacementIndex)
    }

    // 第三步：反转下降点后面的所有元素，得到字典序中下一个更大的排列
    nums.reverse(descendingPointIndex + 1, arrayLength - 1)
}

private fun IntArray.swap(firstIndex: Int, secondIndex: Int) {
    val tempValue = this[firstIndex]
    this[firstIndex] = this[secondIndex]
    this[secondIndex] = tempValue
}

private fun IntArray.reverse(startIndex: Int, endIndex: Int) {
    var leftPointer = startIndex
    var rightPointer = endIndex
    while (leftPointer < rightPointer) {
        swap(leftPointer, rightPointer)
        leftPointer++
        rightPointer--
    }
}

