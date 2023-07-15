package backJoon;

import java.util.*;
import java.io.*;

public class Q1934_최소공배수 {

    static int tmp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        int result = 0;
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int min = Integer.parseInt(st.nextToken());
            int max = Integer.parseInt(st.nextToken());
            gcd(min, max);
            result = max * min / tmp;
            System.out.println(result);
        }
    }

    public static void gcd(int min, int max) {
        if (min == 0) {
            tmp = max;
            return;
        }
        int nam = max % min;
        gcd(nam, min);
    }
}
