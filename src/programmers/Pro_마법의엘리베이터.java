package programmers;

public class Pro_마법의엘리베이터 {
    public int solution(int storey) {
        int answer = 0;
        while(storey != 0){
            System.out.println(storey);
            int nam = storey%10;
            int next = (storey%100)/10;
            storey/=10;
            if(nam > 5){
                answer += (10-nam);
                if(storey == 0)answer++;
                else storey++;
            }else if(nam == 5 && next >= 5 && storey != 0){
                storey++;
                answer += 5;
            }else{
                answer += nam;
            }
        }
        return answer;
    }
}
