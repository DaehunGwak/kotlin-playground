// top level 선언
val _FIVE = 5

fun main() {
    val a: Int = 1
    val b = 1 // 타입 선언 없이 가능
    val c: Int // 지연 할당
    c = 3

    // val, var
    // val: value > read only
    // var: variable > 재할당 가능
    val value1 = 2
    // value1 = 5 // 컴파일 오류 발생
    var variable2 = "what it is"
    // variable2 = 4 // 타입 변경은 불가능 (컴파일 에러)
    variable2 = "new one"

    println(variable2)
}