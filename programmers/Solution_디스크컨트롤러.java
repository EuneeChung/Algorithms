package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution_디스크컨트롤러 {
    public static void main(String[] args) {
//        6
//        6
//        72
//        3
//        19
//        15
        System.out.println(solution(new int[][]{{0, 3}, {1, 9}, {500, 6}}));
        System.out.println(solution(new int[][]{{0, 5}, {2, 10}, {10000, 2}}));
        System.out.println(solution(new int[][]{{24, 10}, {28, 39}, {43, 20},{37, 5}, {47, 22}, {20, 47},{15, 34}, {15, 2}, {35, 43}, {26, 1}}));
        System.out.println(solution(new int[][]{{0, 3}, {4, 4}, {5, 3}, {4, 1}}));
        System.out.println(solution(new int[][]{{0,20},{3,4},{3,5},{17,2}}));
        System.out.println(solution(new int[][]{{0,10},{4,10},{5,11},{15,2}}));
    }

    public static int solution(int[][] jobs) {
        int answer = 0;
        PriorityQueue<Disk> pq = new PriorityQueue<>();
        ArrayList<Disk> list = new ArrayList<>();

        for (int[] a : jobs) {
            list.add(new Disk(a[0], a[1]));
        }
        Collections.sort(list, new StartComp());

        int time = 0;
        int idx = 0;
        int size = list.size();

        while (true) {
            if (idx == size) {
                while (!pq.isEmpty()) {
                    Disk current = pq.poll();
                    time += current.doing;
                    answer += (time - current.start);
                }
                break;
            }
            if (time < list.get(idx).start) {
                if (!pq.isEmpty()) {
                        Disk current = pq.poll();
                        time += current.doing;
                        answer += (time - current.start);

                } else {
                    time = Math.max(time, list.get(idx).start);
                    time += list.get(idx).doing;
                    answer += list.get(idx).doing;

                    idx++;
                }
                continue;

            } else {
                pq.add(list.get(idx));
                idx++;
            }

        }
        return answer / size;
    }
    static class StartComp implements Comparator<Disk> {
        @Override
        public int compare(Disk o1, Disk o2) { //o1이 기준이면 오름차순, o2기준이면 내림차순
            if(o1.start==o2.start) return o1.doing-o2.doing;
            return o1.start-o2.start;
        }
    }
    static class Disk implements Comparable<Disk> {
        int start;
        int doing;

        public Disk(int start, int doing) {
            this.start = start;
            this.doing = doing;
        }

        @Override
        public int compareTo(Disk o) {
            return this.doing - o.doing;
        }
    }
}