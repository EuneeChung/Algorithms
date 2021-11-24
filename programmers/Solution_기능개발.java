package programmers;

import java.util.ArrayList;

public class Solution_기능개발 {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] days = new int[progresses.length];
        for (int i = 0; i < progresses.length; i++) {
            days[i] = done(progresses[i], speeds[i]);
        }
        ArrayList<Integer> release = new ArrayList<>();
        int day = days[0];
        int cnt = 1;
        for (int i = 1; i < days.length; i++) {
            if (day >= days[i]) {
                cnt++;
            } else {
                release.add(cnt);
                cnt = 1;
                day = days[i];
            }
        }
        release.add(cnt);
        int[] answer = new int[release.size()];
        for (int i = 0; i < release.size(); i++) {
            answer[i] = release.get(i);
        }
        return answer;
    }

    public int done(int current, int speed) {
        int day = 0;
        while (true) {
            current += speed;
            day++;
            if (current >= 100) break;
        }
        return day;
    }
}