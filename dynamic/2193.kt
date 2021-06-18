fun main(){
    val n = readLine()!!.toInt()
    val pn=LongArray(91)
    pn[1]=1
    pn[2]=1
    for(i in 3..n){
        pn[i]=pn[i-1]+pn[i-2]
    }
    print(pn[n])
}

/*2차원 배열로 풀기
fun main(){
    val n = readLine()!!.toInt()
    val dp=Array(91){LongArray(2){0} }
    var count:Long=0

    dp[1][0]=0
    dp[1][1]=1
    dp[2][0]=1
    dp[2][1]=0
    for(i in 3..n){
        dp[i][0]=dp[i-1][0]+dp[i-1][1]
        dp[i][1]=dp[i-1][0]

    }
    count=dp[n][0]+dp[n][1]
    print(count)
}
*/
