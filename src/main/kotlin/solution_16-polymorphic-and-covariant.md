**Пример полиморфного вызова:**

```kotlin
open class Shape {
    open fun draw() {
        println("Abstract Shape")
    }
}

class Rectangle : Shape {
    override fun draw() {
        println("Rectangle")
    }
}

class ScreenUi {
    fun drawShape(shape: Shape) {
        shape.draw()
    }
}

fun main() {
    val shape: Shape = Rectangle()
    shape.draw() //полиморфный вызов. переменная shape имеет тип [Shape], но ссылается на [Rectangle]
}
```

**Пример ковариантного вызова:**

```kotlin
class Box<out T>(private val data: T) { // ковариантность достигается через использование ключевого слова [out].
    fun getValue(): T {
        return data
    }
}

open class Animal {
    open fun whoAmI() {
        println("Abstract Animal")
    }
}

class Tiger : Animal() {
    override fun whoAmI() {
        println("I'm Tiger")
    }
}

class Lion: Animal() {
    override fun whoAmI() {
        println("I'm Lion")
    }
}

fun main() {
    val tigerBox: Box<Animal> = Box<Tiger>(Tiger()) //Без включения ковариантности нельзя было бы выполнить присвание переменной Box<Animal> тип Box<Tiger>, несмотря на то, что Tiger является подтипом Animal.  
    val data = tigerBox.getValue()
    data.whoAmI()
}
```