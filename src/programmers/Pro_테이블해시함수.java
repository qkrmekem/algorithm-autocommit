package programmers;

import java.util.*;

public class Pro_테이블해시함수 {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        Arrays.sort(data,(o1,o2) -> {
            if(o1[col-1] == o2[col-1]){
                return o2[0] - o1[0];
            }
            return o1[col-1]-o2[col-1];
        });
        for(int i = row_begin - 1; i <= row_end - 1; i++){
            int S_i = 0;
            for(int num : data[i]){
                // 컬럼(인덱스)의 값을 나누는 것이므로 +1을 해서 나머지 연산을 해줌
                S_i += num % (i+1);
            }
            answer = answer ^ S_i;
        }
        return answer;
    }
}
