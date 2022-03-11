import java.util.*;

class Solution_구명보트 {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int length=people.length;
        Arrays.sort(people);
        
        boolean[] boatPeople = new boolean[length];
        int togetherIdx=length-1;
        for(int i=0; i<length;i++){
            if(boatPeople[i]) continue;
            boatPeople[i]=true;
            answer++;

             for(int j=togetherIdx; j>i;j--){
                 boatPeople[togetherIdx]=true;
                  togetherIdx--;
                 if(people[i] +people[j]<=limit) break;
                 else answer++;
             }
        }
        return answer;
    }
}