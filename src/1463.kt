import kotlin.math.min

var dp= IntArray(1000001)

fun main(){
    var a = readLine()!!.toInt()
    dp[1]=0
    for(i in 2..a){
        dp[i]=dp[i-1]+1
        if(i%2==0) dp[i]=min(dp[i],dp[i/2]+1)
        if(i%3==0) dp[i]=min(dp[i],dp[i/3]+1)
    }
    println(dp[a])
}
