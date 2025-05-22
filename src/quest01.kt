fun ultimoElemento(lista : List<Any>): Any{
    return lista[lista.size - 1]
}

fun main() {
    val lista: List<Any> = listOf(1,2,3,4,5)
    print(ultimoElemento(lista))
}

