Современная разработка в продуктовых командах зачастую требует поддерживать различные варианты исполнения кода одной и той же части функционала.
Это обусловлено проходящими экспериментами или закрытым фича-тогглом части функционала. Почему-то я даже не встречал устоявшихся сильных подходов по организации такого кода.

Динамическое связывание должно сильно упростить "клиентский" код в таком юзкейсе. В результате получаем более выразительный код, который становится ближе к декларативному стилю.  

Пример решения:

```java
class Expression {
    @Override
    public String toString() {
        return "some expression";
    }
}

class SimpleExpression extends Expression {
    @Override
    public String toString() {
        return "some simple expression";
    }
}

class ComplexExpression extends SimpleExpression {
    @Override
    public String toString() {
        return "some complex expression";
    }
}

...

Expression expression = new ComplexExpression();
System.out.println(expression); // "some complex expression"
```