package com.only4.algorithm.version4k.leetcode

fun findDuplicate(nums: IntArray): Int {
    // 使用弗洛伊德判圈法（快慢指针）查找环的入口
    // 将数组看作链表：index -> nums[index]，重复数字会形成环
    var slowPointer = nums[0]  // 慢指针（龟）
    var fastPointer = nums[0]  // 快指针（兔）

    // 阶段一：寻找环内相遇点
    // 快指针每次走两步，慢指针每次走一步，直到相遇
    do {
        slowPointer = nums[slowPointer]           // 慢指针前进一步
        fastPointer = nums[nums[fastPointer]]     // 快指针前进两步
    } while (slowPointer != fastPointer)

    // 阶段二：寻找环的入口点（重复数字）
    // 将慢指针重置到起点，两指针以相同速度前进
    slowPointer = nums[0]
    while (slowPointer != fastPointer) {
        slowPointer = nums[slowPointer]   // 慢指针前进一步
        fastPointer = nums[fastPointer]   // 快指针也前进一步
    }

    // 两指针再次相遇的位置就是环的入口，即重复数字
    return slowPointer
}
