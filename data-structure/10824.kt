fun main(){
    val line= readLine()
    val array= line!!.split(" ").toMutableList()
    print((array[0]+array[1]).toLong()+(array[2]+array[3]).toLong())
}