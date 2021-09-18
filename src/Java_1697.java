package src;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Java_1697 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print(bfs(sc.nextInt(),sc.nextInt()));
    }
//1. queue에 초기값 수빈이의 위치를 추가
//2. queue가 empty 일떄까지 반복
//    2-1. 만약 동생의 위치를 queue 가 가지고 있다면 `return count`
//    2-2. queue 의 사이즈 만큼 ( 그전의 있었던 좌표들)
//          `X = queue.poll;`
//           queue 에 `X-1` 또는 `X+1` 또는  `2*X` 값을 추가 !
//           ⇒ 방문 체크 하지 않았고, tmp 가 움직일 수있는 범위 안에 있을떄 값을 추가
//    2-3. 한 턴이 돌았으니까 time  에 대해서 ++ 해줌. → `count` 변수
    private static int bfs(int start, int end) {
        int count =0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start); //1. queue에 초기값 수빈이의 위치를 추가
        boolean[] visited = new boolean[100003];

        while (!queue.isEmpty()){ //2. queue가 empty 일떄까지 반복
            int size = queue.size();
            if(queue.contains(end)) return count; //  2-1. 만약 동생의 위치를 queue 가 가지고 있다면 `return count`
            for (int i = 0; i < size; i++) {
                int previous = queue.poll();
                int tmp=previous-1;
                for (int j = 0; j < 3; j++) {
                    //    2-2. queue 의 사이즈 만큼 ( 그전의 있었던 좌표들)
                    //          `X = queue.poll;`
                    //           queue 에 `X-1` 또는 `X+1` 또는  `2*X` 값을 추가 !
                    //           ⇒ 방문 체크 하지 않았고, tmp 가 움직일 수있는 범위 안에 있을떄 값을 추가
                    if(j ==0) tmp =previous-1;
                    else if(j==1) tmp=previous+1;
                    else tmp  = previous*2;
                    if(tmp>=0 &&tmp < 100003 && !visited[tmp]) {
                        queue.add(tmp);
                        visited[tmp]=true;
                    }
                }

            }
            count++; // 2-3. 한 턴이 돌았으니까 time  에 대해서 ++ 해줌. → `count` 변수
        }

        return count;
    }
}