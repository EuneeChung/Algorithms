package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Java_15961 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int kindOfNum = 0, max;
        int[] choice = new int[D + 1];

        int[] sushi = new int[N];
        for (int i = 0; i < N; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
            if (i < K) {
                if (choice[sushi[i]] == 0) kindOfNum++;
                choice[sushi[i]]++;
            }
        }
        max =choice[C]==0? kindOfNum+1 : kindOfNum;

        for (int i = K; i < N-1+K; i++) {

            int index=i;
            if(i>=N) index = i%N;

            // 선택 취소
            choice[sushi[i - K]]--;
            if (choice[sushi[i - K]] == 0) kindOfNum--;

            // 선택
            if (choice[sushi[index]] == 0) kindOfNum++;
            choice[sushi[index]]++;

            // 쿠폰 확인
            if(max > kindOfNum) continue;
            max = Math.max(max, choice[C]==0? kindOfNum+1 : kindOfNum);

            if(K+1==max) break;
        }
        System.out.print(max);
    }
}
