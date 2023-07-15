package backJoon;

import java.io.*;
import java.util.*;

public class Q2023_신기한소수찾기 {

    static int n;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException{
        // n 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        dfs(2, 1);
        dfs(3, 1);
        dfs(5, 1);
        dfs(7, 1);
        bw.flush();
        br.close();
        bw.close();
    }

    public static void dfs(int num, int size) throws IOException {
        if (size == n) {
            if (sosu(num)){
                bw.write(num + "\n");
            }
        }
        for (int i = 1; i <= 9; i++) {
            if (i % 2 == 0) {
                continue;
            }
            if (sosu(num * 10 + i)) {
                dfs(num * 10 + i, size++);
            }
        }
    }

    public static boolean sosu(int num) {
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
