import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Java_16637 {
    static boolean[] isSelected;
    static char[] line;
    static int N, operationCnt, max = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        line = br.readLine().toCharArray();
        operationCnt = N / 2;
        isSelected = new boolean[operationCnt];
        if(N==1) max = (int) line[0]-'0';
        else addBracket(0);
        System.out.println(max);
    }

    static void addBracket(int idx) {
        if (idx >= operationCnt) {
            max = Math.max(calculateLine(), max);
            return;
        }

        isSelected[idx] = true;
        if (idx + 1 < operationCnt) isSelected[idx + 1] = false;
        addBracket(idx + 2);

        isSelected[idx] = false;
        addBracket(idx + 1);
    }

    static int calculateLine() {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < operationCnt; i++) {
            int result=0;
            if (isSelected[i]) {
                result = calc(line[i * 2 + 1], line[i * 2] - '0', line[(i + 1) * 2] - '0');
                if (i != 0) result = calc(stack.pop(), stack.pop(), result);

                stack.push(result);
                if (i + 1 < operationCnt) stack.push((int) line[(i + 1) * 2 + 1]);
                i++;
            } else {
                result = line[i * 2] - '0';
                if (stack.size() > 1) result =  calc(stack.pop(), stack.pop(), result);
                stack.push(result);
                stack.push((int) line[i * 2 + 1]);
            }
        }
        if (stack.size() > 1) {
            int result = line[N - 1] - '0';
            result = calc(stack.pop(), stack.pop(), result);
            stack.push(result);
        }
        return stack.pop();
    }

    static int calc(int operation, int a, int b) {
        if (operation == '+') return a + b;
        if (operation == '-') return a - b;
        return a * b;
    }
}
