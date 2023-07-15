package backJoon;

import java.io.*;
import java.util.*;

public class Q2343_기타레슨 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n+1];
        st = new StringTokenizer(br.readLine());
        int s = 0;
        int e = 0;
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (arr[i] > s){
                s = arr[i];
            }
            e += arr[i];
        }
        int result = 0;
        int ls = 0;
        int le = 0;
        while (s <= e) {
            int mid = (s + e) / 2;
            int cnt = 1;
            int tmp = 0;
            for (int i = 1; i <= n; i++) {
                tmp += arr[i];
                if (tmp > mid) {
                    cnt++;
                    tmp = arr[i];
                }
            }
            if (cnt > m) {
                s = mid + 1;
            }else {
                e = mid - 1;
                result = mid;
            }
            ls = s;
            le = e;
//            if (s > e) {
//                System.out.println(s);
//                break;
//            }
            // s17 e16 mid16
        }
        System.out.println(result);//17
        System.out.println(ls);//17
        System.out.println(le);//16
    }
}
