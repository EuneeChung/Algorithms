package src;

import java.util.Scanner;

public class Java_3040 {

    static int[] dwarfs9 = new int[9];
    static boolean[] isSelected = new boolean[9];
    static int sum=0;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int i=0;i<9;i++){
            dwarfs9[i]=sc.nextInt();
        }

        combDwarfs(0,0);
    }

    static void combDwarfs(int target,int cnt){
        if(cnt==7){ // 조합이 완료되었을떄 100 수가 되는지 찾기
            find7Dwarfs(isSelected);
            return;
        }
        if(target==9) return;

        isSelected[target] = true;
        combDwarfs(target+1,cnt+1);
        isSelected[target] = false;
        combDwarfs(target+1, cnt);
    }
    static void find7Dwarfs(boolean[] selected){
        sum=0;
        for(int i=0;i<9;i++){
            if(selected[i]) {
                sum+=dwarfs9[i];
                sb.append(dwarfs9[i]).append("\n");
            }
        }

        if(sum==100){
            sb.deleteCharAt(sb.lastIndexOf("\n"));
            System.out.print(sb);
        }
        else sb.setLength(0);
    }
}
