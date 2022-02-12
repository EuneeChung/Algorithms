import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Java_17825 {
    static int[] dices = new int[10];
    static int[][] gameMap = {
            {0,2,4,6,8,10,12,14,16,18,20,22,24,26,28,30,32,34,36,38,40},
            {10,13,16,19,25,30,35,40},
            {20,22,24,25,30,35,40},
            {30,28,27,26,25,30,35,40}
    };
    static Horse[] horses = new Horse[4];
    static int max =Integer.MIN_VALUE;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 10; i++) {
            dices[i]=Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i <4; i++) {
            horses[i]=new Horse();
        }
        dfs(0,0);
        System.out.println(max);
    }
    public static void dfs(int diceIdx, int cnt){

        if(diceIdx>=10) {
            max=Math.max(max,cnt);
            return;
        }

        choice : for (int h = 0; h <4 ; h++) {
            Horse current = horses[h];
            int orgLine = current.line;
            int orgIdx = current.idx;
            if(gameMap[orgLine].length <= orgIdx) continue;
            int desIdx = dices[diceIdx]+ orgIdx;
            int desNum = gameMap[orgLine].length <= desIdx? 0: gameMap[orgLine][desIdx];
            int desLine = (orgLine==0&&desNum!=40&&desNum%10==0)?desNum/10 : current.line;
            if(orgLine!=desLine) desIdx=0;
            if(desNum!=0){
                for (int p = 0; p < 4 ; p++) {
                    if(h==p) continue;
                    if(horses[p].idx>=gameMap[horses[p].line].length) continue;
                    if(horses[p].line ==desLine && horses[p].idx==desIdx) continue choice;
                    if(desNum==25 || desNum ==35 || desNum ==40)
                        if(gameMap[horses[p].line][horses[p].idx]==desNum) continue choice;
                    if(desNum==30&&gameMap[horses[p].line][horses[p].idx]==30){
                        if(desIdx==0 && desLine==3 && horses[p].idx!=0) continue;
                        if(horses[p].idx==0&&horses[p].line==3 && desIdx!=0) continue;
                        continue choice;
                    }
                }
            }
            current.line=desLine;
            current.idx = desIdx;

            dfs(diceIdx+1,cnt+desNum);

            current.line=orgLine;
            current.idx=orgIdx;
        }

    }
    static class Horse{
        int line=0, idx=0;
    }
}
