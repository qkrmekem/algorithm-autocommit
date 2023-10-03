package programmers;

import java.util.*;

public class Pro_예산 {
    public int solution(int[] d, int budget) {
        int answer = 0;

        Arrays.sort(d);

        for(int i = 0; i < d.length; i++){
            int now = d[i];
            if(now <= budget){
                answer++;
                budget -= now;
            }else{
                break;
            }
        }

        return answer;
    }
}
