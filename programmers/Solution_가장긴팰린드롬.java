package programmers;

public class Solution_가장긴팰린드롬 {
    public int solution(String s)
    {
        int max = 1;
        for(int c=0; c<s.length()-1;c++){
            if(s.charAt(c)==s.charAt(c+1)) max = Math.max(check(c,c+1, s),max);
            if(c>0 &&s.charAt(c-1)==s.charAt(c+1)) max = Math.max(check(c-1,c+1, s),max);
        }
        return max;
    }

    public int check(int i,int j, String s){
        int p=j-i-1;

        while(true){
            if(i<0 || j>= s.length()) break;
            if(s.charAt(i)==s.charAt(j)){
                p+=2;
                i--;
                j++;
            } else break;
        }
        return p;
    }
}
