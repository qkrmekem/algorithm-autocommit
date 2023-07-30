package backJoon.dijkstra;

import java.io.*;
import java.util.*;

public class Q1916_최소비용구하기 {

    /*
    * 그래프 초기화
    * 비용 배열 초기화
    * 전 노드 탐색
    *   - 가중치가 낮은 거 먼저 탐색
    *     최소 비용이면 결과배열 업데이트 후 큐에 넣기
    *     그리고 결과 변수에 저장
    * */

    static ArrayList<Node>[] arr;
    static boolean[] visited;
    static int[] result;

    static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        arr = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        result = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            result[i] = Integer.MAX_VALUE;
        }

        for (int i = 1; i <= n; i++) {
            arr[i] = new ArrayList<>();
        }

        // 그래프 초기화
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            arr[s].add(new Node(e, v));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        // 탐색 시작
        Queue<Node> q = new PriorityQueue<>();
        q.add(new Node(start, 0));
        result[start] = 0;
        while (!q.isEmpty()) {
            Node nowNode = q.poll();
            int now = nowNode.dest;
            if (!visited[now]) {
                visited[now] = true;
                for (Node nextNode : arr[now]) {
                    int next = nextNode.dest;
                    int value = nextNode.value;
                    if (result[next] > result[now] + value){
                        result[next] = result[now] + value;
                        q.add(new Node(next, result[now] + value));
                    }
                }
            }

        }
        System.out.println(result[end]);
    }

    static class Node implements Comparable<Node>{
        int dest;
        int value;

        public Node(int dest, int value) {
            this.dest = dest;
            this.value = value;
        }

        public int compareTo(Node o){
            return this.value - o.value;
        }
    }
}
