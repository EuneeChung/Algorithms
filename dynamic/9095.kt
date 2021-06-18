val addDp= IntArray(12)
fun main(){
    val t=readLine()!!.toInt()
    var n:Int
    addDp[0]=1
    addDp[1]=1
    addDp[2]=2
    addDp[3]=4
    add123()
    for(j in 1..t) {
        n= readLine()!!.toInt()
        println(addDp[n])
    }
}
fun add123(){

    addDp[0]=1
    addDp[1]=1
    addDp[2]=2
    addDp[3]=4
    for (i in 4..11) {
        addDp[i] = addDp[i - 1]+addDp[i-2]+addDp[i-3]
    }
}

