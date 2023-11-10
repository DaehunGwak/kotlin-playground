fun main() {
    val nullStr = getNullStr()

    println(nullStr?.length) // 그냥 호출은 못함, 컴파일 에러 발생
    println(getLength(nullStr))

    val c: String? = null
//    val d = c!!.length // 단언 연산자: 여기에서 c 는 null 이면 안된다라는 의도 표현
    // 어기면 NPE 발생

    // java 에서 작성한 코드를 코틀린에서 불러와서 사용할 수 있지만
    // java 코드이다 보니 null 안정성이 떨어지게됨
    // 코틀린에서 자바 코드를 사용할땐 safe call 잘 이용하자
    println(NullSafety.getNullStr()?.length ?: 0)
}

fun getNullStr(): String? = null

fun getLength(str: String?): Int = str?.length ?: 0