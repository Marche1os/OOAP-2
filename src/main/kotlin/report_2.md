Хороший комментарий в примере решения, показывающий,
по какой логике мы определяем специализацию класса-родителя, а по какой - расширение. 
Я в своем решении несколько упустил уточнение в комментариях по поводу специализации и уточнения, поэтому сделаю уточнение здесь. 
Итак: AnimationView - это View, дополненная анимацией. Пример расширения класса-родителя.
StubView - это специализированная View-заглушка. Пример специализации.
Также в примере хорошо показывается отношение, показывающее, что каждый наследник - это класс-родитель, но не наоборот. 

Пример решения:
```java
public class Human{
    // -- voice()
    // -- walk()
    // -- run()
}

public class Worker extends Human{ 
    // специализация класса-родителя, 
    // т.к. рабочий - более частный случай,
    // т.к. все работники - люди, но не все люди - работники
    // -- work()
}

public class Car{
    // -- drive()
    // -- park()
    // -- startEngine()
}

public class AutonomousCar extends Car{ 
    // расширение класса-родителя, 
    // т.к. все самоуправляемые машины
    // являются машинами, но не все машины - самоуправляемы

    // -- autoDrive()
    // -- autoPark()
}
```