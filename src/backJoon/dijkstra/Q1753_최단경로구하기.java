package backJoon.dijkstra;

import java.io.*;
import java.util.*;

public class Q1753_최단경로구하기 {

    static int[] results;
    static ArrayList<Node>[] arr;

    static boolean[] visited;
    static PriorityQueue<Node> q = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 노드의 수
        int n = Integer.parseInt(st.nextToken());
        // 에지 수
        int m = Integer.parseInt(st.nextToken());
        // 시작 노드
        int start = Integer.parseInt(br.readLine());
        // 최단 거리를 저장할 배열
        results = new int[n + 1];
        // 방문 여부를 저장할 배열
        visited = new boolean[n + 1];
        // 그래프를 표현하는 배열
        arr = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = new ArrayList<>();
        }

        // 1. 인접리스트로 그래프 구현하기
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            // 시작 노드
            int s = Integer.parseInt(st.nextToken());
            // 도착 노드
            int e = Integer.parseInt(st.nextToken());
            // 가중치
            int v = Integer.parseInt(st.nextToken());
            arr[s].add(new Node(e, v));
        }

        // 2. 최단 거리 배열 초기화하기
        for (int i = 0; i <= n; i++) {
            results[i] = Integer.MAX_VALUE;
        }

        // 3. 값이 가장 작은 노드 고르기(출발 노드 고르기)
        q.add(new Node(start,0));
        results[start] = 0;
        // 5. 모든 노드가 선택될 때까지 반복
        while (!q.isEmpty()) {
            Node now = q.poll();
            int now_node = now.node;
            if (visited[now_node]){
                continue;
            }
            visited[now_node] = true;
            for (int i = 0; i < arr[now_node].size(); i++) {
                Node tmp = arr[now_node].get(i);
                int next = tmp.node;
                int value = tmp.value;
                // 최단 거리 배열 업데이트하기
                // min(현재 노드의 최단 거리값 + 엣지 가중치, 다음 노드의 최단 거리값)
                  // 이렇게 할 경우 다음 노드가 최단 거리이든 아니든 큐에 탐색 대상으로 담음
//                results[next] = Math.min(results[next], results[now_node] + value);
//                q.add(new Node(next, results[next]));
                // 이 경우 최단 노드일 경우에만 큐에 탐색 대상으로 담음
                if (results[next] > results[now_node] + value) {
                    results[next] = value + results[now_node];
                    q.add(new Node(next, results[next]));
                }


            }
        }
        for (int i = 1; i <= n; i++) {
            if (visited[i]) {
                System.out.println(results[i]);
            }else {
                System.out.println("INF");
            }
        }
    }
    static class Node implements Comparable<Node>{
        int node;
        int value;

        public Node(int node, int value) {
            this.node = node;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            if (this.value > o.value) return 1;
            else return -1;
        }
    }
}
