package day03

import common.InputRepo
import common.readSessionCookie
import common.solve
import java.lang.IllegalStateException

fun main(args: Array<String>) {
    val day = 3
    val input = InputRepo(args.readSessionCookie()).get(day = day)

    solve(day, input, ::solveDay03Part1, ::solveDay03Part2)
}


fun solveDay03Part1(input: List<String>): Int {
    val list = mutableListOf<Int>()
    val size = input[0].count()

    (0 until size).forEach { cursor ->
        input
            .map { it[cursor] }
            .count { it == '0' }
            .let { zeroCount ->
                list.add(if (zeroCount > input.size / 2) 0 else 1)
            }
    }

    val gammaRate = list.joinToString(separator = "").toInt(2)

    val epsilonRate = list
        .map { if (it == 0) 1 else 0 }
        .joinToString("")
        .toInt(2)


    return gammaRate * epsilonRate
}

fun solveDay03Part2(input: List<String>): Int {
    val oxygenGenerator = input.toMutableList()
    val co2Scrubber = input.toMutableList()

    oxygenGenerator.search { count -> if (count > oxygenGenerator.size / 2) '1' else '0' }
    co2Scrubber.search { count -> if (count > co2Scrubber.size / 2) '0' else '1' }

    val gammaRate = oxygenGenerator.toInt()
    val epsilonRate = co2Scrubber.toInt()

    return gammaRate * epsilonRate
}

fun List<String>.toInt(): Int = this.joinToString("").toInt(2)

fun MutableList<String>.search(deciminier: (count: Int) -> Char) {
    (0 until size).forEach { cursor ->
        if (this.size <= 1) return@forEach

        this
            .map { it[cursor] }
            .count { it == '0' }
            .let { zeroCount ->
                this
                    .filter { it[cursor] == deciminier(zeroCount) }
                    .forEach {
                        this.remove(it)
                    }
            }
    }
}
