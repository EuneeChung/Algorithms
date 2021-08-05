package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class SWEA_1218 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        for(int t=1;t<=10;t++){
            int isInvalidate = 1;
            int length =Integer.parseInt(br.readLine());
            String lines = br.readLine();
            Stack<Character> stack= new Stack<>();
            for(int i=0;i<length;i++){
                char c =lines.charAt(i);

                if(c=='{'||c=='('||c=='['||c=='<') stack.push(c);
                else{
                    if(c=='}'&& '{' == stack.peek()) stack.pop();
                    else if(c==']'&& '[' == stack.peek()) stack.pop();
                    else if(c=='>'&& '<' == stack.peek()) stack.pop();
                    else if(c==')'&& '(' == stack.peek()) stack.pop();
                    else {
                        isInvalidate=0;
                        break;
                    }
                }
            }




            System.out.println("#"+t+" "+isInvalidate);
        }


    }
}
