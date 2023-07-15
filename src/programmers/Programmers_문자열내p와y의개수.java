package programmers;

public class Programmers_문자열내p와y의개수 {
    boolean solution(String s) {
        boolean answer = true;

        int cnt = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'p' || s.charAt(i) == 'P'){
                cnt++;
            }else if(s.charAt(i) == 'y' || s.charAt(i) == 'Y'){
                cnt--;
            }
        }

        if(cnt != 0){
            answer = false;
        }

        return answer;
    }
}
