// Класс-родитель
open class View {
    open fun show() {
        println("Отображение view элемента")
    }
}

// Расширение класса-родителя. Добавляем классу-родителю поведение
class AnimationView: View() {

    override fun show() {
        super.show()
        println("Добавление анимации отображения")
    }
}

// Специализация класса-родителя. Специализируем класс-родитель
class StubView : View() {
    override fun show() {
        // не отображаем ничего
    }
}