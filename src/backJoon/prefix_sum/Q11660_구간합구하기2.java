package backJoon.prefix_sum;

import java.io.*;
import java.util.*;

public class Q11660_구간합구하기2 {

//    public static void main(String[] args) throws IOException{
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
//        int size = Integer.parseInt(stringTokenizer.nextToken());
//        int count = Integer.parseInt(stringTokenizer.nextToken());
//        int[][] input = new int[size+1][size+1];
//        int[][] sum = new int[size+1][size+1];
//        for (int i = 1; i <= size; i++){
//            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
//            for (int y = 1; y <= size; y++){
//                int tmp = Integer.parseInt(stringTokenizer.nextToken());
//                input[i][y] = tmp;
//                sum[i][y] = sum[i][y-1] + tmp;
//            }
//        }
//        for (int i = 0; i < count; i++){
//            int[] pos = new int[4];
//            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
//            for(int y = 0; y<4; y++){
//                pos[y] = Integer.parseInt(stringTokenizer.nextToken());
//            }
//            int result = 0;
//            for (int z = pos[0]; z<=pos[2]; z++){
//                result += sum[z][pos[3]] - sum[z][pos[1]-1] ;
//            }
//            System.out.println(result);
//        }
//    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(bf.readLine());
        int size = Integer.parseInt(token.nextToken());
        int count = Integer.parseInt(token.nextToken());
        int[][] input = new int[size+1][size+1];
        int[][] sum = new int[size+1][size+1];
        for (int i = 1; i <= size; i++){
            token = new StringTokenizer(bf.readLine());
            for(int y = 1; y <= size; y++){
                int tmp = Integer.parseInt(token.nextToken());
                input[i][y] = tmp;
                sum[i][y] = sum[i][y-1] + sum[i-1][y] - sum[i-1][y-1] + tmp;
            }
        }
        for (int i = 0; i < count; i++){
            int[] pos = new int[4];
            token = new StringTokenizer(bf.readLine());
            for (int y = 0; y < 4; y++){
                pos[y] = Integer.parseInt(token.nextToken());
            }
            int result = sum[pos[2]][pos[3]] - sum[pos[2]][pos[1]-1] - sum[pos[0]-1][pos[3]] + sum[pos[0]-1][pos[1]-1];
            System.out.println(result);
        }
    }
}
