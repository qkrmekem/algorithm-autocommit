package programmers;

public class Pro_부족한금액계산하기 {
    public long solution(int price, int money, int count) {
        long answer = -1;
        long tmp = 0;
        for(int i = 1; i <= count; i++){
            tmp += (price*i);
        }
        answer = money - tmp;
        if(answer > 0){
            answer = 0;
        }else{
            answer = answer*-1;
        }
        return answer;
    }
}
