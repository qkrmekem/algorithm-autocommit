package backJoon;

import java.io.*;
import java.util.*;

public class Q11004_k번째수 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int n = Integer.parseInt(st.nextToken());
//        int k = Integer.parseInt(st.nextToken());
//        int[] arr = new int[n];
//        st = new StringTokenizer(br.readLine());
//        for (int i = 0; i < n; i++){
//            arr[i] = Integer.parseInt(st.nextToken());
//        }
//        Arrays.sort(arr);
//        System.out.println(arr[k-1]);
//    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        quick(arr, 0, n-1, k-1);
        System.out.println(arr[k-1]);
    }

    public static void quick(int[] arr, int s, int e, int k) {
        if (s < e){
            // 고정 idx를 저장할 변수
            int pivot = getPivot(arr, s, e);
            // pivot인덱스까지는 정렬이 완료 된 상태이므로 k와 일치하면 알고리즘 종료
            if (pivot == k) {
                return;
            // k가 pivot보다 작으면 왼쪽만 정렬
            } else if (k < pivot) {
                quick(arr, s, pivot - 1, k);
            // k가 pivot보다 크면 오른쪽만 정렬
            } else {
                quick(arr, pivot + 1, e, k);
            }
        }

    }

    // 고정idx pivot을 구하는 메서드
    public static int getPivot(int[] arr, int s, int e) {
        // 만약 남은 idx가 2개면
        if (s + 1 == e) {
            // 바로 두개의 크기를 비교해서
            if (arr[s] > arr[e]) {
                // 위치 변경 후
                swap(arr, s, e);
            }
            // 끝 인덱스를 pivot으로 반환
            return e;
        }

        // 중앙 idx를 pivot으로 설정
        int mid = (s + e) / 2;
        swap(arr, s, mid);
        // pivot을 구간의 첫idx로 이동
        int pivot = arr[s];

        // 현구간의 첫 idx
        int i = s + 1;
        // 현구간의 끝 idx
        int j = e;

        // 두 idx가 만날때까지 반목문 수행
        while (i <= j) {
            // j는 pivot보다 작은 값을 찾을때가지 왼쪽으로 이동
            while (j >= s + 1 && pivot < arr[j]) {
                j--;
            }
            // i는 pivot보다 큰 값을 찾을 때까지 오른쪽으로 이동
            while (i <= e && pivot > arr[i]) {
                i++;
            }
            // 인덱스가 아직 교차되지 않았다는 말은
            if (i <= j) {
                swap(arr, i++, j--);
            }
        }
        // pivot의 인덱스를 원래 위치로 되돌림
        arr[s] = arr[j];
        arr[j] = pivot;
        return j;
    }

    public static void swap(int[] arr, int s, int e) {
        int tmp = arr[s];
        arr[s] = arr[e];
        arr[e] = tmp;
    }

}
