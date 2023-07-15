package backJoon.twopointer;

import java.io.*;
import java.util.*;

public class Q1920_수찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int[] search = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            search[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < m; i++) {
            int s = 0;
            int e = n - 1;
            while (true) {
                int mid = (s + e) / 2;
                if (arr[mid] == search[i]) {
                    System.out.println(1);
                    break;
                } else if (arr[mid] > search[i]) {
                    e = mid - 1;
                } else {
                    s = mid + 1;
                }
                if (s > e) {
                    System.out.println(0);
                    break;
                }
            }
        }

    }
}
