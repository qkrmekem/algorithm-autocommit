package programmers;

import java.util.*;

public class Pro_실패율 {
    public int[] solution(int N, int[] stages) {
        int[] answer = {};

        // 각 스테이지 유저 수
        int[] arr = new int[N+2];
        for(int i = 0; i < stages.length; i++){
            arr[stages[i]]++;
        }

        // 구간합 배열
        int[] sum = new int[N+2];
        // 여기서는 N+1의 위치에 모든 스테이지를 클리어 한 사용자 수가 저장되어 있기 때문에
        // 구간합을 구하기 전에 구간합의 마지막 인덱스에 이 사용자를 미리 저장
        sum[N+1] = arr[N+1];
        // 구간합 구하기
        for(int i = N; i >= 1; i--){
            sum[i] = arr[i]+sum[i+1];
            System.out.print(sum[i]+" ");
        }

        // 실패율 구하기
        Queue<Node> q = new PriorityQueue<>();
        for(int i = 1; i <= N; i++){
            double per = (double)arr[i] / sum[i];
            if(Double.isNaN(per)){
                per = 0;
            }
            q.add(new Node(i,per));
        }

        int[] result = new int[N];
        for(int i = 0; i < N; i++){
            Node now = q.poll();
            result[i] = now.pos;
        }
        return result;
    }


}

class Node implements Comparable<programmers.Node>{
    int pos;
    double per;
    public Node(int pos, double per){
        this.pos = pos;
        this.per = per;
    }
    @Override
    public int compareTo(programmers.Node o){
        if(this.per == o.per){
            return this.pos - o.pos;
        }
        if(this.per > o.per){
            return -1;
        }else{
            return 1;
        }

    }
}


