package programmers;

import java.util.*;
public class Pro_명예의전당 {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];

        List<Integer> arr = new ArrayList<>();
        for(int i=0;i<score.length;i++ ){
            if(arr.size() < k){
                arr.add(score[i]);
                Collections.sort(arr);
                answer[i] = arr.get(0);
                continue;
            }
            if(arr.get(0) < score[i]){
                arr.remove(0);
                arr.add(score[i]);
                Collections.sort(arr);
            }
            answer[i] = arr.get(0);
        }
        return answer;
    }
}
