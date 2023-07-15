package backJoon;

import java.io.*;
import java.util.*;

public class Q1456_거의소수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long[] arr = new long[10000001];
        for (int i = 2; i < arr.length; i++) {
            arr[i] = i;
        }

        // 소수 구하기
        for (int i = 2; i <= Math.sqrt(arr.length); i++) {
            if (arr[i] == 0) {
                continue;
            }

            for (int j = i + i; j < arr.length; j = j + i) {
                arr[j] = 0;
            }

        }

        int cnt = 0;
        for (int i = 2; i < 10000001; i++) {
            if (arr[i] != 0) {
                long tmp = i;
                while ((double)i <= (double)b/(double)tmp) {
                    if ((double)i >= (double)a/(double)tmp) {
                        cnt++;
                    }
                    tmp = tmp * i;

                }
            }
        }
        System.out.println(cnt);
    }
}
