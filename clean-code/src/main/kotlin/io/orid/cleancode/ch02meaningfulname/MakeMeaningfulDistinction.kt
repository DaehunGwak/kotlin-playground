package io.orid.cleancode.ch02meaningfulname

// page 26
fun main() {
    val a1 = "source_bad".toCharArray()
    val a2 = CharArray(a1.size)
    copyCharsBad(a1, a2)
    println(a2)

    val source = "source_good".toCharArray()
    val destination = CharArray(source.size)
    copyCharsGood(source, destination)
    println(destination)
}

// bad case
fun copyCharsBad(
    a1: CharArray,
    a2: CharArray,
) {
    for (i in a1.indices) {
        a2[i] = a1[i]
    }
}

// good case
fun copyCharsGood(
    source: CharArray,
    destination: CharArray,
) {
    for (i in source.indices) {
        destination[i] = source[i]
    }
}
