fun encode(lista : List<Any>): List<Any>{

    val listaA= mutableListOf<Any>()
    var cont=0
    while(cont<lista.size){
        var pon=1
        for(i in cont+1 until lista.size){
            if(lista[i]==lista[cont]){
                pon++
            }else{
                break}

        }

        listaA.add(pon)
        listaA.add(lista[cont])
        cont+=pon

    }
    return listaA
}

fun main() {
    val lista: List<Any> = listOf("a","a","b","b","c","d");
    println(encode(lista))
}
