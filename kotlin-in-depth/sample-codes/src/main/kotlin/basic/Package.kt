package basic

import basic.util.sortedLongList as sorted

/**
 * - Java 와 달리 import static 없음
 */
fun main() {
    val longList = listOf(3L, 7L, 5L)
    val sortedList = sorted(longList)
    println(longList)
    println(sortedList)
}
