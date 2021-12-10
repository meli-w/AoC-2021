package day06

import common.InputRepo
import common.readSessionCookie
import common.solve

fun main(args: Array<String>) {
    val day = 6
    val input = InputRepo(args.readSessionCookie()).get(day = day)

    solve(day, input, ::solveDay06Part1, ::solveDay06Part2)
}


fun solveDay06Part1(input: List<String>): Int = input
    .first()
    .split(",")
    .map { it.toInt() }
    .timeFliesBy()
    .toInt()

fun solveDay06Part2(input: List<String>): Int {
    val solution = input
        .first()
        .split(",")
        .map { it.toInt() }
        .timeFliesBy(256)

    println("The Solution of Part 2 is $solution")

    return 0
}

fun List<Int>.timeFliesBy(days: Int = 80): Long {
    var map: Map<Int, Long> = this
        .groupBy { it }
        .mapValues { (_, value) ->
            value.size.toLong()
        }

    repeat(days) {
        val newMap = mutableMapOf<Int, Long>()
        map
            .forEach { (age, count) ->
                if (age == 0) {
                    newMap.putNewFish(8, count)
                    newMap.putNewFish(6, count)
                } else {
                    val newAge = age - 1
                    newMap.putNewFish(newAge, count)
                }
            }
        map = newMap
    }

    var size: Long = 0
    map.forEach { (_, count) -> size += count }
    return size
}

private fun MutableMap<Int, Long>.putNewFish(key: Int, value: Long): MutableMap<Int, Long> {
    val newAgeCount = this[key]
    if (newAgeCount == null) {
        this[key] = value
    } else {
        this[key] = newAgeCount + value
    }
    return this
}