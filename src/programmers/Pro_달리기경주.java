package programmers;

import java.util.*;

public class Pro_달리기경주 {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> rank = new HashMap<>();
        // 일단 모든 플레이어 정보를 해시맵에 입력
        for(int i = 0; i < players.length; i++){
            rank.put(players[i], i);
        }

        // 순위 변동 사항 추적 시작
        for(String name : callings){
            // 현재 플레이어의 순위
            int cur = rank.get(name);
            // 앞선 플레이어의 순위
            String before = players[cur-1];

            // 앞선 플레이어의 순위와 이전 플레이어의 순위를 바꿈
            players[cur-1] = name;
            players[cur] = before;

            // 해시맵의 플레이어 순위 정보를 갱신
            rank.put(name, cur-1);
            rank.put(before, cur);
        }
        // 시간 초과
        // List<String> tmpList = Arrays.asList(players);
        // for(String name : callings){
        //     int idx = tmpList.indexOf(name);
        //     String tmp = players[idx];
        //     players[idx] = players[idx-1];
        //     players[idx-1] = tmp;
        // }
        String[] answer = players;
        return answer;
    }
}
