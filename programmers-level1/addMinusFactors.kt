fun main(){
    print(solution(24,27))
}
fun solution(left: Int, right: Int): Int {

    var sum=0
    for(i in left..right){
        var cnt=0
        for(a in 1..i){
            if(i%a==0) cnt++
        }
        if(cnt%2==0) sum+=i
        else sum-=i
    }
    return sum
}