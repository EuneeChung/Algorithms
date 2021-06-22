
fun main() {
    val a = 5
    val b = 24
    print(solution(a, b))
}
fun solution(a: Int, b: Int): String {

    val days= arrayOf("THU","FRI","SAT","SUN","MON","TUE","WED")
    //금요일로 시작하는 날
    val fridays= arrayOf(1,5,4,1,6,3,1,5,2,0,4,2)

    return days[(7-fridays[a-1]+b%7+1)%7]
}
fun solution2(a: Int, b: Int): String {

    val days= arrayOf("THU","FRI","SAT","SUN","MON","TUE","WED")
    val lastDays= arrayOf(31,29,31,30,31,30,31,31,30,31,30,31)
    val result = (0 until a-1).map { lastDays[it] }.sum()+b

    return days[result%7]
}