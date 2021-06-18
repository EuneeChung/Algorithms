fun main(){
    val array = intArrayOf(1, 5, 2, 6, 3, 7, 4)
    val commands = arrayOf(intArrayOf(2, 5, 3), intArrayOf(4,4,1), intArrayOf(1,7,3))
    solution(array,commands)
}
fun solution(array: IntArray, commands: Array<IntArray>): IntArray {
    var answer = intArrayOf()

    commands.forEach {
        answer += array.slice(it[0] - 1 until it[1]).sorted()[it[2] - 1]
    }

    print(answer.contentToString())

    return answer
}