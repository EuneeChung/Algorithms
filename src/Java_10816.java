import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Java_10816 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N  = Integer.parseInt(br.readLine());
        Map<Integer, Integer> cardMap = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i <N ; i++) {
           int card = Integer.parseInt(st.nextToken());
            if(cardMap.containsKey(card)) cardMap.put(card,cardMap.get(card)+1);
            else cardMap.put(card,1);
        }

        int M  = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i <M ; i++) {
            int card = Integer.parseInt(st.nextToken());
            if(cardMap.containsKey(card)) sb.append(cardMap.get(card)).append(" ");
            else sb.append("0 ");
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb);
    }
}
