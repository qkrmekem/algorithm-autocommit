package backJoon;

import java.io.*;
import java.util.*;

public class Q1948_임계경로 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<cNode>[] arr = new ArrayList[n + 1];
        ArrayList<cNode>[] reverse = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = new ArrayList<>();
            reverse[i] = new ArrayList<>();
        }

        int[] edge = new int[n + 1];
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int tmp = Integer.parseInt(st.nextToken());
            arr[s].add(new cNode(e,tmp));
            reverse[e].add(new cNode(s,tmp));
            edge[e]++;
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        // 먼저 위상 정렬을 진행해줌
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        int[] result = new int[n + 1];
        while (!q.isEmpty()) {
            int now = q.poll();
            for (cNode next : arr[now]) {
                edge[next.target]--;
                // 노드에 도착하는 소요시간 중 최대 값을 저장
                result[next.target] = Math.max(result[next.target], result[now] + next.value);
                if (edge[next.target] == 0) {
                    q.add(next.target);
                }
            }
        }

        // 엣지 뒤집기
        int cnt = 0;
        // 1분도 쉬지 않고 달린다는 것은
        // 현재 노드의 임계경로 값 == 이전 노드의 임계경로 값 + 현재 노드 도달 소요시간
        // 위의 조건이 성립되어야 하는데,
        // 이 조건을 만족하는 진입 차수가 둘 이상일 수 있으므로
        // 노드를 접근했는지 확인이 필요함
        boolean visited[] = new boolean[n + 1];
        q = new LinkedList<>();
        q.add(end);
        visited[end] = true;
        while (!q.isEmpty()) {
            // 여기서 now는 도착 도시
            int now = q.poll();
            // 여기서 next는 출발 도시
            for (cNode next : reverse[now]) {
                // 출발 노드의 임계값 + 출발 노드의 value == 도착 노드의 임계값
                if (result[next.target] + next.value == result[now]) {
                    // 1분도 쉬지 않았다는 뜻이므로 cnt + 1
                    cnt++;
                    // 출발 노드가 겹칠 수 있으므로 중복 체크
                    if (visited[next.target] == false) {
                        // 방문 기록을 남기고 출발 노드를 큐에 삽입
                        visited[next.target] = true;
                        q.add(next.target);
                    }
                }
            }
        }
        System.out.println(result[end]);
        System.out.println(cnt);
    }
}

class cNode{
    int target;
    int value;

    public cNode(int next, int value) {
        this.target = next;
        this.value = value;
    }

}
