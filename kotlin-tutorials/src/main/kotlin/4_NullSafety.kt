fun main() {
    var a: String? = null
    println(a?.length)

    println(if (a != null) a.length else 0)
    println(a?.length ?: 0) // elvis operation


}