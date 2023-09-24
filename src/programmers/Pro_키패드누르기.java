package programmers;

import java.util.*;

public class Pro_키패드누르기 {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        // 왼쪽 엄지손가락, 오른쪽 엄지손가락 위치 초기화
        Pos lp = new Pos(4,1);
        Pos rp = new Pos(4,3);

        // 각 번호의 위치 초기화
        Map<Integer, Pos> map = new HashMap<>();
        map.put(1, new Pos(1,1));
        map.put(2, new Pos(1,2));
        map.put(3, new Pos(1,3));
        map.put(4, new Pos(2,1));
        map.put(5, new Pos(2,2));
        map.put(6, new Pos(2,3));
        map.put(7, new Pos(3,1));
        map.put(8, new Pos(3,2));
        map.put(9, new Pos(3,3));
        map.put(0, new Pos(4,2));

        // 번호 누르기 시작
        for(int i = 0; i < numbers.length; i++){
            // 번호가 1,4,7일때는 왼손으로 누르기
            if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7){
                answer += "L";
                lp = map.get(numbers[i]);
            // 번호가 3,6,9일때는 오른손으로 누르기
            }else if(numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9){
                answer += "R";
                rp = map.get(numbers[i]);
            // 번호가 2,5,8,0일때
            }else{
                // 현재 번호의 위치 가져오기
                Pos now = map.get(numbers[i]);

                // 왼손의 위치와 현재 위치의 거리값 계산
                int tmpl = (Math.max(lp.x, now.x) - Math.min(lp.x, now.x)) +
                        (Math.max(lp.y, now.y) - Math.min(lp.y, now.y));
                // 오른손의 위치와 현재 위치의 거리값 계산
                int tmpr = (Math.max(rp.x, now.x) - Math.min(rp.x, now.x)) +
                        (Math.max(rp.y, now.y) - Math.min(rp.y, now.y));

                // 왼손이 더 가까울 때
                if(tmpl < tmpr){
                    answer += "L";
                    lp = now;
                // 오른손이 더 가까울 때
                }else if(tmpl > tmpr){
                    answer += "R";
                    rp = now;
                // 거리가 같을 때
                }else{
                    if(hand.equals("left")){
                        answer += "L";
                        lp = now;
                    }else{
                        answer += "R";
                        rp = now;
                    }
                }
            }

        }
        return answer;
    }
    // 번호의 위치를 저장하기 위한 클래스
    class Pos{
        int x;
        int y;
        public Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}


