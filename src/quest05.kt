fun decode(lista : List<Any>): List<Any>{

    val listaA= mutableListOf<Any>()
    var cont=1
    while(cont<lista.size){

        if (cont % 2 != 0) {
            val quantidade = lista[cont - 1] as Int
            for (i in 0 until quantidade) {
                listaA.add(lista[cont])
            }
        }
        cont += 2
    }
    return listaA
}

fun main() {
    val lista: List<Any> = listOf(1,"a",2,"a",3,"b",4,"b",1,"c",2,"d");
    println(decode(lista))
}
