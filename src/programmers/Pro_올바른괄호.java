package programmers;

public class Pro_올바른괄호 {
    boolean solution(String s) {
        boolean answer = true;

        int open = 0;
        int close = 0;

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                open++;
            }else{
                close++;
                if(close > open){
                    answer = false;
                    break;
                }
            }
        }

        if(open > close){
            answer = false;
        }

        return answer;
    }
}
