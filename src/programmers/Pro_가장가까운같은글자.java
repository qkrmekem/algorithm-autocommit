package programmers;

import java.util.HashMap;
import java.util.Map;

public class Pro_가장가까운같은글자 {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        Map<Character, Integer> map = new HashMap<>();
        char[] arr = s.toCharArray();
        for(int i = 0; i < arr.length; i++){
            Integer pos = map.get(arr[i]);
            if(pos == null){
                map.put(arr[i],i);
                answer[i] = -1;
                continue;
            }
            answer[i] = i-pos;
            map.put(arr[i],i);
        }
        return answer;
    }
}
