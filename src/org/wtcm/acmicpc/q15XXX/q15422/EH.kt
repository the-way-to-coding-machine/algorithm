package org.wtcm.acmicpc.q15XXX.q15422
/*
import java.io.BufferedReader
import java.util.*
import kotlin.collections.ArrayList
import kotlin.properties.Delegates

var n by Delegates.notNull<Int>()
var m by Delegates.notNull<Int>()
var f by Delegates.notNull<Int>()
var s by Delegates.notNull<Int>()
var t by Delegates.notNull<Int>()
lateinit var roads: ArrayList<MutableList<Road>?>
lateinit var flights: ArrayList<MutableList<Int>?>
lateinit var visitWithVoucher: BooleanArray
lateinit var visitWithoutVoucher: BooleanArray
lateinit var priorityQueue: PriorityQueue<Node>

data class Node(
        val cost: Long,
        val node: Int,
        val voucherAvailable: Boolean
): Comparable<Node> {
    override fun compareTo(other: Node): Int {
        return (cost - other.cost).toInt()
    }
}

data class Road(
        val to: Int,
        val cost: Int
)

fun main() {
    System.`in`.bufferedReader().run {
        readInput()
    }

    println(algorithm())
}

// dijkstra
fun algorithm(): Long {
    var ret: Long = 0
    priorityQueue.add(Node(cost = 0, node = s, voucherAvailable = true))

    while(priorityQueue.isNotEmpty()) {
        val cur = priorityQueue.remove()
        when(cur.voucherAvailable) {
            true -> visitWithoutVoucher[cur.node] = true
            false -> visitWithVoucher[cur.node] = true
        }

        if(cur.node == t) {
            ret = cur.cost
            break
        }

        roads[cur.node]?.forEach {
            if (cur.voucherAvailable) {
                if(!visitWithoutVoucher[it.to]) { // visitWithoutVoucher[num] == false 라는건
                    priorityQueue.add(Node(cur.cost + it.cost, it.to, true))
                }
            } else {
                if(!visitWithVoucher[it.to]) {
                    priorityQueue.add(Node(cur.cost + it.cost, it.to, false))
                }
            }
        }

        if (cur.voucherAvailable) {
            flights[cur.node]?.forEach { flight ->
                if(!visitWithVoucher[flight]) {
                    priorityQueue.add(Node(cur.cost, flight, false))
                }
            }
        }
    }

    return ret
}

private fun BufferedReader.readInput() {
    readLine().split(" ").let {
        n = it[0].toInt()
        m = it[1].toInt()
        f = it[2].toInt()
        s = it[3].toInt()
        t = it[4].toInt()
    }

    roads = ArrayList(n + 1)
    (0..n).forEach {
        roads.add(mutableListOf())
    }

    flights = ArrayList(n + 1)
    (0..n).forEach {
        flights.add(mutableListOf())
    }

    visitWithVoucher = BooleanArray(n + 1)
    visitWithoutVoucher = BooleanArray(n + 1)
    priorityQueue = PriorityQueue()

    (0 until m).forEach {
        readLine().split(" ").let {
            val city1 = it[0].toInt()
            val city2 = it[1].toInt()
            val cost = it[2].toInt()

            roads[city1]!!.let { it.add(Road(city2, cost)) }
            roads[city2]!!.let { it.add(Road(city1, cost)) }
        }
    }

    (0 until f).forEach {
        readLine().split(" ").let {
            val from = it[0].toInt()
            val to = it[1].toInt()

            flights[from]!!.let { it.add(to) }
        }
    }
}
 */