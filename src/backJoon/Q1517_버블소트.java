package backJoon;

import java.io.*;
import java.util.*;

public class Q1517_버블소트 {

    public static int[] arr;
    public static int[] tmp;
    // int로 선언하니 에러 발생
    public static long result;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        arr = new int[n + 1];
        tmp = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        result = 0;
        merge(1, n);
        System.out.println(result);
    }

    public static void merge(int s, int e) {
        if (e - s < 1) {
            return;
        }

        int mid = s + (e-s)/2;

        merge(s, mid);
        merge(mid + 1, e);

        int point = s;
        int idx1 = s;
        int idx2 = mid + 1;

        for (int i = s; i<=e; i++){
            tmp[i] = arr[i];
        }

        while (idx1 <= mid && idx2 <= e) {
            if (tmp[idx1] > tmp[idx2]){
                arr[point] = tmp[idx2];
                result = result + idx2 - point;
                point++;
                idx2++;
            }else{
                arr[point] = tmp[idx1];
                point++;
                idx1++;
            }
        }

        while (idx1 <= mid) {
            arr[point] = tmp[idx1];
            point++;
            idx1++;
        }
        while (idx2 <= e) {
            arr[point] = tmp[idx2];
            point++;
            idx2++;
        }
    }
}
