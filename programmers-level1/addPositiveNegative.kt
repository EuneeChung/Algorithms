fun main(){
    print(solution(intArrayOf(1,2,3), booleanArrayOf(false,false,false)))
}
fun solution(absolutes: IntArray, signs: BooleanArray): Int {
    var sum=0
    for((index,value) in absolutes.withIndex()){
        if(!signs[index]) sum -= value
        if(signs[index]) sum+= value
    }
    return sum
}