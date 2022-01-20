import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Java_21608 {
    static int N;
    static int[][] studentMap;
    static int[][] seatMap;
    static HashMap<Integer,ArrayList<Integer>> likedStudentInfo;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        studentMap = new int[N][N];
        seatMap = new int[N][N];
        likedStudentInfo = new HashMap<>();
        int[] orders=new int[N*N];
        StringTokenizer st;
        for (int i = 0; i < N*N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            ArrayList<Integer> likeA = new ArrayList<>();
            for (int j = 0; j < 4; j++) {
                likeA.add(Integer.parseInt(st.nextToken()));
            }
            likedStudentInfo.put(a,likeA);
            orders[i]=a;
        }
        initSeatMap();

        boolean isFirst = true;
        for (Integer a: orders) {
            if(isFirst) {
                seatStudent(1,1,a);
                isFirst=false;
            }
            else{
                findStudentSeat(a);
            }
        }
        int score =0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int cnt = countLikedStudent(i,j,studentMap[i][j]);
                if(cnt>0) score+=Math.pow(10,countLikedStudent(i,j,studentMap[i][j])-1);
            }
        }
        System.out.println(score);
    }
    static void initSeatMap(){
        for (int i = 0; i <N ; i++) {
            if(i==0||i==N-1) Arrays.fill(seatMap[i],3);
            else Arrays.fill(seatMap[i],4);
            seatMap[i][0]--;
            seatMap[i][N-1]--;
        }
    }
    static void seatStudent(int x, int y,int studentNum){
        studentMap[x][y]=studentNum;
        for (int i = 0; i < 4; i++) {
            int tx =x+dx[i];
            int ty =y+dy[i];
            if(isValidate(tx,ty)) seatMap[tx][ty]--;
        }

    }
    static boolean isValidate(int x, int y){
        return x>=0&&x<N&&y>=0&&y<N;
    }
    static void findStudentSeat(int studentNum){
        PriorityQueue<PossibleSeat> pq = new PriorityQueue<>();
        for (int i = 0; i <N ; i++) {
            for (int j = 0; j <N ; j++) {
                if(studentMap[i][j]!=0) continue; // 이미 자리 배치 받은 경우
                int likedPInAdj =countLikedStudent(i,j,studentNum);
                pq.add(new PossibleSeat(i,j,likedPInAdj,seatMap[i][j]));
            }
        }
        PossibleSeat seat =pq.poll();
        seatStudent(seat.x,seat.y,studentNum);
    }
    static int countLikedStudent(int i, int j, int studentNum){
        int likedSInAdj =0;
        for (int d = 0; d < 4; d++) {
            int tx =i+dx[d];
            int ty =j+dy[d];
            if(isValidate(tx,ty)) {
                int adjStu = studentMap[tx][ty];
                if(likedStudentInfo.get(studentNum).contains(adjStu)) likedSInAdj++;
            }
        }
        return likedSInAdj;
    }
    static class PossibleSeat implements Comparable<PossibleSeat>{
        int x,y,likedP, remainSeat;
        public PossibleSeat(int x, int y, int likedP, int remainSeat){
            this.x=x;
            this.y=y;
            this.likedP=likedP;
            this.remainSeat=remainSeat;
        }

        @Override
        public int compareTo(PossibleSeat o) {
            if(this.likedP==o.likedP){
                if(this.remainSeat==o.remainSeat) {
                    if(this.x==o.x) return this.y-o.y;
                        return this.x-o.x;
                }
                else return o.remainSeat-this.remainSeat;
            }
            else return o.likedP-this.likedP;
        }
    }
}
