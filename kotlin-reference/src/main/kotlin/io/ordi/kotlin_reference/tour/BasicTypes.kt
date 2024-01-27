package io.ordi.kotlin_reference.tour

/// https://kotlinlang.org/docs/kotlin-tour-basic-types.html#practice
fun mainBasicTypes() {
    val a: Int = 1000
    val b: String = "log message"
    val c: Double = 3.14
    val d: Long = 100_000_000_000_000
    val e: Boolean = false
    val f: Char = '\n'
    println(a::class.simpleName)
    println(b::class.simpleName)
    println(c::class.simpleName)
    println(d::class.simpleName)
    println(e::class.simpleName)
    println(f::class.simpleName)
}