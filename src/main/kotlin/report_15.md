Оба решения соответствуют друг другу 1:1. Отмечу, что наследование вместо атрибута класса с предопределенными значениями создает легкомасштабируемый базис и инкапсулирует специфчную конкретному значению логику в конкретный класс. 


**Пример решения:**

```java
public abstract class Developer {
}

// Так делать плохо:
public class Worker extends Developer {
    public int skill; // -1 junior, 0 middle, 1 senior

    public Worker(int skill){
        this.skill = skill;
    }
}


// Лучше делать так:
public class Senior extends Developer {
}

public class Middle extends Developer {
}

public class Junior extends Developer {
}

// Теперь наш код открыт для расширений, но закрыт для изменений, 
// и с точки зрения семантики так куда лучше :)
```