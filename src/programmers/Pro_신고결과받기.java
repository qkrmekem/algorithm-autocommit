package programmers;

import java.util.*;

public class Pro_신고결과받기 {
    public int[] solution(String[] id_list, String[] report, int k) {

        int[] answer = new int[id_list.length];

        // 각 아이디의 위치
        Map<String, Integer> map = new HashMap<>();
        // 신고당한 사람과 신고자 명단 저장
        Map<String, Set> reports = new HashMap<>();
        for(int i = 0; i < id_list.length; i++){
            map.put(id_list[i], i);
            reports.put(id_list[i], new HashSet<String>());
        }


        for(int i = 0; i < report.length; i++){
            String by = report[i].split(" ")[0];
            String to = report[i].split(" ")[1];
            Set<String> list = reports.get(to);
            list.add(by);
        }

        for(int i = 0; i < id_list.length; i++){
            Set<String> list = reports.get(id_list[i]);
            if(list.size() >= k){
                Iterator<String> iter = list.iterator();
                while(iter.hasNext()){
                    int pos = map.get(iter.next());
                    answer[pos]++;
                }
            }
        }


        return answer;
    }
}
