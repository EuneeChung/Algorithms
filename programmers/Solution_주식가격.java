package programmers;

public class Solution_주식가격 {
    public int[] solution(int[] prices) {
        int length = prices.length;
        int[] answer = new int[length];

        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                answer[i]++;
                if (prices[i] > prices[j]) break;
            }
        }
        return answer;
    }
}
