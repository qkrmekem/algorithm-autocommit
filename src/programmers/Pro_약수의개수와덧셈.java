package programmers;

public class Pro_약수의개수와덧셈 {
    public int solution(int left, int right) {
        int answer = 0;
        for(int i = left; i <= right; i++){
            int cnt = 0;
            // 약수의 개수를 구하는 로직
            // 이 부분 기억하기!
            for(int y = 1; y*y <= i; y++ ){
                if(y*y == i){
                    cnt++;
                }else if(i % y == 0){
                    cnt+=2;
                }
            }
            if(cnt % 2 == 0){
                answer += i;
            }else{
                answer -= i;
            }
        }

        return answer;
    }
}
