package backJoon;

import java.util.*;
import java.io.*;

public class Q1427_소트인사이드 {
    // 내 풀이
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String n = br.readLine();
//        char[] arr = n.toCharArray();
//        Arrays.sort(arr);
//        StringBuffer sb = new StringBuffer();
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        for (int i = n.length()-1; i >= 0; i--){
//            sb.append(arr[i]-'0');
////            System.out.print(arr[i]-'0');
//        }
//        bw.write(sb.toString());
//        bw.flush();
//        br.close();
//        bw.close();
//    }

    // 선택정렬
    public static void main(String[] args) throws IOException {
        BufferedReader bw = new BufferedReader(new InputStreamReader(System.in));
        String n = bw.readLine();
        int[] arr = new int[n.length()];
        for (int i = 0; i<arr.length; i++){
            arr[i] = Integer.parseInt(n.substring(i, i + 1));
        }
        for (int i = 0; i < arr.length-1; i++){
            int maxIdx = i;
            for (int j = i+1;j<arr.length;j++){
                if (arr[maxIdx] < arr[j]){
                    maxIdx = j;
                }
            }
            if (arr[i] < arr[maxIdx]){
                int tmp = arr[maxIdx];
                arr[maxIdx] = arr[i];
                arr[i] = tmp;
            }
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < arr.length; i++){
            sb.append(arr[i]);
        }
        System.out.println(sb.toString());
    }

}
