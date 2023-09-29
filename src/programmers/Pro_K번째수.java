package programmers;

import java.util.*;

public class Pro_K번째수 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int[] tmp = {};
        for(int y = 0; y < commands.length; y++){
            int pos = 0;

            // 임시 배열
            tmp = new int[commands[y][1] - commands[y][0] + 1];
            for(int i = commands[y][0]-1; i <= commands[y][1]-1; i++){
                tmp[pos] = array[i];
                pos++;

                // i~j의 길이가 array보다 길 경우에 대비
                if(pos == commands[y][1]){
                    break;
                }
            }
            Arrays.sort(tmp);
            answer[y] = tmp[commands[y][2]-1];
        }

        return answer;
    }
}
