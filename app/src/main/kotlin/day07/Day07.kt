package day07

import common.InputRepo
import common.readSessionCookie
import common.solve
import kotlin.math.abs

fun main(args: Array<String>) {
    val day = 7
    val input = InputRepo(args.readSessionCookie()).get(day = day)

    solve(day, input, ::solveDay07Part1, ::solveDay07Part2)
}


fun solveDay07Part1(input: List<String>): Int {
    var lastPosition = 0
    var useFuel = -1
    input
        .first()
        .split(",")
        .map { it.toInt() }
        .sorted()
        .let {
            lastPosition = it.last()
            it
        }
        .groupBy { it }
        .mapValues { (_, value) -> value.size }
        .let { map ->
            repeat(lastPosition) { position ->
                var fuel = 0
                map.forEach { (innerPosition, count) ->
                    fuel += abs((innerPosition - position) * count)
                }
                if (useFuel == -1 || useFuel > fuel) {
                    useFuel = fuel
                }
            }
        }

    return useFuel
}

fun solveDay07Part2(input: List<String>): Int {
    var lastPosition = 0
    var useFuel = -1
    input
        .first()
        .split(",")
        .map { it.toInt() }
        .sorted()
        .let {
            lastPosition = it.last()
            it
        }
        .groupBy { it }
        .mapValues { (_, value) -> value.size }
        .let { map ->
            repeat(lastPosition) { position ->
                var fuel = 0
                map.forEach { (innerPosition, count) ->
                    val steps = abs(innerPosition - position)
                    fuel += (steps * (steps + 1)) / 2 * count
                }
                if (useFuel == -1 || useFuel > fuel) {
                    useFuel = fuel
                }
            }
        }

    return useFuel
}