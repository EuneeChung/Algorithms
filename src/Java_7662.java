import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Java_7662 {
    public static void main(String[] args)  throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());

        int T = Integer.parseInt(br.readLine());
        int N;
        StringTokenizer st;

        for(int t=0;t<T;t++){
            minPQ.clear();
            maxPQ.clear();
            N = Integer.parseInt(br.readLine());

            for(int n=0; n<N;n++){
                st = new StringTokenizer(br.readLine());
                String operation = st.nextToken();
                int num = Integer.parseInt(st.nextToken());
                if(operation.equals("I")){
                    maxPQ.add(num);
                    minPQ.add(num);
                }
                if(operation.equals("D")&& !minPQ.isEmpty()){

                    if(num==-1){
                        Integer min = minPQ.poll();
                        maxPQ.remove(min);

//                        while(minPQ.size()> maxPQ.size()){
//                            maxPQ.add(min);
//                        }
                    }
                    else{
                        Integer max = maxPQ.poll();
                        minPQ.remove(max);

//                        while(minPQ.size()< maxPQ.size()){
//                            minPQ.add(max);
//                        }
                    }


                }
            }
            if(minPQ.isEmpty()) sb.append("EMPTY");
            else sb.append(maxPQ.poll()).append(" ").append(minPQ.poll());
            if(t!=T-1) sb.append("\n");
        }
        System.out.print(sb);
    }
}
