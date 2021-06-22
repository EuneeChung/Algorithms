fun main(args: Array<String>) {
    val (n, m) = readLine()!!.split(' ').map(String::toInt)
    for (b in 1..m) {
        for (a in 1..n) {
            print("*")
        }
        println()
    }
}