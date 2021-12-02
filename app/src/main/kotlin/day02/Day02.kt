package day02

import common.InputRepo
import common.readSessionCookie
import common.solve
import java.lang.IllegalStateException

fun main(args: Array<String>) {
    val day = 2
    val input = InputRepo(args.readSessionCookie()).get(day = day)

    solve(day, input, ::solveDay02Part1, ::solveDay02Part2)
}


fun solveDay02Part1(input: List<String>): Int {
    val pair: List<Pair<String, Int>> = convertInputData(input)

    var horizontal = 0
    var depth = 0

    pair.forEach { (direction, i) ->
        when(direction){
            "forward" -> horizontal += i
            "down" -> depth += i
            "up" -> depth -= i
            else -> throw IllegalStateException("Unknown direction")
        }
    }

    return horizontal * depth
}


fun solveDay02Part2(input: List<String>): Int {
    val pair: List<Pair<String, Int>> = convertInputData(input)

    var horizontal = 0
    var depth = 0
    var aim = 0

    pair.forEach { (direction, i) ->
        when(direction){
            "forward" -> {
                horizontal += i
                depth += aim * i
            }
            "down" -> aim += i
            "up" -> aim -= i
            else -> throw IllegalStateException("Unknown direction")
        }
    }

    return horizontal * depth
}

private fun convertInputData(input: List<String>) = input.map {
    it
        .replace("(\\w+) (\\d+)".toRegex(), "\$1 \$2")
        .split(" ")
        .let { i ->
            Pair(i.first(), i.last().toInt())
        }
}
