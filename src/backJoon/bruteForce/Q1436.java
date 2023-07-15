package backJoon.bruteForce;

import java.util.Arrays;
import java.util.Scanner;

public class Q1436 {
    // 영화감독 숌

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int n = 666;
        int count = 1;

        while (count != num){
            n++;
            if(String.valueOf(n).contains("666")){
                count++;
            }
        }
        System.out.println(n);
    }
}
