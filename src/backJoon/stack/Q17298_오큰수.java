package backJoon.stack;

import java.util.*;
import java.io.*;

public class Q17298_오큰수 {

    //최대 값만 찾아짐
//    public static void main(String[] args) throws IOException{
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int n = Integer.parseInt(st.nextToken());
//        Stack<Integer> s = new Stack<>();
//        st = new StringTokenizer(br.readLine());
//        for (int i = 0; i < n; i++){
//            s.push(Integer.valueOf(st.nextToken()));
//        }
//        StringBuffer sb = new StringBuffer();
//        int[] arr = new int[n];
//        int max = s.pop();
//        arr[n-1] = -1;
//        for (int i = n-2; i>= 0; i--){
//            int tmp = s.pop();
//            if (tmp>max){
//                arr[i] = -1;
//                max = tmp;
//            }else{
//                arr[i] = max;
//            }
//        }
//        for (int i = 0; i < n; i++){
//            System.out.print(arr[i] + " ");
//        }
//    }

    // 시간 초과
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        Stack<Integer> s = new Stack<>();
//        int max = 0;
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            while(!s.isEmpty() && arr[s.peek()] < arr[i]){
                arr[s.pop()] = arr[i];
            }
            s.push(i);
        }
        while (!s.isEmpty()){
            arr[s.pop()] = -1;
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < n; i++){
//            System.out.print(arr[i] + " ");
            bw.write(arr[i] + " ");
        }
        bw.flush();
    }
}
