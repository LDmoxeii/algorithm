package com.only4.algorithm.extra

import cn.hutool.core.date.StopWatch
import java.util.*

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun main() {
    val ll1 = LinkedList<Int>()
    val ll2 = LinkedList<Int>()
    val al1 = ArrayList<Int>()
    val al2 = ArrayList<Int>()
    repeat(1000_000) {
        ll1.add(it)
        ll2.add(it)
        al1.add(it)
        al2.add(it)
    }

    val watch = StopWatch()
    watch.start("ArrayList")
    al1.addAll(al2)
    watch.stop()

    watch.start("LinkedList")
    ll1.addAll(ll2)
    watch.stop()
    println(watch.prettyPrint())
}
