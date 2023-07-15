package backJoon.Greedy;

import java.util.Scanner;

public class Q2839 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int kg = sc.nextInt();
        int cnt = 0;

        while (true){
            if(kg % 5 == 0){
                cnt += kg / 5;
                System.out.println(cnt);
                break;
            }
            kg -= 3;
            if (kg < 0) {
                System.out.println(-1);
                break;
            }
            cnt++;
        }
     // 커밋 테스트
    }
}
