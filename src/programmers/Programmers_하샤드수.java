package programmers;

public class Programmers_하샤드수 {
    public boolean solution(int x) {
        boolean answer = true;
        int tmp = x;
        int cnt = 0;
        while(tmp > 0){
            cnt += tmp % 10;
            tmp /= 10;
        }
        if(x%cnt == 0){
            answer = true;
        }else{
            answer = false;
        }
        return answer;
    }
}
