import java.lang.Integer.max

fun main() {
    val t = readLine()!!.toInt()
    val dpArray = MutableList(2) { MutableList<Int>(1000001) { 0 } }
    for (a in 1..t) {
        val n = readLine()!!.toInt()
        val array = List(2) { List<String>(n) { "" } }.toMutableList()
        array[0] = readLine()!!.split(" ")
        array[1] = readLine()!!.split(" ")

        dpArray[0][1]=array[0][0].toInt()
        dpArray[1][1]=array[1][0].toInt()

        for (b in 2..n) {

            dpArray[1][b] = max(dpArray[0][b-1],dpArray[0][b-2])+array[1][b-1].toInt()
            dpArray[0][b] = max(dpArray[1][b-1],dpArray[1][b-2])+array[0][b-1].toInt()

        }

        println(max(dpArray[0][n],dpArray[1][n]))

    }
}