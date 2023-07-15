package backJoon.twopointer;

import java.io.*;
import java.util.*;

public class Q1253_좋다 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(token.nextToken());
        long[] arr = new long[n];
        token = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++){
            arr[i] = Long.parseLong(token.nextToken());
        }
        Arrays.sort(arr);

        int count = 0;
        for (int i = 0; i < n; i++){
            int start = 0;
            int end = n-1;
            long target = arr[i];
            while (start<end){
                long sum = arr[start] + arr[end];
                if (sum == target){
                    if (start != i && end != i){
                        count++;
                        break;
                    } else if (start == i) {
                        start++;
                    } else if (end == i) {
                        end--;
                    }
                }else if(sum < target){
                    start++;
                }else {
                    end--;
                }
            }
        }
        System.out.println(count);
        bf.close();
    }
}
