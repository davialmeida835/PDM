fun isPrime(numero : Int): Boolean{
    var cont=0
    for(i in 1..numero){
        if(numero%i==0){
            cont++
        }
    }
    if(cont==2){
        return true
    }
    return false
}

fun main() {
    val n = 17
    println("Número: $n")
    println("É primo? ${isPrime(n)}")
}

