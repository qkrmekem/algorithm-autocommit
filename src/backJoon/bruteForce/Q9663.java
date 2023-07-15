package backJoon.bruteForce;

import java.util.Scanner;

public class Q9663 {
    //N-Queen

    // 체스판을 나타낼 배열
    static int[] arr;
    // 체스판의 크기와 퀸의 개수를 나타낼 변수
    static int n;
    // n개의 퀸을 체스판에 놓을 수 있는 경우의수
    static int count = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        arr = new int[n];

        // 재귀함수 시작
        nqueen(0);
        System.out.println(count);

    }

    // col은 현재 재귀함수의 열의 위치를 나타냄
    private static void nqueen(int col) {
        // 배열이라 0부터 시작하는 col의 값이 체스판의 크기 n과 같다는 말은
        // 마지막 열인 col=3에 퀸을 놓는데 성공하여 nqueen(3+1)을 호출했다는 말이므로
        // count를 +1 시켜준다.
        if (col == n){
            count++;
            return;
        }
        for (int i = 0; i<n; i++){
            arr[col] = i;
            // 퀸을 놓을 수 있는 장소인지 확인하는 메서드
            if (able(col)){
                nqueen(col+1);
            }
        }
    }

    // 퀸을 놓을 수 있는 장소인지 확인하는 메서드
    private static boolean able(int col) {
        // 현재 열 위치가 2라고 한다면 0,1번째 열의 퀸 위치도 확인해야 하므로
        for (int i = 0; i < col; i++){
            // arr[] 내부의 값(value)들은 행을 나타낸다고 했으므로
            // 서로의 값이 일치한다는건 같은 행에 위치한다는 뜻이므로 false 반환
            if (arr[col] == arr[i]){
                return false;
                // 대각선은 현재 열 - 이전 열과 현재 행 - 이전 행이 같을 때이므로
            } else if (Math.abs(col-i)==Math.abs(arr[col]-arr[i])) {
                return false;
            }
        }
        // 위의 두 경우가 아니라면 다른 퀸으로부터 안전하다는 뜻이므로 true 반환
        return true;
    }
}
