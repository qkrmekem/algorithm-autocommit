package backJoon;

import java.util.Scanner;

public class Q2751_수정렬하기2 {
    public static int[] arr;
    public static int[] tmp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // 정렬할 배열
        arr = new int[n+1];
        // 임시 배열
        tmp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }
        merge(1, n);
        StringBuffer sb = new StringBuffer();
        for (int i = 1; i <= n; i++) {
            sb.append(arr[i] + "\n");
        }
        System.out.println(sb.toString());
    }

    public static void merge(int s, int e) {
        // 각 구간의 길이가 1보다 작거나 같으면 이미 해당 구간은 정렬이 완료된 상태이므로 return수행
        // 최소 길이인 1까지 배열이 분리되었다면 return이 수행되어 직전 재귀함수로 돌아가고,
        // 구간의 길이는 2가 됨
        if (e - s < 1) {
            return;
        }
        // (e - s) / 2를 통해 점점 작아지는 구간의 중간값을 구하고
        // s를 더해줌으로 각 구간의 중간값 위치를 찾아줌
        int m = s + (e - s) / 2;
        // 먼저 배열을 최소단위로 쪼개줘야 하므로 재귀호출을 통해 배열을 쪼개줌
        merge(s, m);
        merge(m + 1, e);
        // 각 재귀호출에서 정렬을 위해 각 구간의 값을 임시 배열에 저장
        for (int i = s; i <= e; i++) {
            tmp[i] = arr[i];
        }
        // 각 구간의 시작지점부터 1씩 증가할 idx값
        int k = s;
        // 첫 구간의 시작idx
        int idx1 = s;
        // 두 번째 구간의 시작 idx
        int idx2 = m + 1;
        // 어느 한 구간의 정렬이 끝날 때까지 정렬 수행
        while (idx1 <= m && idx2 <= e) {
            if (tmp[idx1] > tmp[idx2]) {
                arr[k] = tmp[idx2];
                k++;
                idx2++;
            } else {
                arr[k] = tmp[idx1];
                k++;
                idx1++;
            }
        }
        // 각 그룹에 남아있는 값을 정리
        while (idx1 <= m) {
            arr[k] = tmp[idx1];
            k++;
            idx1++;
        }
        while (idx2 <= e) {
            arr[k] = tmp[idx2];
            k++;
            idx2++;
        }
    }
}
