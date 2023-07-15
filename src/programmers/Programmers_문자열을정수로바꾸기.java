package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Programmers_문자열을정수로바꾸기 {
    public int solution(String s) {
        int answer = 0;

        if(s.charAt(0) == '+'){
            answer = Integer.parseInt(s.replace("+",""));
        }else if(s.charAt(0) == '-'){
            answer = Integer.parseInt(s.replace("-",""))*-1;
        }else{
            answer = Integer.parseInt(s);
        }
        return answer;
    }
}
