open class Shape {
    open fun draw() {
        println("Abstract Shape")
    }
}

class Rectangle : Shape() {
    override fun draw() {
        println("Rectangle")
    }
}

fun main() {
    var shape: Shape = Shape()
    val rectangle: Rectangle = Rectangle()

    shape.draw() //полиморфный вызов. переменная shape имеет тип [Shape], но ссылается на [Rectangle].

    shape = rectangle

    shape.draw()
}