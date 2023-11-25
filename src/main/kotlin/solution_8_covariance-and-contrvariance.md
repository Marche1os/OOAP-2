Примеры с ковариантностью и контравариантностью на языке Kotlin.

```kotlin
open class ZooAnimal

class Tiger : ZooAnimal()

// Ковариантность
class Cage<out T: ZooAnimal>(val value: T) {
    
    // Тип Cage<Tiger> является подтипом Cage<ZooAnimal>
    fun exampleOfUsing() {
        val cage: Cage<ZooAnimal> = Cage<Tiger>(Tiger())
    }
}

// Контрвариантность
class OtherCage<in T: ZooAnimal>() {
    
    // Тип Cage<Tiger> не является подтипом Cage<ZooAnimal>
    fun wrongExample() {
        val cage: OtherCage<ZooAnimal> = OtherCage<Tiger>() // ошибка компиляции
    }

    // Тип Cage<ZooAnimal> является подтипом Cage<Tiger>
    fun example() {
        val cage: OtherCage<Tiger> = OtherCage<ZooAnimal>()
    }
}
```