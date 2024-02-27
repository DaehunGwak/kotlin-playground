package basic

import kotlin.math.PI

/**
 * - Java 와는 달리 Unreachable code 는 오류가 아니나 IDE 에서 죽은 코드라 알려줌
 * - 파라미터는 자동적으로 지역 변수 취급 (Kotlin 은 무조건 val - Java의 final 로 취급!)
 *   - call-by-value 를 기본적으로 채택 (참조가 넘어오면 변경은 가능, e.g. Array)
 * - 반환 타입 권장
 *   - 예외 두 가지
 *     1. Unit 반환 시: Kotlin Unit type - Java void
 *     2. 식이 본문인 함수: circleArea2 함수 참조
 * - 인자 기본 값은 뒤로
 */
fun main() {
    defaultFunction()
    callByValueTest()
    argumentsSample()
    defaultValueSample()
    varargSample()
}


fun defaultFunction() {
    val radius = 10.0
    println("Circle area: ${circleArea(radius)}")
    println("Circle area2: ${circleArea2(radius)}")
    println("Circle area3: ${circleArea3(radius)()}")
}

fun circleArea(radius: Double): Double {
    return PI * radius * radius
}

fun circleArea2(radius: Double) = PI * radius * radius

// 주의! 아래는 함수를 리턴하는 것임
fun circleArea3(radius: Double) = { PI * radius * radius }


fun callByValueTest() {
    val a = intArrayOf(1, 2, 3)
    increment(a)
    println(a.contentToString()) // 2, 2, 3
}

fun increment(a: IntArray) {
    ++a[0]
}


fun argumentsSample() {
    val w = 20.0
    val h = 40.0
    println("Positional argument: ${rectangleArea(w, h)}")
    println("Named argument: ${rectangleArea(width = w, height = h)}")
    println("Named argument2: ${rectangleArea(height = h, width = w)}")
}

fun rectangleArea(width: Double, height: Double): Double {
    return width * height
}


fun defaultValueSample() {
    mul(10) // 오류 1번 함수를 Any 로 변경해야함
    mul(10, 20)
    mul(10, 20, 30)
}

fun mul(a: Number, b: Int = 1) = (a as Int) * b // 기존: fun mul(a: Int, b: Int = 1) = a * b

fun mul(a: Int, b: Long = 1) = a * b

fun mul(a: Int, b: Int, c: Int = 1) = a * b * c


fun varargSample() {
    printSorted(4, 2, 3, 7)
}

fun printSorted(vararg items: Int) {
    items.sort()
    println(items.contentToString())
}