package day04

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class Day04Test : FreeSpec({

    val sampleInput: List<String> = listOf(
        "7,4,9,5,11,17,23,2,0,14,21,24,10,16,13,6,15,25,12,22,18,20,8,19,3,26,1",
        "",
        "22 13 17 11  0",
        " 8  2 23  4 24",
        "21  9 14 16  7",
        " 6 10  3 18  5",
        " 1 12 20 15 19",
        "",
        " 3 15  0  2 22",
        " 9 18 13 17  5",
        "19  8  7 25 23",
        "20 11 10 24  4",
        "14 21 16 12  6",
        "",
        "14 21 17 24  4",
        "10 16 15  9 19",
        "18  8 23 26 20",
        "22 11 13  6  5",
        " 2  0 12  3  7",
    )

    val sampleSolutionPart1: Int = 4512

    val sampleSolutionPart2: Int = 1924

    val bingoPuzzle: List<Board> = listOf(
        Board(
            listOf(
                listOf(BingoNumber(22), BingoNumber(13), BingoNumber(17), BingoNumber(11), BingoNumber(0)),
                listOf(BingoNumber(8), BingoNumber(2), BingoNumber(23), BingoNumber(4), BingoNumber(24)),
                listOf(BingoNumber(21), BingoNumber(9), BingoNumber(14), BingoNumber(16), BingoNumber(7)),
                listOf(BingoNumber(6), BingoNumber(10), BingoNumber(3), BingoNumber(18), BingoNumber(5)),
                listOf(BingoNumber(1), BingoNumber(12), BingoNumber(20), BingoNumber(15), BingoNumber(19)),
            )
        ),
        Board(
            listOf(
                listOf(BingoNumber(3), BingoNumber(15), BingoNumber(0), BingoNumber(2), BingoNumber(22)),
                listOf(BingoNumber(9), BingoNumber(18), BingoNumber(13), BingoNumber(17), BingoNumber(5)),
                listOf(BingoNumber(19), BingoNumber(8), BingoNumber(7), BingoNumber(25), BingoNumber(23)),
                listOf(BingoNumber(20), BingoNumber(11), BingoNumber(10), BingoNumber(24), BingoNumber(4)),
                listOf(BingoNumber(14), BingoNumber(21), BingoNumber(16), BingoNumber(12), BingoNumber(6)),
            )
        ),
        Board(
            listOf(
                listOf(BingoNumber(14), BingoNumber(21), BingoNumber(17), BingoNumber(24), BingoNumber(4)),
                listOf(BingoNumber(10), BingoNumber(16), BingoNumber(15), BingoNumber(9), BingoNumber(19)),
                listOf(BingoNumber(18), BingoNumber(8), BingoNumber(23), BingoNumber(26), BingoNumber(20)),
                listOf(BingoNumber(22), BingoNumber(11), BingoNumber(13), BingoNumber(6), BingoNumber(5)),
                listOf(BingoNumber(2), BingoNumber(0), BingoNumber(12), BingoNumber(3), BingoNumber(7)),
            )
        )
    )

    val bingoNumbers =
        listOf<Int>(7, 4, 9, 5, 11, 17, 23, 2, 0, 14, 21, 24, 10, 16, 13, 6, 15, 25, 12, 22, 18, 20, 8, 19, 3, 26, 1)
    "Solving day 4" - {

        "convert the bingoNumbers works correctly" {
            getBingoNumber(sampleInput) shouldBe bingoNumbers
        }

        "convert the bingoField correctly" {
            val bingoField: List<Board> = getBingoField(sampleInput)
            bingoField[0].board shouldBe bingoPuzzle[0].board
        }

        "part 1 for the sample input should return the correct output" {
            solveDay04Part1(sampleInput) shouldBe sampleSolutionPart1
        }

        "part 2 for the sample input should return the correct output" {
            solveDay04Part2(sampleInput) shouldBe sampleSolutionPart2
        }
    }
})
