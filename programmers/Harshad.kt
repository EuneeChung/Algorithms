fun main(){
    println(solution(11))
}

fun solution(x: Int): Boolean {
    var sum= 0
    x.toString().forEach {sum+= (it-'0')}
    return x%sum==0
}
