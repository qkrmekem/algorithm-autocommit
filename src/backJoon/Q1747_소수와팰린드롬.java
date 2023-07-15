package backJoon;

import java.util.*;

public class Q1747_소수와팰린드롬 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[10000001];

        // 배열 초기화
        for (int i = 2; i < arr.length; i++) {
            arr[i] = i;
        }

        // 2부터 1씩 증가하며 소수를 판별
        // n = a * b라고 했을 때 a와 b 모두 n의 제곱근보다 클 수 없으므로
        for (int i = 2; i < Math.sqrt(arr.length); i++) {
            if (arr[i] != 0) {
                // 각 j의 배수는 소수가 될 수 없으므로
                // 0으로 치환
                for (int j = i + i; j < arr.length; j += i) {
                    arr[j] = 0;
                }
            }
        }
        int result = 0;

        // n부터 1씩 증가할 인덱스 변수
        int idx = n;
        while (true) {
            if (arr[idx] != 0) {
                // arr[idx]의 값을 char형 배열로 변환
                char[] tmp = String.valueOf(arr[idx]).toCharArray();
                int s = 0;
                int e = tmp.length - 1;

                // 필렌드롬인지 확인하기 위한 변수
                boolean check = true;

                // 시작 인덱스와 끝 인덱스를 서로 비교해 감
                while (s < e) {
                    // 만약 일치하지 않는 숫자가 나오면 반복문을 빠져나옴
                    if (tmp[s] != tmp[e]) {
                        check = false;
                        break;
                    }
                    s++;
                    e--;
                }

                // 만약 check변수가 true라면 해당 숫자는 필랜드롬이라는 뜻이므로
                // 결과를 result변수에 저장하고 반복문을 빠져나옴
                if (check) {
                    result = idx;
                    break;
                }
            }
            idx++;
        }
        // 결과를 출력
        System.out.println(result);
    }
}