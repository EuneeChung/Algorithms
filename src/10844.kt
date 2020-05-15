fun main(){
    val n= readLine()!!.toInt()
    val dp= Array(101) { Array<Int>(10) {0} }
    val mod=1000000000
    var count=0

    //자릿수 1일때
    dp[1][0]=0
    for(i in 1..9){
        dp[1][i]=1
    }

    //자릿수가 2일때부터
    for(i in  2..n){
        for(j in 0..9){
            when(j){
                0-> dp[i][j]=dp[i-1][1]%mod
                9-> dp[i][j]=dp[i-1][8]%mod
                else->dp[i][j]=(dp[i-1][j-1]+dp[i-1][j+1])%mod
            }
        }
    }

    for(a in dp[n])
        count=(count+a)%mod


    print(count)

}