package programmers;

public class Programmers_정수제곱근판별 {
    public long solution(long n) {
        long answer = 0;

        if((long)Math.pow((long)Math.sqrt(n),2) == n){
            answer = (long)Math.pow((long)Math.sqrt(n)+1,2);
        }else{
            answer = -1;
        }

        return answer;
    }
}
