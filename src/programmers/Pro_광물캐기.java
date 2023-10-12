package programmers;

import java.util.*;

public class Pro_광물캐기 {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int cnt = picks[0] + picks[1] + picks[2];
        int last;
        if(cnt*5 > minerals.length){
            last = minerals.length;
        }else{
            last = cnt*5;
        }

        Queue<Node> q = new PriorityQueue<>();



        Node now = new Node(0,0,0);
        int sum = 0;
        for(int i = 0; i < last; i++){
            if(i%5 == 0){
                now = new Node(i,0,0);
                sum = 0;
            }
            if(minerals[i].equals("diamond")){
                sum+=25;
            }else if(minerals[i].equals("iron")){
                sum+=5;
            }else{
                sum+=1;
            }
            if((i+1)%5 == 0 || i+1 == last){
                now.e = i;
                now.sum = sum;
                q.add(now);
            }
        }
        // System.out.println(q.size());

        while(!q.isEmpty()){
            String tool = "";
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
            now = q.poll();
            System.out.println(now.s);
            for(int i = now.s; i <= now.e; i++){
                if(tool.equals("diamond")){
                    answer+=1;
                }else if(tool.equals("iron")){
                    if(minerals[i].equals("diamond")){
                        answer+=5;
                    }else{
                        answer+=1;
                    }
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