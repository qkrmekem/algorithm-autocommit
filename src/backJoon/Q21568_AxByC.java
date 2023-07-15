package backJoon;

import java.util.*;

public class Q21568_AxByC {

    static int result;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        gcd(a, b);
        if (c % result != 0) {
            System.out.println(-1);
        } else {
            int mok = c/result;
            long[] ret = excute(a, b);
            // 최종적으로 나온 x와 y값을 mok으로 곱해 출력
            // 여기서 mok은 c를 (x,y)의 최대공배수로 나눈 값
            System.out.println(ret[0] * mok + " " + ret[1] * mok);
        }
    }

    public static long[] excute(long a, long b) {
        // 이전의 x,y값을 담을 배열
        long[] ret = new long[2];
        // 나머지가 0이 나오면 x=1, y=0으로 설정 후
        // 유클리드 호제법 역순 계산
        if (b == 0) {
            ret[0] = 1;
            ret[1] = 0;
            return ret;
        }
        // q는 현재 재귀함수의 몫
        long q = a / b;
        long[] v = excute(b, a % b);
        // x = y`
        ret[0] = v[1];
        // y = x` - y`+q(몫)
        ret[1] = v[0] - v[1] * q;
        return ret;
    }

    public static void gcd(int a, int b) {
        if (b == 0) {
            result = a;
            return;
        }
        int nam = a % b;
        gcd(b, nam);
    }
}
