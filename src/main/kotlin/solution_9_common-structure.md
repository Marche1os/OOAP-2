```kotlin
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import java.util.*
import kotlin.reflect.KClass

@Serializable
sealed class General : Any() {

    // В котлине нельзя передавать мутабельные параметры. Решил обойти, создав wrapper над объектом, враппер содержит мутабельное значение.
    // Можно было просто возвращать новое значение, но старался соответствовать условию задачи
    open fun copyTo(target: Wrapper<General>) {
        target.value = deserialize(serialize())
    }

    open fun clone(): General {
        return deserialize(serialize())
    }

    open fun deepEquals(other: General): Boolean {
        return Objects.deepEquals(this, other)
    }

    open fun serialize(): String {
        return Json.encodeToString(serializer(), this)
    }

    open fun deserialize(serialized: String): General {
        return Json.decodeFromString(serialized)
    }

    open fun print() {
        println(this.toString())
    }

    fun isTypeOf(type: KClass<*>): Boolean {
        return this::class == type
    }

    fun getType(): KClass<out General> {
        return this::class
    }

    fun General.asWrapper() = Wrapper(this)

    inner class Wrapper<T>(var value: T)
}

@Serializable
sealed class MyAny : General() {
    // В котлине базовый для всех классов тип называется Any. Поэтому переименовал создаваемый нами тип в MyAny.
}
```