package codeUp.print;

import java.util.Scanner;

public class CodeUp1014 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String x = a.split(" ")[0];
        String y = a.split(" ")[1];
        System.out.println(y+" "+x);
        sc.close();
    }
}
