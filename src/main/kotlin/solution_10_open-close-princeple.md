В Kotlin по умолчанию классы и функции закрыты для переопределения.

Необходимо добавить ключевое слово `open` к классу и функции, которое говорит, что этот класс/функция могут быть переопределены дочерними классами.

Пример:
```kotlin
open class Locator {

    // дочерние классы могут переопределить эту функцию
    open fun replaceSystemLocation(latLng: Pair<Double, Double>) {

    }
    
    fun seekCurrentLocation() {
        
    }
}

class GpsLocator : Locator() {
    
    override fun replaceSystemLocation(latLng: Pair<Double, Double>) {
        super.replaceSystemLocation(latLng)
    }
}
```

В Java наоборот, по умолчанию классы и функции открыты для наследования. Ключевое слово `final` у класса/функции запрещает переопределять класс/функцию соответственно.

Пример:
```java
public class Provider {
    
    public void provide() {
        
    }
    
    // дочерние классы не могут переопределить этот метод
    public final int getProviderProcessId() {
        return Process.myPid();
    }
}

class FileProvider extends Provider {

    @Override
    public void provide() {
        super.provide();
        // переопределяем метод
    }
}
```