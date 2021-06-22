fun main() {
    val array = intArrayOf(1,3,2,4,2)
    print(solution(array).contentToString())
}
fun solution(answers: IntArray): IntArray {
    var answer = intArrayOf()

    val p1 = intArrayOf(1,2,3,4,5)
    val p2 = intArrayOf(2,1,2,3,2,4,2,5)
    val p3 = intArrayOf(3,3,1,1,2,2,4,4,5,5)

    val grade= intArrayOf(0,0,0)
    answers.forEachIndexed { index,value->
        if (value==p1[index%5]) grade[0]++
        if (value==p2[index%8]) grade[1]++
        if (value==p3[index%10]) grade[2]++
    }

//    val max = grade.maxOrNull() ?: 0 프로그래머스에서 런타임 에러발새
    val max = grade.max()
    grade.forEachIndexed { index, value ->
       if( max == value) answer+=(index+1)
    }

    return answer
}