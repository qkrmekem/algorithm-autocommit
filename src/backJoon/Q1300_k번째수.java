package backJoon;

import java.util.*;

public class Q1300_k번째수 {
    public static void main(String[] args) {
        //
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        long result = 0;

        int s = 1;
        int e = k;

//        int ls = 0;
//        int le = 0;
//        int tmp_mid = 0;
        while (s <= e) {
            int mid = (s + e) / 2;
            int cnt = 0;
            for (int i = 1; i <= n; i++) {
                cnt += Math.min(mid/i, n);
            }
            if (cnt <= k) {
                s = mid + 1;
                
            }else {
                e = mid - 1;
                result = mid;
            }
//            ls = s;
//            le = e;
//            tmp_mid = mid;
//            if (s > e) {
//                System.out.println(s);
//                break;
//            }
            // s5 e5 mid6
        }
        System.out.println(result);//6
//        System.out.println(ls);//6
//        System.out.println(le);//5
//        System.out.println(tmp_mid);
    }
}
