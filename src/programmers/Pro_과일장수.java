package programmers;

import java.util.Arrays;

public class Pro_과일장수 {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        int pos = score.length - m;
        Arrays.sort(score);
        while(pos>=0){
            answer+= score[pos]*m;
            pos-=m;
        }
        return answer;
    }
}
