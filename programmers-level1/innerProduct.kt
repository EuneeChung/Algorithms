fun main() {
 print(solution(intArrayOf(1,2,3,4), intArrayOf(-3,-1,0,2)))
}
fun solution(a: IntArray, b: IntArray): Int {
    var innerProduct=0

    for(i in a.indices){
        innerProduct+=a[i]*b[i]
    }
    return innerProduct
}
fun solution2(a: IntArray, b: IntArray): Int {
    return a.zip(b).map { it.first * it.second }.sum()
    // zip 함수는 두 컬렉션의 자료들을 조합하여 새로운 자료를 만들 떄 사용
    // 두 컬렉션 간 자료의 갯수가 달라도 되고 더 적은 갯수에 컬렉션 쪽으로 따라 감.
    // 조함된 결과는 Pair로 만들어주며, 원할 경우 규칙을 정의할 수 있음.
}