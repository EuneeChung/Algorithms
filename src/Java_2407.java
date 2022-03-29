import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Java_2407 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        BigInteger n = BigInteger.ONE;
        BigInteger m = BigInteger.ONE;

        for (int i = M; i >=1 ; i--) {
            n=n.multiply(new BigInteger(String.valueOf(N--)));
            m=m.multiply(new BigInteger(String.valueOf(i)));
        }
        System.out.println(n.divide(m));
    }
}
