import kotlin.math.abs

fun main() {
    val array = intArrayOf(7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2)
    val hand = "left"
    print(solution(array, hand))
}

fun solution(numbers: IntArray, hand: String): String {
    var answer = ""

    val x = arrayOf(1, 1, 0)
    val y = arrayOf(3, 2, 1, 0)


    var lPosition = -1
    var rPosition = -1
    numbers.forEach {
        when (it) {
            1, 4, 7 -> {
                answer += "L"
                lPosition = it
            }
            3, 6, 9 -> {
                answer += "R"
                rPosition = it
            }
            2, 5, 8, 0 -> {
                var itPos = it

                if (it == 0) itPos = 11
                if (lPosition == -1) lPosition = 10
                if (rPosition == -1) rPosition = 12

                val ld = x[lPosition % 3] + abs(y[(lPosition - 1) / 3] - y[(itPos - 1) / 3])
                val rd = x[rPosition % 3] + abs(y[(rPosition - 1) / 3] - y[(itPos - 1) / 3])

                if (ld == rd) {
                    if (hand == "right") {
                        answer += "R"
                        rPosition = itPos
                    } else {
                        answer += "L"
                        lPosition = itPos
                    }
                } else if (ld > rd) {
                    answer += "R"
                    rPosition = itPos
                } else {
                    answer += "L"
                    lPosition = itPos
                }

            }
        }
    }

    return answer
}