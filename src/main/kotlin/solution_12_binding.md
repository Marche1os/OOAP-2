

```kotlin
object None : MyAny()

@Serializable
open class General : Any() {
    // ...
}

@Serializable
open class MyAny : General() {
    // В котлине базовый для всех классов тип называется Any. Поэтому переименовал создаваемый нами тип в MyAny.

    inline fun <reified T> MyAny.assignmentAttempt(): MyAny {
        return if (this is T) this else None
    }
}
```

Пример использования:
```kotlin
fun main() {
    val any = MyAny()

    checkDriveOnNoneType(Drive()) // Not None
    checkDriveOnNoneType(any) // None
}

fun checkDriveOnNoneType(obj: MyAny) {
    val newObj = obj.assignmentAttempt<Drive>()
    if (newObj is None) {
        println("None")
    } else {
        println("Not None")
    }
}
```