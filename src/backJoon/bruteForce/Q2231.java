package backJoon.bruteForce;

import java.util.Scanner;

public class Q2231 {
    // 분해함
    public static void main(String[] args){
        boolean have = false;
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int min = 0;
        for (int i = 0; i < num; i++){
            min = d(i);
            if (min == num){
                have = true;
                min = i;
                break;
            }
        }
        if (have == false){
            min = 0;
        }
        System.out.println(min);
    }
    public static int d(int n){
        int sum = n;
        int tmp = n;
        while(tmp != 0){
            sum += (tmp % 10);
            tmp /= 10;
        }
        return sum;
    }
}
