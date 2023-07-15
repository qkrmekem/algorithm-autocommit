package programmers;

import java.util.ArrayList;
import java.util.List;

public class Programmers_x만큼간격이있는n개의숫자 {
    public Long[] solution(int x, int n) {
        long[] answer = {};
        List<Long> list = new ArrayList<>();
        Long tmp = 0L;
        for(int i = 0; i < n; i++){
            tmp += x;
            list.add(tmp);
        }
        return list.toArray(new Long[0]);
    }
}
