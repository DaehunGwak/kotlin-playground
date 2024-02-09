package io.orid.cleancode.ch06object

/**
 * procedural case
 * - Geometry 에 새로운 함수 추가 시 각 도형 클래스 변경은 안해도 되나
 * - 새 도형 클래스를 추가한다면 Geometry 전반적으로 영향이 감
 */
sealed class GeometryShape {
    data class Square(
        val topLeft: Point,
        val side: Double,
    ) : GeometryShape()

    data class Rectangle(
        val topLeft: Point,
        val height: Double,
        val width: Double,
    ) : GeometryShape()

    data class Circle(
        val center: Point,
        val radius: Double,
    ) : GeometryShape()
}

object Geometry {
    private const val PI = 3.141592653589793

    fun area(shape: GeometryShape): Double {
        return when (shape) {
            is GeometryShape.Square -> shape.side * shape.side
            is GeometryShape.Circle -> shape.radius * shape.radius * PI
            is GeometryShape.Rectangle -> shape.width * shape.height
        }
    }
}

/**
 * object-oriented case
 * - 다형성을 사용해 기존 함수에 영향을 안가게 할 수는 있지만
 * - 새로운 함수 추가 시 하위 타입 모두에 영향이 간다
 */
sealed class Shape {
    abstract fun area(): Double

    data class Square(
        val topLeft: Point,
        val side: Double,
    ) : Shape() {
        override fun area(): Double = side * side
    }

    data class Rectangle(
        val topLeft: Point,
        val height: Double,
        val width: Double,
    ) : Shape() {
        override fun area(): Double = width * height
    }

    data class Circle(
        val center: Point,
        val radius: Double,
    ) : Shape() {
        companion object {
            const val PI = 3.141592653589793
        }

        override fun area(): Double = radius * radius * PI
    }
}

data class Point(
    val x: Double,
    val y: Double,
)
