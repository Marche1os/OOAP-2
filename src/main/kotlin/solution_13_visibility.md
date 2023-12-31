1.  
```kotlin
open class A {
    open fun public() {

    }
}

class B : A() {
    override fun public() {
        super.public()
    }
}
```

2. В Kotlin, как и в Java, нельзя сужать область видимости метода.
Пример:

```java
class A {
    public void someMethod1() {
    }

    protected void someMethod2() {
    }
}

class B extends A {
    @Override
    private void someMethod1() { // нельзя, ошибка компиляции
        super.someMethod1();
    }

    @Override
    public void someMethod2() { // расширили область видимости, все ок
        super.someMethod2();
    }
}
```
3. Стандартно нельзя ни в Kotlin, ни в Java. Разве что через Reflection API. 
4. Из потомка нет доступа к приватному методу родительского класса.

```java
public class A {
    private void method() {

    }
}

class B extends A {
    
    @Override
     private void method() { // Ошибка компиляции, метод не будет найден
        super.method();
    }
}

```
