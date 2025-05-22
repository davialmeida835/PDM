fun listPrimesInRange(numero : Int, numero2 : Int): List<Int>{

    val lista = mutableListOf<Int>()

    for( i in numero..numero2){
        var cont=0
        for(j in 1..i){
            if(i%j==0){
                cont++
            }
        }
        if(cont==2){
            lista.add(i)
        }

    }
    return lista

}

fun main() {
    val n = 17
    val n2 = 90

    println("Numeroe primos ${listPrimesInRange(n,n2)}")
}
