package backJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1377_버블소트 {
    // 시간 초과
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] arr = new int[n];
//        boolean change = false;
//        for (int i = 0; i < n; i++) {
//            arr[i] = sc.nextInt();
//        }
//        for (int i = n-1; i > 0; i--){
//            change = false;
//            for (int y = 0; y < i; y++){
//                if (arr[y] > arr[y+1]){
//                    change = true;
//                    int tmp = arr[y];
//                    arr[y] = arr[y+1];
//                    arr[y+1] = arr[y];
//                }
//            }
//            if (change == false){
//                System.out.println(i);
//                break;
//            }
//        }
//    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Bubble[] arr = new Bubble[n];
        boolean change = false;
        for (int i = 0; i < n; i++) {
            arr[i] = new Bubble(i, Integer.parseInt(br.readLine()));
        }
        Arrays.sort(arr);
        int max = 0;
        for (int i = 0; i < n; i++){
            if (max < arr[i].idx - i){
                max = arr[i].idx - i;
            }
        }
        System.out.println(max+1);
    }

    static class Bubble implements Comparable<Bubble>{
        int idx;
        int value;
        public Bubble(int idx, int value){
            this.idx = idx;
            this.value = value;
        }

        @Override
        public int compareTo(Bubble bubble){
            return this.value - bubble.value;
        }
    }

}
