package programmers;

import java.util.*;

public class Pro_시소짝궁 {
    public long solution(int[] weights) {
        long answer = 0;
        Map<Integer, Long> map = new HashMap<>();
        int cnt = 0;
        for(int i = 0; i < weights.length; i++){
            Long now = map.getOrDefault(weights[i], 0L);
            map.put(weights[i], ++now);
        }
        Integer[] arr = map.keySet().toArray(new Integer[0]);
        Arrays.sort(arr);
        for(int i = 0; i < arr.length; i++){
            Long now = map.get(arr[i]);
            answer += (now*(now-1))/2;

            for(int y = i+1; y < arr.length; y++){
                Long next = map.get(arr[y]);
                if(arr[i] * 2 == arr[y] * 2){
                    answer+=now*next;
                }else if(arr[i] * 3 == arr[y] * 2){
                    answer+=now*next;
                }else if(arr[i] * 4 == arr[y] * 2){
                    answer+=now*next;
                }else if(arr[i] * 4 == arr[y] * 3){
                    answer+=now*next;
                }
            }
        }
        return answer;
    }

    // 다른 사람 풀이
    public long solution2(int[] weights) {
        HashMap<Double, Integer> map = new HashMap();
        Arrays.sort(weights);
        long cnt = 0;
        for(int w : weights){
            // 현재 weights는 오름차순으로 정렬된 상태이므로
            // 이후의 값들은 현재 w의 값보다 크거나 같음
            // 그래서 배열에서 처음으로 나오는 값은 아직 쌍을 이루는 값들이 없으므로
            // 아래의 if문은 모두 무시하고 일단 map에 몸무게와 인원수를 누적함
            // 그 이후에는 맵에 w와 쌍을 이룰 수 있는 사람이 있으면 맵에 누적된 값을 정답 변수 cnt에 누적함
            // 예를 들어 쌍을 이룰 수 있는 개수는
            // 2개일때 1쌍
            // 3개일때 1+2=3쌍
            // 4개일때 1+2+3=6쌍이 되므로
            // map에는 각 몸무게에 해당하는 인원수를 누적해주고
            // 다시 cnt에는 map에 쌍을 이룰 수 있는 몸무게를 가진 사람의 개수를 누적해주면 됨
            if(map.containsKey(  (1.0/2)*w)){
//                System.out.println(((1.0/2)*w));
                cnt += map.get((1.0/2)*w);
            }
            if(map.containsKey ( (3.0/4)*w )){
//                System.out.println(  ((3.0/4)*w ));
                cnt+= map.get((3.0/4)*w);
            }
            if(map.containsKey( (2.0/3)*w)){
//                System.out.println(  ((2.0/3)*w));
                cnt += map.get( (2.0/3)*w);
            }
            if(map.containsKey((1.0)*w)){
//                System.out.println(  ((1.0)*w));
                cnt += map.get((1.0)*w);
            }
            int cur = map.getOrDefault(1.0 * w, 0);
            map.put(1.0*w,cur+1);
        }
        return cnt;
    }
}
