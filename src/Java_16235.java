package src;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Java_16235 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        PriorityQueue<Tree> pq = new PriorityQueue<>();
        ArrayList<Tree> treeList = new ArrayList<>();
        int[] dx={-1,-1,-1,0,0,1,1,1};
        int[] dy={-1,0,1,-1,1,-1,0,1};
        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();

        int[][] plus = new int[N][N];
        int[][] ground = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <N; j++) {
                plus[i][j] = sc.nextInt();
                ground[i][j]=5;
            }
        }
        for (int i = 0; i <M ; i++) {
            pq.add(new Tree(sc.nextInt()-1, sc.nextInt()-1, sc.nextInt()));
        } // 입력 끝

        for (int k = 0; k <K; k++) {
            // 봄 여름
            treeList= new ArrayList<>();
            int size = pq.size();
            for (int i = 0; i <size ; i++) {
                Tree tree = pq.poll();
                if(ground[tree.x][tree.y]>= tree.age){
                    ground[tree.x][tree.y]-=tree.age;
                    tree.age++;
                }
                else{
                    tree.isAlive=false;
                }
                treeList.add(tree);
            }

            size = treeList.size();
            for (int i = 0; i <size ; i++) {
                Tree tree = treeList.get(i);
                if(!tree.isAlive){
                    ground[tree.x][tree.y]+= tree.age/2;
                }
                else{
                    if(tree.age%5==0){
                        for (int d = 0; d < 8; d++) {
                            int tx = tree.x+dx[d];
                            int ty = tree.y+dy[d];
                            if(tx<0||tx>=N||ty<0||ty>=N) continue;
                            pq.add(new Tree(tx,ty, 1));
                        }
                    }
                }

            }
            for (Tree a :treeList) {
                if(a.isAlive) pq.add(a);
            }
            // 겨울
            for (int i = 0; i <N ; i++) {
                for (int j = 0; j < N; j++) {
                    ground[i][j]+=plus[i][j];
                }
            }
        }
        // K 년이 지난 후 , 살아 남은 나무의 수 출력
        System.out.print(pq.size());
    }

    static class Tree implements Comparable<Tree>{
        int x;
        int y;
        int age;
        boolean isAlive=true;
        public Tree(int x, int y, int age){
            this.x=x;
            this.y=y;
            this.age=age;
        }


        @Override
        public int compareTo(Tree o) {
            return this.age-o.age;
        }
    }
}
