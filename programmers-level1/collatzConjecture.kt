fun main() {
    print(solution(626331))
}

fun solution(num: Int): Int {
    var n =num.toDouble()
    var count = 0
    while (n != 1.0) {
        if (n % 2 == 0.0) n /= 2
        else n = n * 3 + 1
        count++
    }
    return if(n==1.0&&count<500) count
    else -1
}

fun solution2(num: Int): Int = collatz(num.toLong(),0)
tailrec fun collatz(n:Long, c:Int):Int =
    when{
        c > 500 -> -1
        n == 1L -> c
        else -> collatz(if( n%2 == 0L ) n/2 else (n*3)+1, c+1)
    }