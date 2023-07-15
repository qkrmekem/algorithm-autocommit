package backJoon.slidingwindow;

import java.io.*;
import java.util.*;

public class Q12891_DNA비밀번호 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int full = Integer.parseInt(st.nextToken());
        int part = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine());
        char[] arr = st.nextToken().toCharArray();

        // a, c, g, t
        int[] countArr = new int[4];
        for (int i = 0; i < part; i++){
            if (arr[i] == 'A'){
                countArr[0]++;
            } else if (arr[i] == 'C') {
                countArr[1]++;
            } else if(arr[i] == 'G'){
                countArr[2]++;
            } else if(arr[i] == 'T'){
                countArr[3]++;
            }
        }

        st = new StringTokenizer(bf.readLine());
        int[] input = new int[4];
        for (int i = 0; i < 4; i++){
            input[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0;
        if (countArr[0] >= input[0]){
            if (countArr[1] >= input[1]){
                if (countArr[2] >= input[2]){
                    if (countArr[3] >= input[3]){
                      count++;
                    }
                }
            }
        }
        for (int i = part; i<full; i++){
            if (arr[i] == 'A'){
                countArr[0]++;
            } else if (arr[i] == 'C') {
                countArr[1]++;
            } else if(arr[i] == 'G'){
                countArr[2]++;
            } else if(arr[i] == 'T'){
                countArr[3]++;
            }
            if (arr[i-part] == 'A'){
                countArr[0]--;
            } else if (arr[i-part] == 'C') {
                countArr[1]--;
            } else if(arr[i-part] == 'G'){
                countArr[2]--;
            } else if(arr[i-part] == 'T'){
                countArr[3]--;
            }
            if (countArr[0] >= input[0]){
                if (countArr[1] >= input[1]){
                    if (countArr[2] >= input[2]){
                        if (countArr[3] >= input[3]){
                            count++;
                        }
                    }
                }
            }
        }
        System.out.println(count);

    }

}
