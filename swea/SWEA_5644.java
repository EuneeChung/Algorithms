package swea;

import java.util.ArrayList;
import java.util.Scanner;

public class SWEA_5644 {
    static int sum,max, xA, yA, xB, yB, move, numBC;
    static int chargeA,chargeB,chargeBoth;
    static int[] moveA,moveB;
    static int[][] BCs;
    static ArrayList<Integer> aEnabledBC=new ArrayList<>(); // A 충전가능한 BC (중복 제외)
    static ArrayList<Integer> bEnabledBC=new ArrayList<>(); // B 충전가능한 BC (중복 제외)
    static ArrayList<Integer> bothEnabledBC=new ArrayList<>(); // 둘다 충전가능한 BC

    static int[] deltaX={0,-1,0,1,0}; // 이동x, 상, 우, 하, 좌
    static int[] deltaY={0,0,1,0,-1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            xA = 1;
            yA = 1;
            xB = 10;
            yB = 10;
            sum=0;
            move=sc.nextInt();
            numBC= sc.nextInt();
            BCs = new int[numBC][4];
            moveA = new int[move+1]; // 0번쨰도 체크해주기 위함.
            moveB = new int[move+1];

            for(int i=1; i<=move;i++){
                moveA[i]=sc.nextInt();
            }
            for(int i=1; i<=move;i++){
                moveB[i]=sc.nextInt();
            }

            for(int i=0; i<numBC;i++){
                BCs[i][0]=sc.nextInt(); //y
                BCs[i][1]=sc.nextInt(); //x
                BCs[i][2]=sc.nextInt(); //C 거리
                BCs[i][3]=sc.nextInt(); //p 파워
            }

            for(int i=0;i<=move;i++){
                aEnabledBC.clear();
                bEnabledBC.clear();
                bothEnabledBC.clear();
                //알고리즘 시행

                // A move
                xA+=deltaX[moveA[i]];
                yA+=deltaY[moveA[i]];

                for(int bc=0;bc<numBC;bc++){
                    if(BCs[bc][2]>=Math.abs(BCs[bc][1]-xA)+Math.abs(BCs[bc][0]-yA)) aEnabledBC.add(bc);
                }

                // B move
                xB+=deltaX[moveB[i]];
                yB+=deltaY[moveB[i]];
                for(int bc=0;bc<numBC;bc++){
                    if(BCs[bc][2]>=Math.abs(BCs[bc][1]-xB)+Math.abs(BCs[bc][0]-yB)) {
                        if(aEnabledBC.contains(bc)){
                            bothEnabledBC.add(bc);
                            aEnabledBC.remove((Integer) bc);
                            continue;
                        }

                        bEnabledBC.add(bc);
                    }
                }
                chargeA=0;
                chargeB=0;
                chargeBoth=0;

                // 중첩되지 않은 A 중 최고 값 구하기
                for (Integer integer : aEnabledBC) {
                    chargeA = Math.max(chargeA, BCs[integer][3]);
                }
                // 중첩되지 않은 B 중 최고 값 구하기
                for (Integer integer : bEnabledBC) {
                    chargeB = Math.max(chargeB, BCs[integer][3]);
                }
                int maxIndex=-1;
                for (int j=0;j<bothEnabledBC.size();j++) {
                    if(chargeBoth< BCs[bothEnabledBC.get(j)][3]){
                        chargeBoth=BCs[bothEnabledBC.get(j)][3];
                        maxIndex=j;
                    }

                }


                int secondChargeBoth=0;
                if (bothEnabledBC.size()>=2){
                    if(maxIndex !=-1)bothEnabledBC.remove(maxIndex);
                    for (Integer integer : bothEnabledBC) {
                        secondChargeBoth = Math.max(secondChargeBoth, BCs[integer][3]);
                    }
                }
                max=0;
                // max 경우의 수 구하기
                max=Math.max(chargeA+chargeB,chargeBoth);// 겹치는 BC 사용과 겹치지 않는 각각의 충전 가능한 AB의 합
                max=Math.max(max,chargeB+chargeBoth); //B 만 충전가능 BC + 겹치는 BC
                max=Math.max(max,chargeA+chargeBoth); //A 만 충전가능 BC + 겹치는 BC
                max=Math.max(max,chargeBoth+secondChargeBoth); //겹치는 게 2개 이상일경우 둘다 겹치는거확인


                sum+=max;
            }


            sb.append("#").append(t).append(" ").append(sum).append("\n");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb);
    }
}
