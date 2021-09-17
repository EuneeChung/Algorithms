package src;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Java_1697 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print(bfs(sc.nextInt(),sc.nextInt()));
    }

    private static int bfs(int start, int end) {
        int count =0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        boolean[] visited = new boolean[100003];

        while (!queue.isEmpty()){
            int size = queue.size();
            if(queue.contains(end)) return count;
            for (int i = 0; i < size; i++) {
                int previous = queue.poll();
                int tmp=previous-1;
                for (int j = 0; j < 3; j++) {
                    if(j ==0) tmp =previous-1;
                    else if(j==1) tmp=previous+1;
                    else tmp  = previous*2;
                    if(tmp>=0 &&tmp < 100003 && !visited[tmp]) {
                        queue.add(tmp);
                        visited[tmp]=true;
                    }
                }

            }
            count++;
        }

        return count;
    }
}