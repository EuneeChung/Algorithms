import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Java_11286 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Abs> pq = new PriorityQueue<>();

        for (int i = 0; i <N ; i++) {
            int x = Integer.parseInt(br.readLine());
            if(x==0) {
                if(pq.isEmpty()) sb.append(0).append("\n");
                else sb.append(pq.poll().num).append("\n");
            }
            else pq.add(new Abs(x));
        }
        System.out.println(sb);
    }
    static class Abs implements Comparable<Abs>{
        int num;
        public Abs(int num){
            this.num = num;
        }
        @Override
        public int compareTo(Abs o){
            int thisAbs = Math.abs(this.num);
            int oAbs = Math.abs(o.num);
            if(thisAbs==oAbs) return this.num - o.num;
            return thisAbs - oAbs;
        }
    }
}
