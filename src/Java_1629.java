import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Java_1629 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());


        System.out.println(pow(A,B,C));
    }
    static long pow(int a, int b,int c){
        if(b==1) return a%c;
        long answer =pow(a,b/2,c)%c;
        answer=answer*answer%c;
        if(b%2==0) return answer;
        return answer*a%c;
    }
}
