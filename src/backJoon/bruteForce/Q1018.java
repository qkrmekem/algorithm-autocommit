package backJoon.bruteForce;

import java.util.Scanner;

public class Q1018 {
    //체스판 다시 칠하기

    public static boolean[][] arr;
    public static int min = 64;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        arr = new boolean[n][m];

        for (int i = 0; i < n; i++){
            String str = sc.next();

            for (int y = 0; y < str.length(); y++){
                if (str.charAt(y) == 'W'){
                    arr[i][y] = true;
                }else {
                    arr[i][y] = false;
                }
            }
        }

        int n_search = n - 7;
        int m_search = m - 7;

        for (int i = 0; i < n_search;i++){
            for (int y = 0; y < m_search; y++){
                find(i,y);
            }
        }

        System.out.println(min);

    }
    public static void find(int n, int m){
        int n_length = n + 8;
        int m_length = m + 8;
        int cnt = 0;

        boolean result = arr[n][m];

        for (int i = n; i<n_length; i++){
            for (int y = m; y<m_length; y++){
                if (arr[i][y] != result){
                    cnt++;
                }
                result = !result;
            }
            result = !result;
        }
        cnt = Math.min(cnt, 64-cnt);
        min = Math.min(min,cnt);

    }
}
