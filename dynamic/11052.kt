import java.lang.Integer.max

fun main(){
    val n= readLine()!!.toInt()

    val pArray= readLine()!!.split(" ")

    maxCardPrice(n,pArray)
}

fun maxCardPrice(n:Int, array : List<String>){
    val pArray=array.toMutableList()
    pArray.add(0,0.toString())

    val dpArray= MutableList<Int>(n+1) {0}

    dpArray[1]=pArray[1].toInt()
    for( i in 1..n){
        for(j in 1..i ) {

            dpArray[i] = max(dpArray[i], (pArray[j].toInt() + dpArray[i-j]))

        }
    }

    println(dpArray[n])

}
