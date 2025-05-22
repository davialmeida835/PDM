// ---------- Estrutura base ----------
sealed interface Tree<out T>

data class Node<out T>(
    val value: T,
    val left: Tree<T> = End,
    val right: Tree<T> = End
) : Tree<T> {
    override fun toString(): String {
        val children = if (left == End && right == End) "" else " $left $right"
        return "T($value$children)"
    }
}

object End : Tree<Nothing> {
    override fun toString() = "."
}

//9)
fun <T : Comparable<T>> Tree<T>.insert(newValue: T): Tree<T> = when (this) {
    End   -> Node(newValue)
    is Node -> when {
        newValue < value -> Node(value, left.insert(newValue), right)
        newValue > value -> Node(value, left, right.insert(newValue))
        else             -> this
    }
}

//10)
fun <T> Tree<T>.leafCount(): Int = when (this) {
    End   -> 0
    is Node -> if (left == End && right == End) 1
    else left.leafCount() + right.leafCount()
}

//11
fun <T> Tree<T>.leafValues(): List<T> = when (this) {
    End   -> emptyList()
    is Node -> if (left == End && right == End) listOf(value)
    else left.leafValues() + right.leafValues()
}

//12)
fun <T> Tree<T>.convertToString(): String = when (this) {
    End   -> ""
    is Node -> {
        val l = left.convertToString()
        val r = right.convertToString()
        if (left == End && right == End) value.toString()
        else "${value}(${l},${r})"
    }
}

//13)
fun String.convertToTree(): Tree<String> {
    if (isBlank()) return End

    var pos = 0
    fun parse(): Tree<String> {
        if (pos >= length || this[pos] == ',' || this[pos] == ')') return End

        // valor do nó
        val start = pos
        while (pos < length && this[pos] !in listOf('(', ',', ')')) pos++
        val value = substring(start, pos)

        // folha
        if (pos >= length || this[pos] != '(') return Node(value)

        pos++
        val left  = parse()
        if (pos < length && this[pos] == ',') pos++
        val right = parse()
        if (pos < length && this[pos] == ')') pos++

        return Node(value, left, right)
    }
    return parse()
}


fun main() {
    // Questão 9
    val bst = End.insert(5).insert(3).insert(7).insert(4)
    println(bst)

    // Questões 10 e 11
    println(bst.leafCount())
    println(bst.leafValues())

    // Questões 12 e 13
    val demo = Node(
        "a",
        Node("b", Node("d"), Node("e")),
        Node("c", End, Node("f", Node("g"), End))
    )
    val serial = demo.convertToString()
    println(serial)
    println(serial.convertToTree())
}
