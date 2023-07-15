package codeUp.print;

import java.util.Scanner;

public class CodeUp1013 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        int x = Integer.parseInt(a.split(" ")[0]);
        int y = Integer.parseInt(a.split(" ")[1]);
        System.out.println(x+" "+y);
        sc.close();
    }
}
