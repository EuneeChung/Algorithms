fun main(){
  print(solution("01033334444"))
}
fun solution(phone_number: String): String {
    val length=phone_number.length
    return "*".repeat(length-4)+phone_number.filterIndexed { index, c ->
        index in length-4 until length
    }
}