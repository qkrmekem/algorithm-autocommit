package backJoon.bruteForce;

import java.util.Arrays;
import java.util.Scanner;

public class Q2309 {
    //일곱난쟁이

    public static boolean[][] arr;
    public static int min = 64;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr[] = new int[9];
        for (int i = 0; i < arr.length; i++){
            arr[i] = sc.nextInt();
        }
        int sum = 0;
        for (int i = 0; i < arr.length; i++){
            sum+=arr[i];
        }
        int idx1 = 0;
        int idx2 = 0;
        loop:
        for (int i = 0; i<arr.length-1; i++){
            for (int y = i+1;y< arr.length; y++){
                if (sum-(arr[i]+arr[y]) == 100){
                    idx1 = arr[i];
                    idx2 = arr[y];
                    break loop;
                }
            }
        }
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++){
            if (arr[i] == idx1 || arr[i] == idx2){
                continue;
            }
            System.out.println(arr[i]);
        }
    }
}
