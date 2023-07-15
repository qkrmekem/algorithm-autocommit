package backJoon.twopointer;

import java.util.*;

public class Q1940_주몽의명령 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[num];
        for (int i = 0; i < num; i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int start = 0;
        int end = num-1;
        int count = 0;
        while(end>start){
            int sum = arr[start] + arr[end];
            if (sum == m){
                count++;
                start++;
                end--;
            }else if(sum > m){
                end--;
            }else {
                start++;
            }
        }
        System.out.println(count);
    }
}
