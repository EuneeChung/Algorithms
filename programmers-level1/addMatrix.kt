fun solution(arr1: Array<IntArray>, arr2: Array<IntArray>): Array<IntArray> {
    var answer = arrayOf<IntArray>()
    for((index,value) in arr1.withIndex()){
        var arrSum= intArrayOf()
        for((i,v)in value.withIndex()){
            arrSum+=(v+arr2[index][i])
        }
        answer+=arrSum
    }
    return answer
}