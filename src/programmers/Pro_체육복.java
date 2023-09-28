package programmers;

import java.util.*;

public class Pro_체육복 {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;

        // cnt라는 변수에 일단 n을 담음
        int cnt = n;

        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 1; i <= n; i++){
            map.put(i,1);
        }

        for(int i = 0; i < lost.length; i++){
            map.put(lost[i], 0);
        }

        for(int i = 0; i < reserve.length; i++){
            map.put(reserve[i], map.get(reserve[i])+1);
        }


        for(int i = 1; i <= n; i++){
            if(map.get(i) == 0){
                if(i > 1 && map.get(i-1) > 1){
                    map.put(i-1, 1);
                    continue;
                }
                if(i < n && map.get(i+1) > 1){
                    map.put(i+1, 1);
                    continue;
                }
                // 처음에는 그냥 n을 이용해 위 조건을 충족하지 않을 때마다 n--연산을 하였음
                // 그런데 이 경우 반복문 조건에서 사용하는 n이 1씩 줄어들어 모든 경우의 수를 탐색하지 않게됨
                // 따라서 처음에 cnt라는 변수를 생성해 n의 값을 담아두고 이 변수를 -1씩 감소시킴
                cnt--;
            }

        }

        return cnt;
    }

    // 다른 풀이
    public int solution2(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;

        Arrays.sort(lost);
        Arrays.sort(reserve);

        // 여벌 체육복을 가져온 학생이 도난당한 경우
        for(int i=0; i<lost.length; i++){
            for(int j=0; j<reserve.length; j++){
                if(lost[i] == reserve[j]){
                    answer++;
                    lost[i] = -1;
                    reserve[j] = -1;
                    break;
                }
            }
        }
        // 도난당한 학생에게 체육복 빌려주는 경우
        for(int i=0; i<lost.length; i++){
            for(int j=0; j<reserve.length; j++){
                if((lost[i]-1 == reserve[j]) || (lost[i]+1 == reserve[j])){
                    answer++;
                    reserve[j] = -1;
                    break;
                }
            }
        }
        return answer;
    }
}

