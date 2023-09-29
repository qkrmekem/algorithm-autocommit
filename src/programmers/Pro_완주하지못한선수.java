package programmers;

import java.util.*;

public class Pro_완주하지못한선수 {
    // 해시맵 풀이
    // entry 사용
    public String solution(String[] participant, String[] completion) {
        String answer ="";
        Map<String, Integer> map = new HashMap<>();
        for(String name:participant){
            map.put(name,map.getOrDefault(name,0)+1);
        }
        for(String name:completion){
            map.put(name,map.get(name)-1);
        }

        Iterator<Map.Entry<String,Integer>> iter = map.entrySet().iterator();

        while(iter.hasNext()){
            Map.Entry<String, Integer> entry = iter.next();
            if(entry.getValue() != 0){
                answer = entry.getKey();
                break;
            }
        }
        return answer;
    }

    // Arrays.sort() 사용 풀이

    // public String solution(String[] participant, String[] completion) {
    //     Arrays.sort(participant);
    //     Arrays.sort(completion);
    //     for(int i = 0; i < completion.length; i++){
    //         if(!participant[i].equals(completion[i])){
    //             return participant[i];
    //         }
    //     }
    //     return participant[participant.length-1];
    // }

    // 내 풀이
    // 효율성 테스트 실패

//     public String solution(String[] participant, String[] completion) {
//         String answer = "";
//         Map<String, Integer> par = new HashMap<>();
//         Set<String> set = new HashSet<>();
//         for(int i = 0; i < participant.length; i++){
//             Integer tmp = par.getOrDefault(participant[i], -1);
//             if(tmp == -1){
//                 par.put(participant[i], 1);
//                 set.add(participant[i]);
//                 continue;
//             }
//             par.put(participant[i],tmp+1);
//             System.out.println(participant[i] + "  " + tmp);
//         }

//         Map<String, Integer> com = new HashMap<>();
//         for(int i = 0; i < completion.length; i++){
//             Integer tmp = com.getOrDefault(completion[i], -1);
//             if(tmp == -1){
//                 com.put(completion[i], 1);
//                 continue;
//             }
//             com.put(completion[i],tmp+1);
//         }


//         Iterator<String> iter = set.iterator();
//         while(iter.hasNext()){
//             String name = iter.next();
//             Integer a = par.get(name);
//             Integer b = com.get(name);
//             if(a!=b){
//                 answer = name;
//                 break;
//             }
//         }
//         return answer;
//     }
}
