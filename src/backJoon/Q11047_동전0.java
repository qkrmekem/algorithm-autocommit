package backJoon;

import java.util.*;
import java.io.*;

public class Q11047_동전0 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int total = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int mok = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = n-1; i >= 0; i--) {
            mok += total / arr[i];
            total = total % arr[i];
            if (total == 0) {
                break;
            }
        }
        System.out.println(mok);
    }
}
