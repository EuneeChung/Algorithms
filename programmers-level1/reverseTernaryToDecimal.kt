import kotlin.math.pow
fun main(){
    print(solution(125))
}
fun solution(n: Int): Int {
    val ternary =3.0
    var quotient = n
    var remainder = intArrayOf()
    var sum=0.0

    while(true){
        if(quotient<3) {
            remainder+=quotient
            break
        }
        remainder+=quotient%3
        quotient /= 3

    }
    remainder.reverse()
    print(remainder.contentToString())
    for((index,value) in remainder.withIndex()){
        sum+=value*ternary.pow(index)
    }

    return sum.toInt()
}
fun solution2(n: Int): Int {
    return n.toString(3).reversed().toInt(3)
}