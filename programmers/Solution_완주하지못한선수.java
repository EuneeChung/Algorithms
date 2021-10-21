package programmers;

import java.util.*;

public class Solution_완주하지못한선수 {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap();

        for (int i = 0; i < participant.length; i++) {
            map.putIfAbsent(participant[i], 0);
            map.put(participant[i], map.get(participant[i]) + 1);
        }

        for (int i = 0; i < completion.length; i++) {
            map.put(completion[i], map.get(completion[i]) - 1);
            if (map.get(completion[i]) == 0) map.remove(completion[i]);
        }
        Iterator key = map.keySet().iterator();

        return key.next().toString();
    }
}
