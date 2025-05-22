fun mdc(a: Int, b: Int): Int {
    return if (b == 0) a else mdc(b, a % b)
}

fun main() {
    val x = 90
    val y = 60
    println("MDC de $x e $y é: ${mdc(x, y)}")
}
