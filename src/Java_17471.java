package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Java_17471 {
    static int N,min=Integer.MAX_VALUE;
    static boolean[] isA;
    static int[] population;
    static ArrayList<Integer>[] areaConnections;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        population= new int[N];
        isA=new boolean[N];
        areaConnections= new ArrayList[N];
        int totalSum=0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i <N ; i++) {
            population[i]=Integer.parseInt(st.nextToken());
            totalSum+=population[i];
        }
        for (int i = 0; i <N ; i++) {
            st = new StringTokenizer(br.readLine());
            int m= Integer.parseInt(st.nextToken());
            areaConnections[i]= new ArrayList<>();
            for (int j = 0; j <m ; j++) {
                areaConnections[i].add(Integer.parseInt(st.nextToken())-1);
            }
        }
        comb(0,0,0,totalSum);

        if(min==Integer.MAX_VALUE) min=-1;
        System.out.println(min);
    }
    static void comb(int start, int cnt,int aSum, int bSum){
        if(cnt>N/2) return;
        for (int i = start; i <N ; i++) {
            if(isA[i]) continue;
            isA[i]=true;
            if(isConnect()){
                min=Math.min(min,Math.abs(aSum+population[i]-(bSum-population[i])));
            }
            comb(start+1, cnt+1,aSum+population[i],bSum-population[i]);
            isA[i]=false;
        }
    }
    static boolean isConnect(){
        ArrayList<Integer> aList = new ArrayList<>();
        ArrayList<Integer> bList = new ArrayList<>();
        boolean[] isConnect = new boolean[N];
        for (int i = 0; i <N ; i++) {
            if(isA[i]) aList.add(i);
            else bList.add(i);
        }
        if(aList.size()==0) return false;
        if(bList.size()==0) return false;

        Queue<Integer> que = new LinkedList<>();
        que.add(aList.get(0));
        isConnect[aList.get(0)]=true;

        while (!que.isEmpty()){
            int node=(int) que.poll();
            for(Integer c: areaConnections[node]){
                if(!isConnect[c]&&isA[c]) {
                    isConnect[c]=true;
                    que.add(c);
                }
            }
        }
        que.add(bList.get(0));
        isConnect[bList.get(0)]=true;
        while (!que.isEmpty()){
            int node=(int) que.poll();
            for(Integer c: areaConnections[node]){
                if(!isConnect[c]&&!isA[c]) {
                    isConnect[c]=true;
                    que.add(c);
                }
            }
        }
        for (boolean connected:isConnect) {
            if(!connected) return false;
        }
        return true;
    }
}
