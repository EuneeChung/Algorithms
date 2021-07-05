import kotlin.math.floor
fun main(){
    print(solution1("acegd"))
}
fun solution1(s: String): String {
    return s.slice((s.length-1)/2..(s.length/2))
}
fun solution2(s: String): String {
    return if(s.length%2==1){
        s[floor((s.length/2).toDouble()).toInt()].toString()
    }
    else {
        s[(s.length/2-1)].toString()+s[(s.length/2)].toString()
    }
}