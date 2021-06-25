fun main(){
    val arr= intArrayOf(10)
    print(solution(arr).contentToString())
}
fun solution(arr: IntArray): IntArray{
    var answer = intArrayOf()
    val min = arr.min()

    arr.forEach {
        if(it!=min) answer+=it
    }

    return if(answer.isEmpty()) answer.plus(-1)
    else answer
}