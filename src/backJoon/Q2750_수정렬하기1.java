package backJoon;

import java.util.*;

public class Q2750_수정렬하기1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = n-1; i > 0; i--){
            for (int y = 0; y < i; y++){
                if (arr[y]>arr[y+1]){
                    int tmp = arr[y];
                    arr[y] = arr[y+1];
                    arr[y+1] = tmp;
                }
            }
        }
        for (int i =0; i < n; i++){
            System.out.println(arr[i]);
        }
    }
}
