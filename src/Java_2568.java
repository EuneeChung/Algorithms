import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Java_2568 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        B[] wires = new B[N];
        int[] aWires = new int[N];
        Track[] tracks = new Track[N];
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            aWires[i]=Integer.parseInt(st.nextToken());
            wires[i]= new B(aWires[i],Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(wires);
        Arrays.sort(aWires);
        int[] lis = new int[N];
        int lastIdx=0;
        lis[0]=wires[0].toA;
        tracks[0]=new Track(lastIdx,wires[0].toA);

        for (int i = 1; i <N ; i++) {
            if(lis[lastIdx]<wires[i].toA){
                lis[++lastIdx]=wires[i].toA;
                tracks[i]=new Track(lastIdx,wires[i].toA);
                continue;
            }

            int left=0, right=lastIdx,idx=-1;
            while(left<=right){
                int mid = (left+right)/2;
                if(wires[i].toA>lis[mid]) left=mid+1;
                else{
                    right=mid-1;
                    idx=mid;
                }
            }
            lis[idx]=wires[i].toA;
            tracks[i]=new Track(idx,wires[i].toA);
        }

//        int s = N-lastIdx-1;
        sb.append(N-(lastIdx+1)).append("\n");

        // 진짜 lis 찾기
        for (int i = N-1; i >=0 ; i--) {
            if(tracks[i].idx==lastIdx){
                lis[lastIdx]=tracks[i].num;
                lastIdx--;
            }
        }
//        System.out.println(Arrays.toString(lis));
//        int lisIdx=0;
        lastIdx++;
        for (int i = 0; i <N ; i++) {
            if(aWires[i]==lis[lastIdx]) lastIdx++;
            else sb.append(aWires[i]).append("\n");
        }
        System.out.print(sb);
    }
    static class B implements Comparable<B>{
        int toA,fromB;
        public B(int a, int b){
            this.toA=a;
            this.fromB=b;
        }
        @Override
        public int compareTo(B o) {
            return this.fromB-o.fromB;
        }
    }
    static class Track {
        int idx,num;
        public Track(int a, int b){
            this.idx=a;
            this.num=b;
        }
    }
}
