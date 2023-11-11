/**
 * 코틀린의 모든 예외는 Throwable 을 상속한다
 * - Throwable
 *  - Error - Unchecked Error (예측이 힘들다는 성격을 가지고 있음)
 *  - Exception
 *      - RuntimeException (Unchecked exceptions)
 *      - Checked Exception
 * 코드가 정상적으로 수행되지 않는 익셉션이 발생가능한 코드의 함수 리턴은 `Nothing` 으로 구성된다
 */

fun main() {
    try {
        Thread.sleep(1) // checked exception 을 강제하지 않음
    } catch (e: Exception) {
        println("에러 발생")
        e.printStackTrace()
    } finally {
        println("finally 실행")
    }

    val a = try {
        "1234".toInt()
    } catch (e: Exception) {
        println("예외 발생!")
    }
    println(a) // 1234 print 됨

//    throw RuntimeException("런타임 익셉션 발생!")
//    failFast("일리걸 아규먼트 익셉션")

    val b: String? = null
    val c: String = b ?: failFast("b is null") // Nothing 으로 들어오므로 non-null 타입 추론이 진행됨
    println(c.length)
}
fun failFast(message: String): Nothing {
    throw IllegalArgumentException(message)
}