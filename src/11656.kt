fun main(){
    val line= readLine()
    val suffixArray= Array<String>(line!!.length){""}
    val lineIndices=line.indices
    for(i in lineIndices){
        suffixArray[i]=line.removeRange(0 until i)

    }
    suffixArray.sort()
    for(i in lineIndices){
        println(suffixArray[i])
    }

}