package basic

/**
 * - kotlin 에서는 삼항 연산자 대신 if else
 * - Unit 과 Nothing 의 차이
 *   - Unit: void 와 같은 의미이나 함수형 지원을 위해 싱글턴 인스턴스로 만들어 둔 것
 *   - Nothing: 함수가 정상적으로 종료되지 않음 (like 예외) 을 나타낼 때 쓰임, 모든 클래스의 하위 클래스
 *     - Nothing 예시, throws, break, continue
 * - when: else if 패턴 나타날 경우 사용 가능 (switch 와는 조건 검사 가능하다는 점에서 다름)
 */
fun main() {
    println(max(4, 6))
    println(max(4, 4))
    println(max2(4, 6))
    println(max2(4, 4))
}

fun max(a: Int, b : Int): Int {
    if (a > b) {
        return a
    }
    return b
}

fun max2(a: Int, b: Int) = if (a > b) a else b

fun hexDigit(n: Int): Char {
    return when (n) {
        in 0..9 -> '0' + n
        in 10.. 15 -> 'A' + n - 10
        else -> '?'
    }
}

fun numberDescription(n: Int): String = when (n) {
    0 -> "Zero"
    1, 2, 3 -> "Small" // , 는 || 취급
    in 4..9 -> "Medium"
    else -> "Huge"
}
