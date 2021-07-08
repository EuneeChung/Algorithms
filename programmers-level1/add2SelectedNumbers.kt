fun main(){
    print(solution(intArrayOf(5,0,2,7)).contentToString())
}
fun solution(numbers: IntArray): IntArray {
    var answer: IntArray = intArrayOf()
    for((index,value) in numbers.withIndex()){
        for(i in index+1..numbers.lastIndex){
            val sum=value+numbers[i]
            if(!answer.contains(sum)) answer+=sum
        }

    }
    return answer.sortedArray()
}