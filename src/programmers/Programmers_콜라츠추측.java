package programmers;

public class Programmers_콜라츠추측 {
    public int solution(int num) {
        int answer = 0;

        while(answer < 500){
            if(num == 1){
                return answer;
            }
            answer++;
            if(num % 2 == 0){
                num = num/2;
            }else if(num % 2 == 1){
                num *=3;
                num +=1;
            }
        }

        return -1;
    }
}
