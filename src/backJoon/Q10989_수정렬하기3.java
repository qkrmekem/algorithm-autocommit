package backJoon;

import java.io.*;
import java.util.Arrays;

public class Q10989_수정렬하기3 {
//    public static void main(String[] args) throws IOException{
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine());
//
//        int[] arr = new int[n];
//        for (int i = 0; i < n; i++) {
//            arr[i] = Integer.parseInt(br.readLine());
//        }
//        radix(arr, 5);
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        for (int i = 0; i < n; i++) {
//            bw.write(arr[i] + "\n");
//        }
//        bw.flush();
//        bw.close();
//        br.close();
//    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < n; i++) {
            bw.write(arr[i] + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static void radix(int[] arr, int max) {
        // 각 자리수 계산하기 위한 변수
        int jarisu = 1;
        // 5자리수(10000)를 카운트 하는 변수
        int cnt = 0;
        // 각 자리수별로 정렬 결과를 임시로 저장할 변수
        int[] result = new int[arr.length];
        // 각 자리수 별로 정렬 진행
        while (cnt < 5) {
            // 각 자리수가 저장될 idx를 계산하기 위한 배열
            int[] bucket = new int[10];
            for (int i = 0; i < arr.length; i++) {
                // 각 자리수 데이터 개수 세기
                // 예를 들어 0의 자리 데이터가 12개, 1의 자리 데이터가 10개가 있다고 한다면
                bucket[(arr[i] / jarisu) % 10]++;
            }
            for (int i = 1; i < 10; i++) {
                // 각 자리수의 끝 idx부터 1씩 감소하며 저장하기 위해 합배열 사용
                // 예를 들어 0의 자리 데이터가 12개, 1의 자리 데이터가 10개가 있다고 한다면
                // bucket[0] = 12
                // bucket[1] = 22가 저장됨
                bucket[i] += bucket[i - 1];
            }
            for (int i = arr.length - 1; i >= 0; i--) {
                // 각 자리수마다 나뉜 구역의 끝 인덱스에 데이터를 저장
                result[bucket[(arr[i] / jarisu % 10)] - 1] = arr[i];
                // 다음 데이터를 위해 인덱스를 -1해줌
                // 예를 들어 1의자리 데이터(bucket[1])가 21번째 인덱스에 저장되었다면
                // 다음 1의자리 데이터(bucket[1])는 20번째 인덱스에 저장
                bucket[(arr[i] / jarisu % 10)]--;
            }
            for (int i = 0; i < arr.length; i++) {
                // 각 자리수의 정렬이 끝날때마다 원본 배열에 저장
                arr[i] = result[i];
            }
            // 다음 자리수 정렬을 위해 변수에 *10을 해준
            jarisu = jarisu * 10;
            // 정렬횟수 +1
            cnt++;
        }
    }
}
