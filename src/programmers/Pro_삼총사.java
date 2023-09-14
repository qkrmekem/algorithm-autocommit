package programmers;

public class Pro_삼총사 {
    public int solution(int[] number) {
        int answer = 0;
        for(int i = 0; i < number.length-2; i++){
            for(int y = i+1; y < number.length-1; y++){
                for(int z = y+1; z < number.length; z++){
                    if(number[i] + number[y] + number[z] == 0){
                        answer++;
                    }
                }
            }
        }
        return answer;
    }
}
