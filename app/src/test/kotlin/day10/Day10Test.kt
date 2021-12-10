package day10

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class Day10Test : FreeSpec({

    val sampleInput: List<String> = listOf(
        "[({(<(())[]>[[{[]{<()<>>",
        "[(()[<>])]({[<{<<[]>>(",
        "{([(<{}[<>[]}>{[]{[(<()>",
        "(((({<>}<{<{<>}{[]{[]{}",
        "[[<[([]))<([[{}[[()]]]",
        "[{[{({}]{}}([{[{{{}}([]",
        "{<[[]]>}<{[{[{[]{()[[[]",
        "[<(<(<(<{}))><([]([]()",
        "<{([([[(<>()){}]>(<<{{",
        "<{([{{}}[<[[[<>{}]]]>[]]",
    )

    val sampleSolutionPart1: Int = 26397

    val sampleSolutionPart2: Int = 288957

    "Solving day 10" - {
        "part 1 for the sample input should return the correct output" {
            solveDay10Part1(sampleInput) shouldBe sampleSolutionPart1
        }

        "part 2 for the sample input should return the correct output" {
            solveDay10Part2(sampleInput) shouldBe sampleSolutionPart2
        }
    }

    "{([(<{}[<>[]}>{[]{[(<()> - Expected ], but found } instead." {
        "{([(<{}[<>[]}>{[]{[(<()>".getFirstIllegalCharacter() shouldBe Chunk.CURLY
    }
    "[[<[([]))<([[{}[[()]]] - Expected ], but found ) instead." {
        "[[<[([]))<([[{}[[()]]]".getFirstIllegalCharacter() shouldBe Chunk.ROUND
    }
    "[{[{({}]{}}([{[{{{}}([] - Expected ), but found ] instead." {
        "[{[{({}]{}}([{[{{{}}([]".getFirstIllegalCharacter() shouldBe Chunk.SQUARE
    }

    "[<(<(<(<{}))><([]([]() - Expected >, but found ) instead." {
        "[<(<(<(<{}))><([]([]()".getFirstIllegalCharacter() shouldBe Chunk.ROUND
    }

    "<{([([[(<>()){}]>(<<{{ - Expected ], but found > instead." {
        "<{([([[(<>()){}]>(<<{{".getFirstIllegalCharacter() shouldBe Chunk.POINTY
    }

    "A ROUND chunk gets closed by another ROUND chunk" {
        Chunk.ROUND.isCorrectClosing(Chunk.ROUND) shouldBe true
    }

    "A SQUARE chunk gets not closed by a ROUND chunk" {
        Chunk.SQUARE.isCorrectClosing(Chunk.ROUND) shouldBe false
    }

    "A CURLY chunk gets closed by a CURLY chunk" {
        Chunk.CURLY.isCorrectClosing(Chunk.CURLY) shouldBe true
    }

    "A } is a CURLY chunk" {
        '}'.getChunk() shouldBe Chunk.CURLY
    }

    "A ( is a ROUND chunk" {
        '('.getChunk() shouldBe Chunk.ROUND
    }

    "A < is a POINTY chunk"{
        '<'.getChunk() shouldBe Chunk.POINTY
    }

    "A ROUND chunk is worth 3 points" {
        Chunk.ROUND.points shouldBe 3
    }

    "A ROUND chunk is a missing point of 1" {
        Chunk.ROUND.missingPoints shouldBe 1
    }

    "[({(<(())[]>[[{[]{<()<>> - Complete by adding }}]])})]. This results in 288957 points." {
        "[({(<(())[]>[[{[]{<()<>>".getPointsForClosingString() shouldBe 288957
    }

    "[(()[<>])]({[<{<<[]>>( - Complete by adding )}>]}). This results in 5566 points." {
        "[(()[<>])]({[<{<<[]>>(".getPointsForClosingString() shouldBe 5566
    }

    "(((({<>}<{<{<>}{[]{[]{} - Complete by adding }}>}>)))). This results in 1480781 points." {
        "(((({<>}<{<{<>}{[]{[]{}".getPointsForClosingString() shouldBe 1480781
    }

    "{<[[]]>}<{[{[{[]{()[[[] - Complete by adding ]]}}]}]}>. This results in 995444 points." {
        "{<[[]]>}<{[{[{[]{()[[[]".getPointsForClosingString() shouldBe 995444
    }

    "<{([{{}}[<[[[<>{}]]]>[]] - Complete by adding ])}>. This results in 294 points." {
        "<{([{{}}[<[[[<>{}]]]>[]]".getPointsForClosingString() shouldBe 294
    }
})