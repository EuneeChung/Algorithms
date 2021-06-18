val dpTile2=LongArray(1010)
fun main(){
    val n = readLine()!!.toInt()
    dpTile2[1]=1
    dpTile2[2]=3

    for (i in 3..n){
        dpTile2[i]=(dpTile2[i-1]+2*dpTile2[i-2])%10007
    }

    println(dpTile2[n])
}

