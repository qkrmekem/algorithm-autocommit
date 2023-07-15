package backJoon.bruteForce;

import java.util.Scanner;

public class Q2798 {
    //블랙잭
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int max = sc.nextInt();
        int[] arr = new int[num];
        for (int i = 0; i < num; i++){
            arr[i] = sc.nextInt();
        }
        int sum = 0;

        loop:
        for(int i = 0; i<num-2; i++){
            for(int y = i+1; y<num-1; y++){
                for(int z = y+1; z<num; z++){
                    int tmp = arr[i] + arr[y] + arr[z];
                    if (tmp > max){
                        continue;
                    }
                    if(max - tmp < max - sum  ){
                        sum = tmp;
                    }
                    if (tmp == max){

                        break loop;
                    }
                }
            }
        }
        System.out.println(sum);
    }


}
