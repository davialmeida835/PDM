fun isPalindrome(lista : List<Any>): Boolean{

    val n= lista.size
    if(n%2==0){
        for (i in 1..n-1){
            if(lista[i]!==lista[lista.size -i -1]){
                return false
            }
        }
    }
    return true
}

fun main() {
    val lista: List<Any> = listOf(1,9,8,8,9,1)
    println(isPalindrome(lista))
}
