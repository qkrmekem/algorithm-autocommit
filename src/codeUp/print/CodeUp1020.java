package codeUp.print;

import java.util.Scanner;
import java.util.StringTokenizer;

public class CodeUp1020 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        StringTokenizer st = new StringTokenizer(a, "-");
        System.out.println(st.nextElement()+st.nextToken());
        sc.close();
    }
}
