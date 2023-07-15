package backJoon.array_list;

import java.util.Scanner;

public class Q1546_평균구하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int quantity = sc.nextInt();
        int[] arr = new int[quantity];
        int max = 0;
        float sum = 0;
        for (int i = 0; i < quantity; i++) {
            arr[i] = sc.nextInt();
            if (arr[i] > max){
                max=arr[i];
            }

        }
//        System.out.println(sum * 100.0 / max / quantity);
        for (int i = 0; i < quantity; i++){
            float tmp = arr[i] / Float.valueOf(max) * 100;
//            System.out.println(tmp);
            sum += tmp;
        }
        System.out.println(sum / quantity);

    }
}
