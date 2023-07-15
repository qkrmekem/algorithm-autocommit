package backJoon.stack;

import java.util.*;

public class Q1874_스택수열 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Stack<Integer> stack = new Stack<>();
        StringBuffer sb = new StringBuffer();
        int idx = 0;
        for (int i = 0; i < n; i++){
            int tmp = sc.nextInt();
            while(idx<tmp){
                idx++;
                stack.push(idx);
                sb.append("+\n");
            }
            int out = stack.pop();
            sb.append("-\n");
            if (out < tmp){
                System.out.println("NO");
                return;
            }
        }
        System.out.println(sb.toString());
    }
}
