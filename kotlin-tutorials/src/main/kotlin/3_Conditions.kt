fun main() {
//    ifCase()
    whenCase()
}

fun ifCase() {
    // if 는 표현식, 따라서 삼항 연산자가 필요 없음
    var temp1 = if (10 > 0) "trueCase" else "falseCase"
    println(temp1)

    var temp2 = if (10 < 0) {
        println("what")
        "ttCase"
    } else {
        println("the")
        "ffCase"
    }
    println(temp2)

    // 일반적인 if 도 가능
    if (temp1 == "trueCase") {
        println("normal true if")
    }
    else {
        println("normal false if")
    }
}

fun whenCase() {
    // java switch 구문 대체 가능
    val day = 2
    val result = when(day) {
        1 -> "월요일"
        2 -> "화요일"
        3 -> "수요일"
        else -> "기타"
    }
    println(result)

    when(getColor()) {
        Color.RED -> println("RED CASE")
        Color.BLUE -> println("BLUE CASE")
    }

    when(getNumber()) {
        1, 2 -> println("1, 2")
        3, 4 -> println("3, 4")
        else -> println("others")
    }
}

fun getColor(): Color = Color.RED;

enum class Color {
    RED, BLUE
}

fun getNumber(): Int = 3