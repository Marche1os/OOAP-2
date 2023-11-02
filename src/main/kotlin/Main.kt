import kotlin.concurrent.thread

fun main(args: Array<String>) {
    val ascii = mutableMapOf(
        "A" to 55,
        "B" to 56,
        "C" to 57,
        "D" to 58,
        "F" to 59,
        "G" to 60,
    )

    thread {
        for ((c, n) in ascii.entries) {
            println(c to n)
            Thread.sleep(500)
        }
    }

    thread {
        Thread.sleep(1000)

        ascii.entries.remove(ascii.entries.last())
    }
}