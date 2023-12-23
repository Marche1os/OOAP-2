В Котлин чистого множественного наследования нет, как и в Java. 
Но в Котлине есть обеспечение Type-safety за счет объявления типа как Nullable, тогда обращаться к полям типам будет необходимо через нотацию `?.`. 

Пример полиморфного использования типа None: 

```kotlin
private val Void = None

 open class Car : MyAny() {
        open fun startMoving() {
            // какая-то логика
        }
    }

    data object None : Car() {
        override fun startMoving() {
            // отсутствие реализации
        }
    }

    fun example() {
        var example = Car()
        example.startMoving()

        example = Void
        example.startMoving()
    }
```