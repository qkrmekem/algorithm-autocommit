package backJoon;

import java.io.*;
import java.util.*;

public class Q1016_제곱ㄴㄴ수 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());
        // 제곱수인지 아닌지 확인하기 위한 배열
        boolean[] check = new boolean[(int) (max - min + 1)];
        // 제곱이 max이하일 때까지만 반복
        for (long i = 2; i * i <= max; i++) {
            // 제곱
            long pow = i * i;

            // 탐색을 시작할 값을 저장
            long s = min / pow;
            // 제곱값이 최소값 min 보다 작을 경우
            // 1을 증가시켜  최소값 min이상의 첫번째 제곱의 배수값으로 만들어줌
            /*
            * 예를 들어, min이 10이고 pow가 4일때
            * min을 4로 나눈 몫은 2이다.
            * 하지만 min을 4로 나눈 나머지는 2이므로 min은 pow인 4로 나누어 떨어지지 않는다.
            * 따라서 s 값을 1 증가시켜 3으로 만들어준다. (4 * 3 = 12로 10보다 크므로)
            * 이렇게 함으로써 s는 min 이상의 첫 번째 pow의 배수를 의미하게 된다.
            * 이 값은 나중에 반복문에서 j의 시작 값으로 사용되어 pow의 배수를 찾아내는데 활용
            * */
            if (min % pow != 0) {
                s++;
            }
            // 제곱수룰 구하기 위한 반복문
            // 제곱수의 배수도 제곱수이므로 체크해줌
            for (long j = s; pow * j <= max; j++) {
                check[(int) ((j * pow) - min)] = true;
            }
        }
        int cnt = 0;
        for (int i = 0; i <= max - min; i++) {
            if (!check[i]) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
