fun main(){
    val n = readLine()!!.toInt()
    val dp=Array(1001){Array(10){0}}
    var count =0
    val mod = 10007
    //길이가 1인 수는 모두 오르막 수
    for (i in 0..9){
        dp[1][i]=1
    }
    //길이가 2 이상인 수
    for(i in 2..n)
        for (j in 0..9)
            //j부터 9까지 숫자가 뒤에 올수 있다.
            for (a in j..9){
                dp[i][j]+=dp[i-1][a]
                dp[i][j]%=mod
            }

    for (b in dp[n]) {
        count += b
        count%=mod
    }
    print(count)


}