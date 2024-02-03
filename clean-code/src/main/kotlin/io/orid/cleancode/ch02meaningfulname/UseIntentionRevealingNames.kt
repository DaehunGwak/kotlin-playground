package io.orid.cleancode.ch02meaningfulname

// page 22. sample code
fun main() {
    getThem().forEach { it ->
        print("[")
        it.forEach { print("$it,") }
        println("]")
    }
    getFlaggedCells().forEach { it ->
        print("[")
        it.forEach { print("$it,") }
        println("]")
    }
    getFlaggedCells2().forEach { println(it) }
}

// Bad Case
private val theList =
    listOf(
        intArrayOf(0, 0, 0),
        intArrayOf(0, 0, 1),
        intArrayOf(4, 1, 0),
        intArrayOf(4, 1, 1),
    )

fun getThem(): List<IntArray> {
    val list1 = mutableListOf<IntArray>()
    for (x in theList) {
        if (x[0] == 4) list1.addLast(x)
    }
    return list1
}

// Good Case
private const val STATUS_INDEX = 0
private const val FLAGGED = 4
private val gameBoard =
    listOf(
        intArrayOf(0, 0, 0),
        intArrayOf(0, 0, 1),
        intArrayOf(4, 1, 0),
        intArrayOf(4, 1, 1),
    )

fun getFlaggedCells(): List<IntArray> {
    val flaggedCells = mutableListOf<IntArray>()
    for (cell in gameBoard) {
        if (cell[STATUS_INDEX] == FLAGGED) {
            flaggedCells.addLast(cell)
        }
    }
    return flaggedCells
}

// More Good Case
class Cell(
    private var status: CellStatus,
    private var posX: Int,
    private var posY: Int,
) {
    fun isFlagged(): Boolean {
        return status == CellStatus.FLAGGED
    }

    override fun toString(): String {
        return "Cell(status=$status, posX=$posX, posY=$posY)"
    }
}

enum class CellStatus {
    EMPTY,
    FLAGGED,
}

private val gameBoardCells =
    listOf(
        Cell(status = CellStatus.EMPTY, posX = 0, posY = 0),
        Cell(status = CellStatus.EMPTY, posX = 0, posY = 1),
        Cell(status = CellStatus.FLAGGED, posX = 1, posY = 0),
        Cell(status = CellStatus.FLAGGED, posX = 1, posY = 1),
    )

fun getFlaggedCells2(): List<Cell> {
    val flaggedCells = mutableListOf<Cell>()
    for (cell in gameBoardCells) {
        if (cell.isFlagged()) {
            flaggedCells.addLast(cell)
        }
    }
    return flaggedCells
}
