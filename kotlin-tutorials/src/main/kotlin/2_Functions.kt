fun main() {
    println(sumsum(1, 2.2))
    println(sumsum2(1, 2.2))

    // default parameter
    println(hello())
    println(hello("uuuu"))

    // named argument
    log(message = "abc")
    log(message = "debug msg", level = "DEBUG")
    log("WARN", "warning msg")
    val level = "ERROR"
    log(level, "error msg")
}

fun sumsum(a: Int, b: Double) : Double = a + b

fun sumsum2(a: Int, b: Double) = a + b

fun hello(name: String = "annony") : String {
    return "Hello, $name"
}

fun log(level: String = "INFO", message: String) {
    println("[$level] $message")
}

