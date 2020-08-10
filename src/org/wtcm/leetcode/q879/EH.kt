package org.wtcm.leetcode.q879

import java.util.*
import kotlin.math.pow

val MODULO = ((10.0).pow(9).toInt()) + 7
lateinit var group: IntArray
lateinit var profit: IntArray
var cache: Array<Array<Array<Int>>> = Array(100) {
    Array(100) {
        Array(100) {-1}
    }
}

fun main() {
    val G = 1
    val P = 1
    group = intArrayOf(1, 1, 1, 1, 2, 2, 1, 2, 1, 2)
    profit = intArrayOf(0, 1, 0, 0, 1, 1, 1, 0, 2, 2)

    println(recur(0, P, G) % MODULO)
}

fun recur(index: Int, profitForNeed: Int, remaingGroup: Int): Int {
    when {
        index >= group.size -> return if (profitForNeed <= 0 && remaingGroup >= 0) 1 else 0
        cache[index][profitForNeed][remaingGroup] != -1 -> return cache[index][profitForNeed][remaingGroup]
        remaingGroup <= 0 -> return 0
    }

    var cnt = 0

    if (remaingGroup >= group[index]) {
        cnt += recur(index + 1, Math.max(0, profitForNeed - profit[index]), remaingGroup - group[index])
    }

    cnt += recur(index + 1, profitForNeed, remaingGroup)
    cache[index][profitForNeed][remaingGroup] = cnt
    return cnt
}