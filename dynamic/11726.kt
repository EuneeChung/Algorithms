
val dpTile=LongArray(1010)
fun main(){
    val n = readLine()!!.toInt()
    dpTile[1]=1
    dpTile[2]=2
    for(i in 3..n){
        dpTile[i]=(dpTile[i-1]+dpTile[i-2])%10007
    }
    println(dpTile[n])

}