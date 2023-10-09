package programmers;

import java.util.*;

public class Pro_문자열내림차순정렬하기 {

    public String solution(String s) {
        String answer = "";
        String[] arr= s.split("");
        // Collections.reverseOrder()를 인자로 전달하거나
        // Comparator를 직접 구현해줘야함
        Arrays.sort(arr,Collections.reverseOrder());
        for(String str: arr){
            answer+=str;
        }
        return answer;
    }
}
