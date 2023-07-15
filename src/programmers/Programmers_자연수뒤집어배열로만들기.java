package programmers;

import java.util.*;

public class Programmers_자연수뒤집어배열로만들기 {
    public Long[] solution(long n) {
        int[] answer = {};

        List<Long> list = new ArrayList<>();
        while(n>0){
            list.add(n%10);
            n/=10;
        }
        // Collections.reverse(list);

        return list.toArray(new Long[0]);
    }
}
