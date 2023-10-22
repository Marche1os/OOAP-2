/**
 * Здесь [transport] - пример композиции, когда одна сущность [UniversalDriver] содержит транспортное средство [transport]
 * Здесь же и пример полиморфизма, когда некий [UniversalDriver] способен управлять любым [transport].
 * Т.е. мы можем назначить такому водителю любое транспортное средство и вызывать базовые методы движения.
 */
open class UniversalDriver<T : Transport>(
    private val transport: T
) {

    fun moveForward() {
        transport.moveForward()
    }

    fun moveBack() {
        transport.moveBack()
    }
}

class Daniel(private val taxiMarseille: TaxiMarseille) : UniversalDriver<TaxiMarseille>(taxiMarseille) {
    fun up() {
        taxiMarseille.up()
    }
    
    fun down() {
        taxiMarseille.down()
    }
}

/**
 * Пример наследования
 * Базовый тип [Transport] и реализация типа [Car] и выполненный на основе [Car] тип [TaxiMarseille],
 * который является так же типом [Car], но обладает дополнительным поведением, например, летающей машины
 */
interface Transport {
    fun moveForward()

    fun moveBack()
}

open class Car : Transport {
    override fun moveForward() {

        // какая-то реализация
    }

    override fun moveBack() {
        // какая-то реализация
    }
}

class TaxiMarseille : Car() {

    fun up() {
        // набрать высоту
    }

    fun down() {
        // снизить высоту
    }
}