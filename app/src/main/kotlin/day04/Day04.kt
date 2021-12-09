package day04

import common.InputRepo
import common.readSessionCookie
import common.solve

fun main(args: Array<String>) {
    val day = 4
    val input = InputRepo(args.readSessionCookie()).get(day = day)

    solve(day, input, ::solveDay04Part1, ::solveDay04Part2)
}

fun solveDay04Part1(input: List<String>): Int {
    val bingoNumbers: List<Int> = getBingoNumber(input)
    val bingoFields = getBingoField(input)

    return checkWinning(bingoNumbers, bingoFields)
}

fun solveDay04Part2(input: List<String>): Int {
    val bingoNumbers: List<Int> = getBingoNumber(input)
    val bingoFields = getBingoField(input)

    return checkWinningPart2(bingoNumbers, bingoFields)
}

private fun checkWinning(
    bingoNumbers: List<Int>,
    bingoFields: List<Board>
): Int {
    bingoNumbers.forEach { number ->
        bingoFields.forEach { board ->
            board.checkNumber(number)
            if (board.hasBingo()) {
                return number * board.sumUnmarkedNumbers()
            }
        }
    }
    return 0
}

private fun checkWinningPart2(
    bingoNumbers: List<Int>,
    bingoFields: List<Board>
): Int {
    val mutableBingoFields: MutableList<Board> = bingoFields.toMutableList()
    var winningCheckSum = 0

    bingoNumbers.forEach { number ->
        val winningBoards = mutableBingoFields.checkNumber(number)

        if (winningBoards.isNotEmpty()) {
            winningBoards
                .reversed()
                .forEach {
                    mutableBingoFields.removeAt(it.boardIndex)
                }

            winningCheckSum = winningBoards.last().winningCheckSum
        }
    }
    return winningCheckSum
}

private fun List<Board>.checkNumber(number: Int): List<WinningBoard> {
    val winningBoards = mutableListOf<WinningBoard>()
    forEachIndexed { index, board ->
        board.checkNumber(number)
        if (board.hasBingo()) {
            winningBoards.add(
                WinningBoard(
                    winningCheckSum = number * board.sumUnmarkedNumbers(),
                    boardIndex = index
                )
            )
        }
    }
    return winningBoards
}

data class WinningBoard(val winningCheckSum: Int, val boardIndex: Int)

class Board(val board: List<List<BingoNumber>>) {

    fun checkNumber(number: Int) {
        board.forEach { row: List<BingoNumber> ->
            row.forEach { bingoNumber ->
                if (number == bingoNumber.value) {
                    bingoNumber.isChecked = true
                }
            }
        }
    }

    fun hasBingo(): Boolean = bingoRow() || bingoColumn()

    fun sumUnmarkedNumbers(): Int = board
        .flatten()
        .filter { !it.isChecked }
        .sumOf { it.value }

    private fun bingoColumn(): Boolean {
        repeat(board.size) { columnIndex ->
            board
                .map { it[columnIndex] }
                .let { column ->
                    if (bingo(column)) {
                        return true
                    }
                }
        }
        return false
    }

    private fun bingoRow(): Boolean {
        board.forEach { row ->
            if (bingo(row)) {
                return true
            }
        }
        return false
    }

    private fun bingo(bingoNumbers: List<BingoNumber>): Boolean = bingoNumbers.all(BingoNumber::isChecked)
}

data class BingoNumber(val value: Int, var isChecked: Boolean = false)

fun getBingoNumber(input: List<String>): List<Int> = input
    .first()
    .split(",")
    .map { it.toInt() }

fun getBingoField(input: List<String>): List<Board> = input
    .let { it.subList(2, it.size) }
    .filterNot { it.isEmpty() }
    .chunked(5)
    .map { bingoField: List<String> ->
        Board(
            bingoField
                .map { row ->
                    row
                        .replace("(\\s+)?(\\d+)".toRegex(), "$2,")
                        .split(",")
                        .filterNot { it.isEmpty() }
                        .map { BingoNumber(it.toInt()) }
                }
        )
    }