package programmers;

import java.util.*;

public class Pro_요격시스템 {
    public int solution(int[][] targets) {
        Arrays.sort(targets, (a,b) ->{
            if(a[1] == b[1]){
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });
        int point = -1;
        int cnt = 0;
        for(int i = 0; i < targets.length; i++){
            int left = targets[i][0];
            int right = targets[i][1];
            if(left >= point){
                cnt++;
                point = right;
            }
        }
        return cnt;
    }
}
