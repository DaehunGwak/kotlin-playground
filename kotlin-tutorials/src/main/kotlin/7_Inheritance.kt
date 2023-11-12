fun main() {
    val dog = Dog(10)
    println(dog.age)
    dog.bark()

    val dog2: Animal = BullDog()
    dog2.age = 20
    dog2.bark()

    val dev: Developer = BackendDeveloper(20)
    println(dev.age)
    dev.code("java and kotlin")
}

/**
 * 자바는 final class 로 상속을 막을 수 있음
 * kotlin 의 모든 클래스 조상은 Any
 * - equals, hashCode, toString 을 제공하고 있음
 * - 코틀린은 기본적으로 final 클래스이고 `open` 키워드를 통해 상속 기능을 제공
 */

open class Animal {
    open var age: Int = 0

    open fun bark() {
        println("nothing bark")
    }
}

open class Dog(
    final override var age: Int = 0,
): Animal() {

    override fun bark() {
        println("멍멍")
    }
}

class BullDog: Dog() {
//    override var age: Int = 0 // 상위에서 final 로 선언 되어 재정의 불가

    override fun bark() {
        super.bark()
        println("bull bark")
    }
}

abstract class Developer {

    abstract var age: Int
    abstract fun code(language: String)
}

class BackendDeveloper(override var age: Int): Developer() {

    override fun code(language: String) {
       println("i code with $language")
    }
}

