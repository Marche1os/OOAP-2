interface Addable<T> {
    operator fun plus(other: T): T
}

open class Vector<T>(
    val elements: List<T>
): MyAny() where T : General, T : Addable<T> {

    operator fun plus(other: Vector<T>): Vector<T>? {
        if (this.elements.size != other.elements.size)
            return null

        val result = this.elements
            .zip(other.elements)
            .map { (a, b) -> a + b }

        return Vector(result)
    }
}

class IntegerValue(
    val value: Int
): MyAny(), Addable<IntegerValue> {
    override fun plus(other: IntegerValue): IntegerValue = IntegerValue(this.value + other.value)
}

class AddableVector<T>(elements: List<T>) : Vector<T>(elements), Addable<AddableVector<T>> where T : General, T : Addable<T> {
    override fun plus(other: AddableVector<T>): AddableVector<T> {
        return AddableVector(super.plus(other)?.elements ?: emptyList())
    }
}

fun main() {
    val inner1 = AddableVector(listOf(IntegerValue(1), IntegerValue(2)))
    val inner2 = AddableVector(listOf(IntegerValue(3), IntegerValue(4)))
    val outer1 = AddableVector(listOf(inner1))
    val outer2 = AddableVector(listOf(inner2))

    val sum = outer1 + outer2
    // sum = AddableVector<AddableVector<IntegerValue>>
    // результат: 4 и 6
    sum.let {
        it.elements.forEach { nv ->
            nv.elements.forEach { iv ->
                println(iv.value)
            }
        }
    }
}