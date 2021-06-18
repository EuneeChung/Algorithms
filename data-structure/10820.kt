fun main(){
    var a= readLine()
    while(a!=null){
        var upperCount=0
        var lowerCount=0
        var intCount=0
        var spaceCount=0
        for(i in a){
            when {
                i.isDigit() -> intCount++
                i.isLowerCase() -> lowerCount++
                i.isUpperCase() -> upperCount++
                i==' ' -> spaceCount++
            }

        }
        println("$lowerCount $upperCount $intCount $spaceCount")
        a= readLine()
    }
}