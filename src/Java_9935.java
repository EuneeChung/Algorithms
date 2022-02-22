import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Java_9935 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        String text=br.readLine();
        String bomb=br.readLine();
        int bombLength=bomb.length();
        for (int i = 0; i <text.length() ; i++) {
            sb.append(text.charAt(i));
            if(sb.length()>= bombLength){
                if(sb.substring(sb.length()-bombLength,sb.length()).equals(bomb)){
                    sb.delete(sb.length()-bombLength,sb.length());
                }
            }
        }
        System.out.println(sb.length()==0?"FRULA":sb);
    }
}
