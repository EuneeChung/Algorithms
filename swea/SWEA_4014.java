package swea;

import java.io.*;
import java.util.StringTokenizer;

public class SWEA_4014 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int cnt; // 활주로를 건설하는 방법의 가지수
        int[][] map;
        int N,X; // 지도 한변의 크기 N, 경사로의 길이 X
        int height, hNum; //연속되고 있는 활주로의 높이, 개수
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <=T ; t++) {
            cnt=0; //초기화

            st=new StringTokenizer(br.readLine());
            N=Integer.parseInt(st.nextToken());
            X=Integer.parseInt(st.nextToken());
            map=new int[N][N];

            // map 입력 받기
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j <N ; j++) {
                    map[i][j]=Integer.parseInt(st.nextToken());
                }
            }

            // 가로로 활주로 세울수 있는지 검사
            outer: for (int i = 0; i <N ; i++) {
                height=map[i][0];
                hNum = 1;

                int j=1;
                while (j<N){
                    if(height==map[i][j]){
                        hNum++;
                        j++;
//                        if(hNum==X) isClimbing=false;
//                        if(isClimbing && j==N&& hNum<X)continue outer;
                    }
                    else if(map[i][j]-height==1&&hNum>=X){ // 오르막길
                        hNum=1;
                        height=map[i][j];
                    }
                    else if(height-map[i][j]==1){ //내리막길
                        height=map[i][j];
                        hNum=0;
                        for (int k = j+1; k < j+X ; k++) {
                            if(k>=N) continue outer;
                            if(height!=map[i][k]) continue outer;
                        }
                        j+=X;
                    }
                    else continue outer;
                }
                cnt++;
            }

            // 세로로 활주로 세울수 있는지 검사
            outer: for (int j = 0; j <N ; j++) {
                height=map[0][j];
                hNum = 1;
                int i=1;
                while (i<N){

                    if(height==map[i][j]){
                        hNum++;
                        i++;
//                        if(hNum==X) isClimbing=false;
//                        if(isClimbing && i==N&& hNum<X)continue outer;
                    }
                    else if(map[i][j]-height==1&&hNum>=X){ // 오르막길
                        hNum=1;
                        height=map[i][j];
                        i++;
                    }
                    else if(height-map[i][j]==1){ //내리막길
                        height=map[i][j];
                        hNum=0;
                        for (int k = i+1; k < i+X ; k++) {
                            if(k>=N) continue outer;
                            if(height!=map[k][j]) continue outer;
                        }
                        i+=X;
                    }
                    else continue outer; // 높이가 1이상 차이가 날 경우
                }

                cnt++;
            }

            bw.write("#"+t+" "+cnt);
            if(t!=T) bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
