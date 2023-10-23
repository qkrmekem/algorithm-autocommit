package programmers;

import java.util.*;

public class Pro_디펜스게임 {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;

        int tmp = 0;
        Queue<Integer> q = new PriorityQueue<>((o1,o2) ->{
            return o2 - o1;
        });
        for(int i = 0; i < enemy.length; i++){
            tmp += enemy[i];
            q.add(enemy[i]);
            if(tmp > n){
                if(k > 0){
                    tmp -= q.poll();
                    k--;
                }else{
                    break;
                }
            }
            answer = i+1;
        }
        return answer;
    }
}
