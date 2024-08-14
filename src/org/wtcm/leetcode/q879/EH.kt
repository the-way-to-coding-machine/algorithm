package org.wtcm.leetcode.q879
/*
import kotlin.math.pow


class Solution {
    val MODULO = ((10.0).pow(9).toInt()) + 7
    lateinit var group: IntArray
    lateinit var profit: IntArray
    var cache: Array<Array<Array<Int>>> = Array(101) {
        Array(101) {
            Array(101) { -1 }
        }
    }

    fun profitableSchemes(G: Int, P: Int, group: IntArray, profit: IntArray): Int {
        this.group = group;
        this.profit = profit;

        return recur(0, P, G) % MODULO
    }

    fun recur(index: Int, profitForNeed: Int, remaingGroup: Int): Int {
        when {
            index >= group.size -> return if (profitForNeed <= 0 && remaingGroup >= 0) 1 else 0
            cache[index][profitForNeed][remaingGroup] != -1 -> return cache[index][profitForNeed][remaingGroup]
            remaingGroup <= 0 -> return if (profitForNeed <= 0 && remaingGroup >= 0) 1 else 0
        }

        var cnt = 0

        if (remaingGroup >= group[index]) {
            cnt += recur(index + 1, Math.max(0, profitForNeed - profit[index]), remaingGroup - group[index]) % MODULO
        }

        cnt += recur(index + 1, profitForNeed, remaingGroup) % MODULO
        cache[index][profitForNeed][remaingGroup] = cnt
        return cnt
    }
}

 */