package day05

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class Day05Test : FreeSpec({

    val sampleInput: List<String> = listOf(
        "0,9 -> 5,9",
        "8,0 -> 0,8",
        "9,4 -> 3,4",
        "2,2 -> 2,1",
        "7,0 -> 7,4",
        "6,4 -> 2,0",
        "0,9 -> 2,9",
        "3,4 -> 1,4",
        "0,0 -> 8,8",
        "5,5 -> 8,2",
    )

    val sampleSolutionPart1: Int = 5

    val sampleSolutionPart2: Int = 12

    val parsedInput = listOf<Pair<Coordinate, Coordinate>>(
        Coordinate(0, 9) to Coordinate(5, 9),
        Coordinate(8, 0) to Coordinate(0, 8),
        Coordinate(9, 4) to Coordinate(3, 4),
        Coordinate(2, 2) to Coordinate(2, 1),
        Coordinate(7, 0) to Coordinate(7, 4),
        Coordinate(6, 4) to Coordinate(2, 0),
        Coordinate(0, 9) to Coordinate(2, 9),
        Coordinate(3, 4) to Coordinate(1, 4),
        Coordinate(0, 0) to Coordinate(8, 8),
        Coordinate(5, 5) to Coordinate(8, 2),
    )

    "Solving day 5" - {

        "sample Input is formatted correctly"{
            parseInput(sampleInput) shouldBe parsedInput
        }

        "part 1 for the sample input should return the correct output" {
            solveDay05Part1(sampleInput) shouldBe sampleSolutionPart1
        }

        "part 2 for the sample input should return the correct output" {
            solveDay05Part2(sampleInput) shouldBe sampleSolutionPart2
        }
    }
})
