package backJoon.array_list;

import java.util.Scanner;

public class Q11720_숫자의합 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        String numString = sc.next();
        char[] chars = numString.toCharArray();
        long sum = 0;
        for (int i = 0; i < chars.length; i++) {
            int tmp = chars[i]-'0';
            sum += tmp;
        }
        System.out.println(sum);
    }
}
