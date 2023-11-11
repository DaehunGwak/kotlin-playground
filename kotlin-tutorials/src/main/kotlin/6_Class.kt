fun main() {
    val beverage = Beverage()
    beverage.name = "음료수"
    beverage.price = 2000
    println(beverage.toString())

    val coffee = Coffee(name = "123", price = 123)
    println(coffee)
}

class Coffee(
    val name: String,
    val price: Int, // 후행 comma 가 가능해서, 변경 라인을 줄일 수 있음
) {

    // custom field getter
    val brand: String
        get() {
            return "스타벅스"
        }

    override fun toString(): String {
        return "Coffee(name='$name', price=$price, brand=$brand)"
    }
}

class Beverage(
    var name: String = "",
    var price: Int = 0,
) {

    // custom field setter
    var quantity: Int = 0
        set(value) {
            if (value > 0) {
                field = value
                // backing field?
                // 직접 할당하게 되면 무한 룹이 돌게 됨 (코틀린 자체가 필드 접근을 메소드 호출로 진행함)
                // 따라서, field 키워드를 통해서 해당 스코프에 해당되는 필드에 접근을 진행하고 필드를 직접 지정하면 안됨
            }
        }

    override fun toString(): String {
        return "Beverage(name='$name', price=$price, quantity=$quantity)"
    }
}

class EmptyClass // 본문 없는 클래스