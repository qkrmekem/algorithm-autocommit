package programmers;

import java.util.Scanner;

public class Pro_직사각형별찍기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        // System.out.println(a + b);

//         Integer n = Integer.parseInt(args.split(" ")[0]);
//         Integer m = Integer.parseInt(args.split(" ")[1]);

        for(int i = 0; i < b; i++){
            System.out.println("*".repeat(a));
        }
    }
}
