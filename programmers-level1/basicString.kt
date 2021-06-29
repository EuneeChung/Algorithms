fun main(){
    print(solution("a123"))
}
fun solution(s: String): Boolean {
    var answer = true
    if(!(s.length==6||s.length==4)) answer=false
    s.forEach{ it->
        if(!it.isDigit()) answer= false
    }
    return answer
}