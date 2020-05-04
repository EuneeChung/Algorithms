fun main(){
    val line= readLine()!!
    print(encryption(line))
}
fun encryption(a:String):String{
    var encString=""
    for(i in a){
        val ascii=i.toInt()
        encString += when {
            i.isLowerCase() -> {
                if(ascii<110) (ascii+13).toChar()
                else (ascii-13).toChar()
            }
            i.isUpperCase() -> {
                if(ascii<78) (ascii+13).toChar()
                else (ascii-13).toChar()
            }
            else -> i
        }
    }
    return encString
}