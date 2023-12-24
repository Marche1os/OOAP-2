В целом решения соответствуют друг другу, в моем только пример полиморфного использования был на другом классе.

Идея с замыканием иерархии типом None интересная, очень понравился подход. Пока под вопросом практическое применение в Kotlin, так как потребуется изначально объявлять переменнные типа как изменяемый тип, что, на первый взгляд, ослабит безопасность, так как переменные станут изменяемыми, что противоречит подходу, который прививают разработчики языка. 

Пример решения: 
```java
class General implements Serializable {
   ...
}

class Any extends General { }

...

final class None extends Any /*A, B, ....*/ { }

//

class Test {
    public static Any getSome() {
        return new None();
    }

    public static void setSome(Any any) {
        if (any instanceof None) {
            System.out.println("wrong value!!!");
        }
    }
}
```