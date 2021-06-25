fun main(){
    print(solution(arrayOf("Jane", "Kim")))
}
fun solution(seoul: Array<String>): String {
    var answer = "김서방은 "

    for((index,value) in seoul.withIndex()){
        if(value=="Kim") answer+=index
    }
    answer+="에 있다"
    return answer
}