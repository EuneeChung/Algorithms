import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Java_1932 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int size = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] tree = new ArrayList[size];
        ArrayList<Integer>[] maxTree = new ArrayList[size];

        // 삼각형 저장
        for (int i = 0; i <size ; i++) {
            st =new StringTokenizer(br.readLine());
            tree[i]=new ArrayList<>();
            maxTree[i]=new ArrayList<>();
            while (st.hasMoreTokens()){
                tree[i].add(Integer.parseInt(st.nextToken()));
                maxTree[i].add(0);
            }
        }

        int[] dx ={-1,0};
        maxTree[0].set(0,tree[0].get(0));
        for (int i = 1; i <size ; i++) {
            int length = tree[i].size();
            for (int j = 0; j <length ; j++) {
                for (int d = 0; d < 2; d++) {
                    int tj = j+dx[d];
                    if(tj>=0&& tj <length-1){
                        int sum = maxTree[i - 1].get(tj) + tree[i].get(j);
                        sum = Math.max(sum, maxTree[i].get(j));
                        maxTree[i].set(j,sum);
                    }
                }
            }
        }
        int maxSum=0;
        for (int s : maxTree[size-1]){
            maxSum=Math.max(maxSum,s);
        }
        System.out.println(maxSum);
    }
}
