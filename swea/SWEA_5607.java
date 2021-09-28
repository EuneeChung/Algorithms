package swea;

import java.util.Scanner;

public class SWEA_5607 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        long[] factorial = new long[1000001];
        factorial[0] = 1;
        for(int i = 1; i <= 1000000; i++){
            factorial[i] = (i * factorial[i-1]) % 1234567891;
        }
        int T= sc.nextInt();
        for (int t = 1; t <= T ; t++) {
            int N = sc.nextInt();
            int R = sc.nextInt();

            sb.append("#").append(t).append(" ")
                    .append(factorial[N]*pow((factorial[R]*factorial[N-R])%1234567891, 1234567891-2)%1234567891)
                    .append("\n");
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.print(sb);
    }
    static Long pow(long a, long b){
        long an = 1l;
        if(b==0||a==b) return an;
        an = pow(a,b/2);
        long next = (an*an)%1234567891;
        if(b%2==0) return next;
        else return (next*a)%1234567891;
    }
}
