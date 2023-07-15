package codeUp.print;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Float a = sc.nextFloat();
        StringTokenizer st = new StringTokenizer(a.toString(), ".");
        sc.close();
    }
}
