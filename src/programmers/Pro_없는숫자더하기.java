package programmers;

public class Pro_없는숫자더하기 {
    public int solution(int[] numbers) {
        int answer = 0;
        boolean[] chk = new boolean[10];
        for(int i = 0; i < numbers.length; i++){
            chk[numbers[i]] = true;
        }
        for(int i = 0; i < chk.length; i++){
            if(!chk[i]){
                answer+=i;
            }
        }
        return answer;
    }
}
