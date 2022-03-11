class Solution_N2배열자르기 {
    public int[] solution(int n, long left, long right) {
        int size = (int)(right-left)+1;
        int[] answer = new int[size];
        
        for(long i = left; i<=right;i++){
            int x = (int) (i/n) +1;
            int y = (int) (i%n) +1;
            answer[(int)(i-left)]= Math.max(x,y);
        }
        
        return answer;
    }
}