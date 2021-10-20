package programmers;

public class Solution_이상한문자만들기 {
    public String solution(String s) {
        StringBuilder st = new StringBuilder();
        int idx=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==' ') {
                idx=0;
                st.append(' ');
                continue;
            }

            if(idx%2==0) st.append(Character.toUpperCase(s.charAt(i)));
            else st.append(Character.toLowerCase(s.charAt(i)));
            idx++;
        }
        return st.toString();
    }
}