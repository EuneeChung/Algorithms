fun main(){
    val arr= intArrayOf(3,2,6)
    val divisor = 10
    print(solution(arr,divisor).contentToString())
}
fun solution(arr: IntArray, divisor: Int): IntArray {
    var answer = intArrayOf()

    arr.forEach {
        if(it%divisor==0) answer+=it
    }
    answer.sort()

    return if(answer.isEmpty()) intArrayOf(-1)
    else answer
}