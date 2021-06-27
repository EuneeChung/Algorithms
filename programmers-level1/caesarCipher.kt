fun main() {
    print(solution("bC",25 ))
}

fun solution(s: String, n: Int): String {
    var answer = ""
    val codelowerZ = 'z'.toInt()
    val codeUpperZ = 'Z'.toInt()
    s.forEach {
        if (it == ' ') answer += it
        else {
            var char = it.toInt() + n
            if (it.isLowerCase()) if (codelowerZ < char) char -= 26
            if (it.isUpperCase()) if (codeUpperZ < char) char -= 26
            answer += char.toChar()
        }
    }
    return answer
}