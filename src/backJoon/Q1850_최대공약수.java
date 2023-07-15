package backJoon;

import java.io.*;
import java.util.*;

public class Q1850_최대공약수 {

    static long result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());
        gcd(min, max);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (long i = 0; i < result; i++) {
            bw.write("1");
        }
        bw.flush();
        br.close();
        bw.close();
    }

    public static void gcd(long min, long max) {
        if (min == 0) {
            result = max;
            return;
        }
        long nam = max % min;
        gcd(nam, min);
    }
}
