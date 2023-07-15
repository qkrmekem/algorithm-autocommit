package backJoon.Greedy;

import java.util.*;

public class Q1931 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<Integer, Integer> map = new TreeMap<>();
        int max = sc.nextInt();
        int[][] arr = new int[max][2];
        for(int i=0; i< arr.length; i++){
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        sc.close();
        Arrays.sort(arr,(a,b) ->{
            if (a[1] == b[1]){
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });
        int end = 0;
        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][0] >= end){
                cnt++;
                end = arr[i][1];
            }
        }
        System.out.println(cnt);
    }
}
