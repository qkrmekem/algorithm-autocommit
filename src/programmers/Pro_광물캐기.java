package programmers;

import java.util.*;

public class Pro_광물캐기 {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int cnt = picks[0] + picks[1] + picks[2];
        int last;
        // 최대로 캘 수 있는 광물 계산
        if(cnt*5 > minerals.length){
            last = minerals.length;
        }else{
            last = cnt*5;
        }

        Queue<Node> q = new PriorityQueue<>();
        Node now = new Node(0,0,0);

        // while문
        // int tmp = last/5;
        // if(last%5!=0){
        //     tmp++;
        // }
        // int group = 0;
        // while(group < tmp){
        //     int start = 5*group;
        //     int end = start + 4;
        //     if(end > last-1){
        //         end = last-1;
        //     }
        //     now = new Node(start, end, 0);
        //     for(int i = start; i <= end; i++){
        //         if(minerals[i].equals("diamond")){
        //             now.sum+=25;
        //         }else if(minerals[i].equals("iron")){
        //             now.sum+=5;
        //         }else{
        //             now.sum+=1;
        //         }
        //     }
        //     q.add(now);
        //     group++;
        // }

        int sum = 0; // 임시로 각 그룹의 누적합을 저장할 변수
        for(int i = 0; i < last; i++){
            // 각 그룹의 처음 인덱스에서 Node 생성
            if(i%5 == 0){
                now = new Node(i,0,0);
                sum = 0;
            }
            // 현재 인덱스의 종류에 따라 누적합 sum에 값 누적
            // diamond는 25
            // iron은 5
            // stone은 1로 고정
            if(minerals[i].equals("diamond")){
                sum+=25;
            }else if(minerals[i].equals("iron")){
                sum+=5;
            }else{
                sum+=1;
            }
            // 각 그룹의 마지막 인덱스에서는 Node를 우선순위 큐에 담아줌
            if((i+1)%5 == 0 || i+1 == last){
                now.e = i;
                now.sum = sum;
                q.add(now);
            }
        }
        // System.out.println(q.size());

        // 우선순위큐에서 하나씩 꺼내 피로도 계산
        while(!q.isEmpty()){
            // 각 그룹에 사용할 곡괭이 선택
            String tool = "";
            // 다이아몬드부터 돌 곡괭이 순서로 남아있는것을 선택
            if(picks[0] > 0){
                tool = "diamond";
                picks[0]--;
            }else if(picks[1]>0){
                tool = "iron";
                picks[1]--;
            }else{
                tool = "stone";
                picks[2]--;
            }
            // 우선순위큐의 최상단 그룹 꺼내오기
            now = q.poll();
            // System.out.println(now.s);
            // 각 그룹을 돌며 피로도 계산
            for(int i = now.s; i <= now.e; i++){
                // 현재 사용하고 있는 곡괭이가 다이아몬드 곡괭이일 때
                if(tool.equals("diamond")){
                    answer+=1;
                // 현재 사용하고 있는 곡괭이가 철 곡괭이일 때
                }else if(tool.equals("iron")){
                    if(minerals[i].equals("diamond")){
                        answer+=5;
                    }else{
                        answer+=1;
                    }
                // 현재 사용하고 있는 곡괭이가 돌 곡괭이일 때
                }else{
                    if(minerals[i].equals("diamond")){
                        answer+=25;
                    }else if(minerals[i].equals("iron")){
                        answer+=5;
                    }else{
                        answer+=1;
                    }
                }
            }
        }

        return answer;
    }

    class Node implements Comparable<Node>{
        int s;
        int e;
        int sum;
        public Node(int s, int e, int sum){
            this.s = s;
            this.e = e;
            this.sum = sum;
        }

        public int compareTo(Node o){
            return o.sum - this.sum;
        }
    }
}