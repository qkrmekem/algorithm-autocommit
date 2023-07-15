package backJoon.recursion;

import java.util.Scanner;

public class Q11729 {

    static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        sc.close();

        // 이건 n개의 원판을 다른 위치로 옮기고자 할때 걸리는 횟수를 구하는 공식
        sb.append((int)(Math.pow(2,cnt)-1)).append("\n");

        hanoi(cnt, 1, 2, 3);
        System.out.println(sb);
    }

    //from은 기존 위치
    //sub는 중간에 경유할 위치
    //to는 목적지
    //n은 원판의 개수
    public static void hanoi(int n, int from, int sub, int to){

        if (n==1){
            sb.append(from + " "+ to + "\n");
            return;
        }
        hanoi(n-1,from,to,sub);
        sb.append(from + " " + to + "\n");
        hanoi(n-1,sub,from,to);
    }

}
