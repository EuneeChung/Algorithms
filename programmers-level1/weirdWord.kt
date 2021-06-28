fun main(){
    print(solution("try hello world"))
}

fun solution(s: String): String {
    var sArray = s.split(" ").toMutableList()
    for((index,word) in sArray.withIndex()){
        var transWord=""
        for((index,value) in word.withIndex()){
            transWord += if(index%2==1) value.toLowerCase()
            else value.toUpperCase()
        }
        sArray[index]=transWord
    }


    return sArray.joinToString(separator = " ")
}