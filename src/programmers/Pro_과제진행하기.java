package programmers;

import java.util.Arrays;
import java.util.Stack;

public class Pro_과제진행하기 {

    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];

        Stack<String[]> stop = new Stack<>();

        Arrays.sort(plans,(a, b)->ToSec(a[1])-(ToSec(b[1])));


        int size = plans.length;

        // answer의 인덱스를 가리킬 변수
        int z=0;
        // plans의 인덱스를 가리킬 변수
        int idx=0;
        // 현재 과제의 소요시간(시작시간+소요시간)
        int current=0;
        // 과제의 이름
        String type ="";
        // 과제의 시작 시간
        int time =0;
        // 과제의 소요 시간
        int period =0;
        // 다음과제의 소요시간
        int next=0;
        // 일단 plans를 모두 탐색
        while(size!=idx){

            // 현재 과제의 이름, 시작시간, 소요시간
            type=plans[idx][0];
            time = ToSec(plans[idx][1]);
            period = Integer.parseInt(plans[idx][2]);

            // 현재 과제의 완료시간
            current=time+period;

            // 새로운 과제가 있을 때
            if(size-1!=idx){
                // 다음 과제의 시작시간 체크
                next = ToSec(plans[idx+1][1]);
                // 현재 과제를 마무리하지 못하면
                if(current>next){
                    // 현재 과제는 미뤄두기
                    // 이 때 잔여시간 계산
                    stop.push(new String[]{type,current-next+""});
                    // 다음 과제 시간을 현재 과제 시작시간으로 변경
                    current=next;
                    // plans의 인덱스 1증가
                    idx++;
                    continue;

                }
            }

            //지금 과제 완료
            answer[z++]=type;

            // 남은시간동안 멈춘 과제를 할수있을까?
            while(!stop.isEmpty()){

                // 현재 과제 완료 시간부터 다음 과제를 시작하기 전까지 남은 시간 계산
                int remain = next-current;

                String[] work = stop.pop();

                // 멈춘 과제의 남은 시간 체크
                int re_p =Integer.parseInt(work[1]);

                //멈춘과제 완료될 때
                if(remain>=re_p){

                    answer[z++]=work[0];
                    current+=re_p;
                    //과제를 또 멈춰야할때
                }else{
                    stop.push(new String[]{work[0],re_p-remain+""});
                    break;
                }
            }
            idx++;
        }

        //모든 과제를 탐색했으므로 남은 과제를 처리
        while(!stop.isEmpty()){
            answer[z++]=stop.pop()[0];
        }

        return answer;
    }

    // 시간을 편하게 계산하기 위한 메서드
    public int ToSec (String time){

        String[] t = time.split(":");
        int h =Integer.parseInt(t[0])*60;
        int m =Integer.parseInt(t[1]);

        return h+m;
    }

//     내가 풀이한 것
//     큐를 돌릴 때 현재 시간이 남았을 때
//     이전에 끝내지 못한 과제를 처리하는 경우의 수를 누락
//     public String[] solution(String[][] plans) {
//         Queue<Node> q = new PriorityQueue<>();
//         Stack<Node> stack = new Stack<>();
//         String[] now;
//         int point = 0;
//         List<String> arr = new ArrayList<>();
//         String[] result = new String[plans.length];
//         int pos = 0;
//         for(int i = 0; i < plans.length; i++){
//             now = plans[i];
//             String name = now[0];
//             int hour = Integer.parseInt(now[1].split(":")[0]);
//             int minute = Integer.parseInt(now[1].split(":")[1]);
//             int total = Integer.parseInt(now[2]);
//             q.add(new Node(name, hour, minute,total));
//         }
//         while(!q.isEmpty()){
//             Node cur = q.poll();
//             int hour = cur.hour;
//             int minute = cur.minute;
//             int total = cur.total;
//             int tmp = minute + total;
//             hour += tmp/60;
//             minute = tmp%60;
//             Node next = q.peek();
//             if(next == null){
//                 result[pos++] = cur.name;
//                 continue;
//             // }else if(cur.hour <= next.hour && cur.minute <= next.minute){
//             }
//             tmp = (hour * 100) + minute;

//             if(tmp <= (next.hour*100)+next.minute){
//                 result[pos++] = cur.name;
//             }else{
//                 stack.push(cur);
//             }
//         }
//         while(!stack.isEmpty()){
//             Node cur = stack.pop();
//             result[pos++] = cur.name;
//         }
//         return result;
//     }
}

class Node implements Comparable<Node>{
    String name;
    int hour;
    int minute;
    int total;

    public Node(String name, int hour, int minute, int total){
        this.name = name;
        this.hour = hour;
        this.minute = minute;
        this.total = total;
    }

    public int compareTo(Node o){
        if(this.hour == o.hour){
            return this.minute - o.minute;
        }
        return this.hour - o.hour;
    }
}
