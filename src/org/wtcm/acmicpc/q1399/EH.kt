package org.wtcm.acmicpc.q1399

import java.io.BufferedReader
import java.io.InputStreamReader

data class Point(val x: Int, val y: Int)

val dig2 = mutableMapOf<Int, MutableList<Point>>()
val c = MutableList(1001) {-1}

fun main() {
    init()

    val reader = BufferedReader(InputStreamReader(System.`in`))
    val testCase = reader.readLine().toInt()

    for(i in 0 until testCase) {
        val (K, M) = reader.readLine().split(" ").let { it[0].toInt() to it[1].toInt() }
        val visit = dig2[M]!!
        if(c[M] == 0) {
            visit[K % visit.size]
        } else {
            if(K <= visit.size) {
                visit[K]
            } else {
                visit[((K-c[M])%(visit.size-c[M]))+c[M]]
            }
        }.let {
            println("${it.x} ${it.y}")
        }
    }
}

fun init() {
    val dir = listOf(0 to 1, 1 to 0, 0 to -1, -1 to 0)
    for(i in 1..1000) {
        var x = 0
        var y = 0
        var digTimes = 0
        var gold = 1
        val visit = mutableListOf(Point(x, y))

        while (true) { // i에 대한 cycle을 찾는 loop --> 언제 똑같은 점으로 돌아오는지.
            dir[digTimes%4].let {
                gold = gold.dig()
                x += gold * it.first
                y += gold * it.second
            }

            if(visit.any { it.x == x && it.y == y }) {
                c[i] = visit.indexOfFirst { it.x == x && it.y == y }
                break
            }

            visit.add(Point(x, y))
            digTimes++
            gold *= i
        }
        dig2[i] = visit
    }
}

fun Int.dig(): Int = if (this < 10) {
    this
} else {
    var ret = 0
    var base = 1

    for (i in 1..10) {
        if (base > this) break

        ret += (this % (base * 10)) / base
        base *= 10
    }

    ret.dig()
}