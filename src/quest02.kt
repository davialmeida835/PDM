fun pultimoElemento(lista : List<Any>): Any{

    val n= lista.size
    if(n==1){
        print("Só tem um elemento= ")
        return lista[0]
    }
    return lista[lista.size - 2]
}

fun main() {
    val lista: List<Any> = listOf(1,9,8,8,7,0)
    println(pultimoElemento(lista))
}

