fun main(){
    val Queue = arrayListOf<Int>()
    val x = readLine()
    var cm:String?
    var head=0
    var tail=-1
    for (i in 1..x!!.toInt()) {
        cm = readLine()
        when (cm) {
            "pop" -> {
                if (tail==-1||head>tail) println(-1)
                else {
                    println(Queue[head])
                    head++
                }
            }
            "size" -> {
                println(tail-head+1)
            }
            "empty" -> {
                if (tail==-1||head>tail) println(1)
                else println(0)
            }
            "front" -> {
                if (tail==-1||head>tail) println(-1)
                else println(Queue[head])
            }
            "back" -> {
                if (tail==-1||head>tail) println(-1)
                else println(Queue[tail])
            }
            else -> {
                val y = cm?.removeRange(0..4)!!.toInt()
                tail++
                Queue.add(tail, y)
            }
        }
    }
}
