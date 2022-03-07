import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Java_2565 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Wire> pq = new PriorityQueue<>();
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st =new StringTokenizer(br.readLine());
            pq.add(new Wire(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }
        ArrayList<Integer> list = new ArrayList<>();
        list.add(pq.poll().b);

        while (!pq.isEmpty()){
            int last = list.get(list.size()-1);
            int currentWireB = pq.poll().b;
            if(last<currentWireB) list.add(currentWireB);
            else{
                int left=0,right= list.size()-1,idx=0;
                while(left<=right){
                    int mid = (left+right)/2;
                    int midWire = list.get(mid);
                    if(midWire<=currentWireB) left=mid+1;
                    else{
                        right=mid-1;
                        idx=mid;
                    }
                }
                list.remove(idx);
                list.add(idx,currentWireB);

            }

        }
        System.out.println(N- list.size());
    }
    static class Wire implements Comparable<Wire>{
        int a,b;
        public Wire(int a, int b){
            this.a=a;
            this.b=b;
        }

        @Override
        public int compareTo(Wire o){
            return this.a-o.a;
        }
    }
}
//6
//        1 8
//        2 9
//        4 4
//        5 2
//        6 1
//        7 5