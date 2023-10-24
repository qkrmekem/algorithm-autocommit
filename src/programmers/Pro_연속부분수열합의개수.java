package programmers;

import java.util.*;

public class Pro_연속부분수열합의개수 {
    public int solution(int[] elements) {
        int answer = 0;
        int cnt = 0;
        Set<Integer> set = new HashSet<>();
        int sum = 0;
        while(cnt < elements.length){
            for(int i = 0; i < elements.length; i++){
                sum = elements[i];
                for(int y = i+1; y <= i+cnt; y++){
                    sum+= elements[y%elements.length];
                }
                set.add(sum);
            }
            cnt++;
        }
        answer = set.size();
        return answer;
    }
}
