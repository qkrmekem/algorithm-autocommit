package backJoon.prefix_sum;

import java.io.*;
import java.util.*;

public class Q11659_구간합구하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int num = Integer.parseInt(stringTokenizer.nextToken());
        int count = Integer.parseInt(stringTokenizer.nextToken());
        long[] sum = new long[num+1];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 1; i <= num; i++){
            sum[i] = Integer.parseInt(stringTokenizer.nextToken()) + sum[i-1];
        }
        for (int i = 0; i < count; i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int start = Integer.parseInt(stringTokenizer.nextToken());
            int end = Integer.parseInt(stringTokenizer.nextToken());
            System.out.println(sum[end] - sum[start-1]);
        }
    }
}
