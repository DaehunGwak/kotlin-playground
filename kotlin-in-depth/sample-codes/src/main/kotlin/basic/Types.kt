package basic

import java.util.Date

/**
 * - kotlin 의 모든 클래스는 Any의 하위 타입
 * - 암시적 박싱을 이용하기 때문에 상황에 따라 Primitive 를 쓸지 boxing type 을 쓸지 결정
 * - Java String `.equals()` 와 같은 역할로 Kotlin String 은 == != 로 다른 객체 비교 가능
 * - 객체 생성 new 연산자 없음
 * - 박싱된 타입이 아닌 primitive array 가 필요한경우 <TypeName>Array or <typeName>ArrayOf 사용 권장
 * - Kotlin 에서 Array<String>는 Array<Any> 의 하위 타입이 아니므로 대입 불가
 */
fun main() {
    // numbers
    val int1: Int = 1
    val any1: Any = 1.2 // 모든 클래스의 최상단 부모
    println("$int1, $any1")

    val n = 34_721_189 // Int
    val l = 4L // Long

    println(n)
    println("${Int.MIN_VALUE}, ${Int.MAX_VALUE}") // 템플릿 문자열
    println("${Long.MIN_VALUE}, ${Long.MAX_VALUE}")
    println("${Double.MIN_VALUE}, ${Double.MAX_VALUE}")
    println("${Float.MIN_VALUE}, ${Float.MAX_VALUE}")

    val d = 3.13 // Double
    val f = 2.14f // Float
//    val d: Double = 1.4f // error
    println(3 * Double.NaN)

    // Char
    val cc = n.toChar()
    println(cc)

    // comparison numbers
    val aa = 1
    val bb = 2L
//    println(aa == bb) // type 불일치 비교 에러 (동등성은 안됨)
    println(aa.toLong() == bb) // 통과
    println(aa < bb) // 비교는 다른 타입 가능

    // string
    val name = "Daehun"
    val message1 = "Hello, $name!\nToday is ${Date()}"
    println(message1) // 객체는 toString 자동 적용
    val message = """
        Hello, $name!
        Today is ${Date()}
    """.trimIndent() // raw string
    println(message)
    println(name + message) // concatenate
    println(message == message1) // true: 내용만을 비교 가능 (Java String .equals 와 같음)
    println(message === message1) // false: 참조 동등성 비교

    // arrays
    val aaa = emptyArray<String>()
    val bbb = arrayOf(1, 2, 3) // 다 박싱 됨
    val ccc = arrayOf(1, "Hello")

    val squares = Array(3) { it * it } // 0, 1, 4 , 다만 다 박싱됨
    squares.forEach { print("$it, ") }
    println()
    val operations = charArrayOf('+', '-') // 해당 방식 권장
    val squares2 = IntArray(10) { it * it } // 해당 방식 권장
    squares2.forEach { print("$it, ") }
    println()

    val squares3 = longArrayOf(1, 2, 3, 4)
    val numbers = squares3 // 자바와 마찬가지로 레퍼런스 저장
    numbers[0] = 20
    println(squares3[0]) // 20

    var va = arrayOf(1, 1, 1)
//    va = arrayOf("one", "two") // 타입 불일치

    // arrays operations
    var aa1 = intArrayOf(1, 2, 3) + 4 // 1, 2, 3, 4
    var aa2 = intArrayOf(1, 2, 3) + intArrayOf(4, 5) // 1, 2, 3, 4, 5
    var aa3 = arrayOf(1, 2, 3, 4)
    var aa4 = intArrayOf(1, 2, 3, 4)
//    println(aa3 == aa4) // another type error
    println(aa1 == aa4) // false
    println(aa1.contentEquals(aa4)) // true
}
