package day05

import common.InputRepo
import common.readSessionCookie
import common.solve

fun main(args: Array<String>) {
    val day = 5
    val input = InputRepo(args.readSessionCookie()).get(day = day)

    solve(day, input, ::solveDay05Part1, ::solveDay05Part2)
}


fun solveDay05Part1(input: List<String>): Int = parseInput(input)
    .asSequence()
    .filter { (c1, c2) ->
        c1.x == c2.x || c1.y == c2.y
    }
    .map { (c1, c2) ->
        when (c1.x == c2.x) {
            true -> {
                horizontalList(
                    c1.x,
                    range = if (c1.y < c2.y) c1.y..c2.y else c2.y..c1.y
                )
            }
            false -> {
                verticalList(
                    c1.y,
                    range = if (c1.x < c2.x) c1.x..c2.x else c2.x..c1.x
                )
            }
        }
    }
    .flatten()
    .groupBy { it }
    .count { map: Map.Entry<Coordinate, List<Coordinate>> ->
        map.value.size >= 2
    }

fun solveDay05Part2(input: List<String>): Int = parseInput(input)
    .map { (c1, c2) ->
        when {
            c1.x == c2.x -> {
                horizontalList(
                    c1.x,
                    range = if (c1.y < c2.y) c1.y..c2.y else c2.y..c1.y
                )
            }
            c1.y == c2.y -> {
                verticalList(
                    c1.y,
                    range = if (c1.x < c2.x) c1.x..c2.x else c2.x..c1.x
                )
            }
            else -> {
                when {
                    c1.y < c2.y -> {
                        diagonalList(
                            startX = c1.x,
                            liminater = { if (c1.x < c2.x) it + 1 else it - 1 },
                            range = if (c1.x < c2.x) c1.y..c2.y else c1.y..c2.y
                        )
                    }
                    else -> {
                        diagonalList(
                            startX = c2.x,
                            liminater = { if (c1.x < c2.x) it - 1 else it + 1 },
                            range = if (c1.x < c2.x) c2.y..c1.y else c2.y..c1.y
                        )
                    }
                }
            }
        }
    }
    .flatten()
    .groupBy { it }
    .count { map: Map.Entry<Coordinate, List<Coordinate>> ->
        map.value.size >= 2
    }

fun horizontalList(x: Int, range: IntRange): List<Coordinate> = mutableListOf<Coordinate>()
    .apply {
        range.forEach {
            this.add(Coordinate(x, it))
        }
    }
    .toList()

fun verticalList(y: Int, range: IntRange): List<Coordinate> = mutableListOf<Coordinate>()
    .apply {
        range.forEach {
            this.add(Coordinate(it, y))
        }
    }
    .toList()

fun diagonalList(startX: Int, liminater: (Int) -> Int, range: IntRange): List<Coordinate> = mutableListOf<Coordinate>()
    .apply {
        var x = startX
        range.forEach {
            this.add(Coordinate(x, it))
            x = liminater(x)
        }
    }
    .toList()


fun parseInput(input: List<String>): List<Pair<Coordinate, Coordinate>> = input
    .map { line ->
        line
            .split(" -> ")
            .let {
                it.first().toCoordinate() to it.last().toCoordinate()
            }

    }

private fun String.toCoordinate(): Coordinate {
    val coordinate = this.split(",")
    return Coordinate(coordinate.first().toInt(), coordinate.last().toInt())
}

data class Coordinate(val x: Int, val y: Int)