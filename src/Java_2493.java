package src;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Java_2493 {
    static int currentHeight;
    static class Tower{
        int idx,height;
        public Tower(int i, int h){
            this.idx=i;
            this.height=h;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int TOP_LENGTH = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());


        Stack<Tower> stack = new Stack<Tower>();
        int[] receive = new int[TOP_LENGTH + 1];

        for (int i = 1; i <= TOP_LENGTH; i++) {
            currentHeight =Integer.parseInt(st.nextToken());
            while (!stack.isEmpty()){
                if(stack.peek().height<currentHeight) stack.pop();
                else {
                    receive[i]=stack.peek().idx;
                    break;
                }
            }
            if(stack.isEmpty()) receive[i]=0;
            stack.push(new Tower(i,currentHeight));

        }

        receive[0] = 0;
        for (int i = 1; i <= TOP_LENGTH; i++) {
           bw.append(String.valueOf(receive[i])).append(" ");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
