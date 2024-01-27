package io.ordi.kotlin_reference.tour

/// https://kotlinlang.org/docs/kotlin-tour-collections.html#practice
fun mainCollections() {
    learned()
    exercise1()
    exercise2()
    exercise3()
}

fun learned() {
    // Read only
    val readOnlyShapes = listOf("triangle", "square", "circle")
    println(readOnlyShapes)

    // Mutable
    val shapes: MutableList<String> = mutableListOf("triangle", "square", "circle")
    println(shapes)
}

fun exercise1() {
    val greenNumbers = listOf(1, 4, 23)
    val redNumbers = listOf(17, 2)
    println("total numbers: ${greenNumbers.count() + redNumbers.count()}")
}

fun exercise2() {
    val supported = setOf("HTTP", "HTTPS", "FTP")
    val requested = "smtp"
    val isSupported = supported.contains(requested.uppercase())
    println("Support for $requested: $isSupported")
}

fun exercise3() {
    val number2word = mapOf(
        1 to "one",
        2 to "two",
        3 to "three",
    )
    val n = 2
    println("$n is spelt as '${number2word[n]}'")
}