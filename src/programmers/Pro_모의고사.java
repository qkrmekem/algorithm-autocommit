package programmers;

import java.util.*;

public class Pro_모의고사 {
    public Integer[] solution(int[] answers) {
        int[] answer = {};
        int[] one = {1,2,3,4,5};
        int[] two = {2,1,2,3,2,4,2,5};
        int[] three = {3,3,1,1,2,2,4,4,5,5};

        // System.out.println(1%one.length);

        // 우선순위큐에 담아 최대값을 구함
        Queue<Node> q = new PriorityQueue<>();
        // 각 학생을 Node라는 클래스로 정의
        Node fir = new Node(1,0);
        Node sec = new Node(2,0);
        Node thd = new Node(3,0);

        // 0을 나머지 연산을 해버리면 예외가 발생하므로 0번 인덱스만 따로 처리
        // 학생의 답안지와 정답이 일치할 경우 점수 +1
        if(one[0] == answers[0]){
            fir.cnt++;
        }

        if(two[0] == answers[0]){
            sec.cnt++;
        }

        if(three[0] == answers[0]){
            thd.cnt++;
        }

        for(int i = 1; i < answers.length; i++){
            // 학생들이 찍은 번호의 패턴마다 길이가 달라
            // i를 각 패턴의 길이로 남은 나머지를 이용해 각 패턴의 인덱스를 구함
            if(one[i%one.length] == answers[i]){
                fir.cnt++;
            }
            if(two[i%two.length] == answers[i]){
                sec.cnt++;
            }
            if(three[i%three.length] == answers[i]){
                thd.cnt++;
            }

        }

        // 노드를 우선순위 큐에 담음
        q.add(fir);
        q.add(sec);
        q.add(thd);

        // 처음으로 나오는 노드가 점수가 최대인 학생을 뜻함
        Node maxNode = q.poll();
        // 최고점을 받은 학생의 점수를 max에 저장
        int max = maxNode.cnt;

        // 최고점을 받은 학생의 수를 지금은 모르므로 ArrayList를 이용
        List<Integer> arr = new ArrayList<>();
        arr.add(maxNode.pos);

        // 큐가 비워질 때까지 반복
        while(!q.isEmpty()){
            // 큐에서 꺼낸 학생의 점수와 최대 점수가 같다면 리스트에 추가해줌
            Node now = q.poll();
            if(now.cnt == max){
                arr.add(now.pos);
            }
        }

        // 리스트를 Integer형 배열로 반환
        // 따라서 메서드의 반환 타입도 Integer형 배열로 바꿔야함
        return arr.toArray(new Integer[0]);
    }

    // 다른 사람의 풀이
    public int[] solution2(int[] answer) {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] score = new int[3];
        for(int i=0; i<answer.length; i++) {
            if(answer[i] == a[i%a.length]) {score[0]++;}
            if(answer[i] == b[i%b.length]) {score[1]++;}
            if(answer[i] == c[i%c.length]) {score[2]++;}
        }
        int maxScore = Math.max(score[0], Math.max(score[1], score[2]));
        ArrayList<Integer> list = new ArrayList<>();
        if(maxScore == score[0]) {list.add(1);}
        if(maxScore == score[1]) {list.add(2);}
        if(maxScore == score[2]) {list.add(3);}
        return list.stream().mapToInt(i->i.intValue()).toArray();
    }

    class Node implements Comparable<Node>{
        // 학생 번호
        int pos;
        // 점수
        int cnt;
        public Node(int pos, int cnt){
            this.pos = pos;
            this.cnt = cnt;
        }
        public int compareTo(Node o){
            // 만약 점수가 같다면
            if(this.cnt == o.cnt){
                // 번호를 기준으로 오름차순 정렬
                return this.pos - o.pos;
            }
            // 다르다면 점수를 기준으로 내림차순 정렬
            return o.cnt - this.cnt;
        }
    }
}


