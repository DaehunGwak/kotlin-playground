fun main() {
    forCase()
}

fun forCase() {
    // 범위 연산자 `..`  1 <= .. <= 3
    var result = ""
    for (i in 0 .. 20 step 2) {
        result += "$i,"
    }
    println(result)
    // until, step, downTo 활용 가능

    // collection iteration 가능
    val arr = arrayOf(1, 2, 3)
    for (item in arr) {
        println(item)
    }

    // while 도 지원
}