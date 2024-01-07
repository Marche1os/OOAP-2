class Box<out T>(private val data: T) { // ковариантность достигается использованием ключевого слова [out].
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