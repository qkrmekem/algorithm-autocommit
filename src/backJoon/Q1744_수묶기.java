package backJoon;

import java.io.*;
import java.util.*;

public class Q1744_수묶기 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 양수의 경우 큰 수부터 묶어 연산해주는게 최대값을 구할 수 있으므로 내림차순으로 정렬
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> {
            return b - a;
        });
        // 음수의 경우 작은 값부터 묶어 곱하면 최대값을 만들 수 있으므로 오름차순 정렬
        PriorityQueue<Integer> mq = new PriorityQueue<>();


        int one = 0;
        int zero = 0;

        // 4가지 경우의 수로 나눠서 연산
        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(br.readLine());
            // 1보다 클 때
            if (tmp > 1) {
                pq.add(tmp);
            // 1일때
            // 1은 곱하는 것보다 더하는게 더 큰 수를 만들 수 있음
            } else if (tmp == 1) {
                one++;
            // 0일때
            // 남은 음수와 0을 곱할 때 사용
            } else if (tmp == 0) {
                zero++;
            // 음수일 때
            } else {
                mq.add(tmp);
            }
        }

        int sum = 0;

        // 양수의 경우부터 연산
        while (pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();
            sum += a * b;
        }
        // 양수의 나머지 값 누적
        if (!pq.isEmpty()) {
            sum += pq.remove();
        }

        // 1의 개수만큼 누적
        sum += one;

        // 음수를 연산
        while (mq.size() > 1) {
            int a = mq.remove();
            int b = mq.remove();
            sum += a * b;
        }

        // 음수에 남은 수가 있을 때
        if (!mq.isEmpty()) {
            // 0이 남았다면
            if (zero != 0) {
                // 누적하지 않고 제거
                mq.remove();
            // 0이 없을 경우
            } else {
                // 결과에 누적
                sum += mq.remove();
            }
        }
        System.out.println(sum);
    }
}
