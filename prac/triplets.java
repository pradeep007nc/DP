package prac;

import java.util.Scanner;
import java.util.Stack;

public class triplets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int inputSize = sc.nextInt();
        String[] data = new String[inputSize];
        sc.nextLine();

        for(int i=0;i<inputSize;i++)
            data[i] = sc.next();

        int ans = basketBall(data, inputSize);
        System.out.println(ans);
    }

    public static int basketBall(String[] data, int size){
        int ans = 0;
        Stack<Integer> stack = new Stack<>();

        for(String str: data){
            if(str.equals("+")){
                int prev1 = stack.pop();
                int prev2 = stack.pop();
                stack.push(prev2);
                stack.push(prev1);
                stack.push(prev1+prev2);
            }
            else if(str.equals("D"))
                stack.push(stack.peek() * 2);
            else if(str.equals("C"))
                stack.pop();
            else
                stack.push(Integer.parseInt(str));
        }

        for(int i: stack){
            ans += i;
        }

        return ans;
    }

}
