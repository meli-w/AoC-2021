package day01

import common.Input
import common.InputRepo
import common.readSessionCookie
import common.solve

fun main(args: Array<String>) {
    val day = 1
    val input = InputRepo(args.readSessionCookie()).get(day = day)

    solve(day, input, ::solveDay01Part1, ::solveDay01Part2)
}


fun solveDay01Part1(input: Input): Int {
    val inputList = input.map { it.toInt() }
    val inputList2 = input.map { it.toInt() }.subList(1, inputList.size)

    var sum = 0

    inputList2.forEachIndexed { index: Int, i: Int ->
        if (inputList[index] < i) sum++
    }

    return sum
}

fun solveDay01Part2(input: Input): Int {
    val inputList = input.map { it.toInt() }
    val solutionList = mutableListOf<Int>()

    inputList.forEachIndexed { index, i ->
        if (index + 2 >= inputList.size) return@forEachIndexed
        val sum = i + inputList[index + 1] + inputList[index + 2]
        solutionList.add(sum)
    }

    return solveDay01Part1(solutionList.map { it.toString() })
}
