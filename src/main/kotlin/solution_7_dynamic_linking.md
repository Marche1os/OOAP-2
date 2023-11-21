```kotlin
interface Navigator {
    fun navigateTo(screen: Screen)
}

class ActivityNavigator : Navigator {
    override fun navigateTo(screen: Screen) {
        TODO("Переход на экран Activity")
    }
}

class ComposeNavigator : Navigator {
    override fun navigateTo(screen: Screen) {
        TODO("Переход в навигации Compose")
    }
}

class FragmentNavigator : Navigator {
    override fun navigateTo(screen: Screen) {
        TODO("Навигация на другой фрагмент")
    }
}

class NavigationProcessor {
    private lateinit var navigator: Navigator

    fun attachNavigator(navigator: Navigator) {
        this.navigator = navigator
    }
    
    fun applyNavigationCommand(command: NavigationCommand) {
        // Здесь осуществляется динамическое связывание функции navigateTo.
        // В зависимости от типа [Navigator] будет вызван метод соответствующего типа 
        // Клиентский код о конкретном типе ничего не знает
        navigator.navigateTo(command.to)
    }

    //...
}

enum class Screen(name: String) {
    PROFILE("profile"),
    SETTINGS("settings"),
    FEED("feed")
}

data class NavigationCommand(
    val from: Screen,
    val to: Screen,
    val args: List<Any>,
)
```