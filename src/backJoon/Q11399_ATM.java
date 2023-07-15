package backJoon;

import java.util.*;
import java.io.*;

public class Q11399_ATM {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int arr[] = new int[n+1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int sum = 0;
        int[] sumArr = new int[n+1];
        for (int i = 1; i <= n; i++){
            sumArr[i] = sumArr[i-1]+arr[i];
            sum += sumArr[i];
        }
        System.out.println(sum);
    }
}
