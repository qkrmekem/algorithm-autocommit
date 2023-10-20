package programmers;

public class Pro_택배배달과수거 {

    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int del = 0;
        int pick = 0;
        // 맨 마지막 집부터 시작
        for (int i = n-1; i >= 0; i--) {
            // 만약 현재 집에 배달이나 수거를 할 상자가 있다면
            if (deliveries[i] > 0 || pickups[i] > 0) {
                // 현재 집에 방문해야할 횟수를 누적할 변수
                int cnt = 0;
                // 배달,수거 상자 개수가 현재 집의 배달,수거 개수보다 커질때까지 반복
                // 이건 현재 집에 방문해야 하는 횟수를 측정하기 위함임
                while (del < deliveries[i] || pick < pickups[i]) {
                    // 현재 집 방문 횟수 카운트
                    cnt++;
                    // 현재 집에 배달,수거 가능한 상자의 개수를 누적
                    // 한번의 방문당 배달, 수거 가능한 최대 개수는 cap만큼 가능
                    del += cap;
                    pick += cap;
                }
                // 현재 집에 배달,수거를 한 이후
                // 물류센터로 돌아가지 않고 추가로 배달,수거를 할 수 있는 상자의 개수를 측정
                del -= deliveries[i];  //남은 트럭 자리 계산
                pick -= pickups[i];
                // 이동거리 계산
                answer += (i+1) * cnt * 2;
            }
        }
        return answer;
    }
}
