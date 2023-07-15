package backJoon.bruteForce;

import java.util.Scanner;

public class Q7568 {
    // 덩치
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for(int i = 0; i < n; i++){
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        for (int i = 0; i < n; i++){
            int rank = 1;
            for (int y = 0; y < n; y++){
                if(i == y){
                    continue;
                }
                if (arr[i][0] < arr[y][0] && arr[i][1] < arr[y][1]){
                    rank ++;
                }
            }
            System.out.print(rank+" ");
        }
    }
}
