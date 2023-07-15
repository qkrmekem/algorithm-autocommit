package backJoon;

import java.io.*;
import java.util.*;

public class Q1929_소수구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int arr[] = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            arr[i] = i;
        }
        arr[1] = 0;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (arr[i] == 0) {
                continue;
            }
            for (int j = i + i; j <= n; j += i) {
                arr[j] = 0;
            }
        }
        for (int i = m; i <= n; i++) {
            if (arr[i] != 0) {
                System.out.println(arr[i]);
            }
        }
    }
}
