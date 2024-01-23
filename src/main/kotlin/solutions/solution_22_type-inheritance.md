```kotlin
// "Родительская" сущность - онлайн курс, который характеризуется изучаемым предметом и уровнем сложности через отношение "содержит"
class OnlineCourse(
    val discipline: Discipline,
    val level: Level,
)

// Предмет курса, представлен отдельной иерархией, которую "содержит" онлайн-курс
// Каждый тип может содержать какую-то свою специфику
abstract class Discipline(
    val name: String,
    val theory: Map<String, String> // Страница курса - текстовое описание
)

class Programming : Discipline("Программирование", emptyMap())

class Design : Discipline("Дизайн", emptyMap())

// Сложность курса, представлена отдельной иерархией, которая "содержится" в онлайн-курсе. 
// может содержать свой набор атрибутов 
abstract class Level

class Beginner : Level()
class Middle : Level()
class Hard : Level()
```