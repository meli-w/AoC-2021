package day06

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class Day06Test : FreeSpec({

    val sampleInput: List<String> = listOf(
        "3,4,3,1,2"
    )

    val sampleSolutionPart1: Int = 5934

    val sampleSolutionPart2: Long = 26984457539

    "Solving day 6" - {
        "part 1 for the sample input should return the correct output" {
            solveDay06Part1(sampleInput) shouldBe sampleSolutionPart1
        }

        "part 2 for the sample input should return the correct output" {
            solveDay06Part2(sampleInput) shouldBe 0
        }

        "timeFliesBy" - {
            "create 26 fishes after 18 days" {
                listOf(3, 4, 3, 1, 2)
                    .timeFliesBy(18) shouldBe 26
            }

            "create 26984457539 fishes after 256 days" {
                listOf(3, 4, 3, 1, 2)
                    .timeFliesBy(256) shouldBe sampleSolutionPart2
            }
        }
    }
})