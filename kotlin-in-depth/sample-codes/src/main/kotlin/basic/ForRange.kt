package basic

/**
 * - `.iterator()` 함수만 클래스에 구현되어 있으면 for-range 사용 가능 (Java 와 달리 Iterable 구현 안해도 됨)
 * - continue, break에 label 지정 가능 `<labelName>@ for`, `continue@<labelName>`
 * - trailrec 으로 꼬리 재귀 함수를 이터레이션으로 바꿔줌... 오..
 */
fun main() {
    for (c in 'a'..'h') {
        print("$c,")
    }
    println()

    println("aaa" in "aaa".."hhh")
    println("zzz" in "aaa".."hhh")

    for (i in 1..10) {
        print("$i,")
    }
    println()

    for (i in 1 until 10) {
        print("$i,")
    }
    println()

    for (i in 10 downTo  1) {
        print("$i,")
    }
    println()

    for (i in 10 downTo  1) {
        print("$i,")
    }
    println()

    for (i in 1..10 step 2) {
        print("$i,")
    }
    println()

    for (i in 10 downTo  1 step 2) {
        print("$i,")
    }
    println()
}

fun indexOf(subarray: IntArray, array: IntArray): Int {
    outer@ for (i in array.indices) {
        for (j in subarray.indices) {
            if (subarray[j] != array[i + j]) continue@outer
        }
        return i
    }
    return -1
}
