**Наследование вариаций**

```kotlin
class ScreenFragment : Fragment() {
    open fun back() {
        // переход на предыдущий экран типа Fragment
    }
}

// Флоу авторизации, внутри содержатся подэкраны (вход по номеру телефона, email, проверка кода...) 
// который инкапсулированы в единый экран-флоу авторизации
class AuthorizationFlowScreenFragment : ScreenFragment() {
    override fun back() {
        // переопределенная логика, вызов метода родительского класса не вызывается. 
        // Здесь содержится логика проверки на каком шаге авторизации мы находимся. 
    // На первом шаге - закрываем приложение, иначе - переход на предыдущих шаг
    }
}

```

**Наследование с конкретизацией**

```kotlin
// игровой монстр: Трупоед
open abstract class Necrophage {
    fun damage() {
        // нанесение урона
    }

    fun accumulateHealth() {
        // восстановление здоровья
    }

    open fun specialDamage()

    open fun takingDamage(type: DamageType)
}

enum class DamageType {
    PHYSICAL,
    FIRE,
    POISONING
}

// конкретный класс монстров: Кладбищенская баба
class GraveHag : Necrophage() {
    override fun specialDamage() {
        // Расчет вероятности нанесения дополнительного ядовитого удара
    }

    override fun takingDamage(type: DamageType) {
        // Получение урона, если урон - не физический и не отравляющий, 
        // так как у кладбищенской бабы иммунитет к этим видам урона
    }
}
```

**Структурное наследование**

```kotlin
// игровой монстр: Зверь
open abstract class Beast {
    open fun damage() {
        // нанесение урона
    }

    // остальное поведение...
}

// Интерфейс, добавляющий монстру свойство "Атака стаей"
interface CombinableAttacker {
    fun packAttack()
}

class Wilk : Beast(), CombinableAttacker {
    open override fun damage() {
        super.damage()
        // Рассчет вероятности нанесения комбинированного удара с учетом количества оставшихся в группе монстров
        // Теперь каждое нанесение урона требует расчета возможности группового удара
    }

    override fun packAttack() {
        // нанесение комбинированного удара
    }
}

```
