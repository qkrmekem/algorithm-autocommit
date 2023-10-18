package programmers;

public class Pro_마법의엘리베이터 {
    public int solution(int storey) {
        int answer = 0;

        // 층 수 계산은 1의자리 숫자로 시작해 주어진 수의 자리수까지 순서로 계산
        while(storey != 0){
            // 현재 숫자
            int nam = storey%10;
            // 다음 숫자
            int next = (storey%100)/10;

            storey/=10;

            // 현재 숫자가 5보다 클 때
            if(nam > 5){
                // 10을 더하고 거기서 나머지를 빼는게 더 빠름
                answer += (10-nam);
                // 현재 숫자가 마지막 숫자일 때
                if(storey == 0)answer++;
                else storey++;
            // 현재 숫자가 5인데 다음 숫자가 4미만일때
            // 예를들어 주어진 수가 450일때
            // 현재 숫자가 5라면 더하든 빼든 그 숫자 자체는 상관없는데
            // 다음 수가 4이므로 현재 숫자 5에서 5를 올려버리면
            // 500이 되어버려 5번의 연산을 해야한다
            // 반면에 현재 숫자 5에서 5를 빼버리면
            // 400이 되므로 4번의 연산만 하면 0층을 만들 수 있으므로
            // 5가 나왔을 경우에는 다음 숫자까지 고려해야 한다.
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
