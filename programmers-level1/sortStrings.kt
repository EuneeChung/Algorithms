fun main(){
    val strings= arrayOf("cdx","abce","abcd")
    print(solution(strings,1).contentToString())
}
fun solution(strings: Array<String>, n: Int): Array<String> {
    return strings.sortedArray().sortedBy {it[n]}.toTypedArray()
}