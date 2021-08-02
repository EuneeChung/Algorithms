package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_1289 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC=Integer.parseInt(br.readLine());
        Boolean currentBit = false;

        for(int t=0; t<TC; t++){
            String memoryLine = br.readLine();
            Boolean[] bMemorys = new Boolean[memoryLine.length()];
            currentBit = false;
            int count=0;

            for(int i=0; i<bMemorys.length;i++){
                if(memoryLine.charAt(i)=='0') bMemorys[i]=false;
                else  bMemorys[i]=true;
            }

            for(int i=0; i<bMemorys.length;i++){
                if(bMemorys[i] != currentBit) {
                    count++;
                    currentBit= !currentBit;
                }
            }
            System.out.println("#"+(t+1)+" "+count);
        }
    }
}
