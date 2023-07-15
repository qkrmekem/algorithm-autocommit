package codeUp.print;

import java.util.Scanner;

public class CodeUp1019 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        int z = Integer.parseInt(a.split("\\.")[0]);
        int x = Integer.parseInt(a.split("\\.")[1]);
        int c = Integer.parseInt(a.split("\\.")[2]);
        System.out.printf("%04d.%02d.%02d", z,x,c);
        sc.close();
    }
}
