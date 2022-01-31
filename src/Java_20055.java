import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Java_20055 {
    static int[] belt;
    static boolean[] conveyor;
    static int length;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        length = 2*Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        belt = new int[length];
        conveyor=new boolean[length];
        for (int i = 0; i <length ; i++) {
            belt[i]=Integer.parseInt(st.nextToken());
        }
        int cnt=0;
        while(true){
            cnt++;
            rotate();
            moveConveyor();
            putUpConveyor();
            if(K<=check()) break;
        }
        System.out.println(cnt);
    }
    static void rotate(){
        int last = belt[length-1];
        boolean isLastConveyor = conveyor[length-1];
        for (int i = length-2; i >=0 ; i--) {
            belt[i+1]= belt[i];
            conveyor[i+1]=conveyor[i];
            if(i+1==length/2-1) conveyor[i+1]=false;
        }
        belt[0]=last;
        conveyor[0]=isLastConveyor;
    }
    static void moveConveyor(){
        boolean isLastConveyor = conveyor[length-1];
        conveyor[length-1]=false;
        for (int i = length-2; i >=0 ; i--) {
            if(conveyor[i]&&!conveyor[i+1]&&belt[i+1]>=1){
                belt[i+1]--;
                conveyor[i]=false;
                conveyor[i+1]=true;
                if(i+1==length/2-1) conveyor[i+1]=false;
            }
        }
        if(isLastConveyor&&belt[0]>=1){
            belt[0]--;
            conveyor[0]=isLastConveyor;
        }
    }
    static void putUpConveyor(){
        if(belt[0]>=1 && !conveyor[0]){
            belt[0]--;
            conveyor[0]=true;
        }
    }
    static int check(){
        int cnt=0;
        for (int i = 0; i <length ; i++) {
            if(belt[i]==0)cnt++;
        }
        return cnt;
    }
}
