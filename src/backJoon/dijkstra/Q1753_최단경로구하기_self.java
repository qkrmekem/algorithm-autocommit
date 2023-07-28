package backJoon.dijkstra;

import java.io.*;
import java.util.*;

public class Q1753_최단경로구하기_self {

    static ArrayList<Node>[] arr;
    static int[] results;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());
        arr = new ArrayList[n + 1];
        results = new int[n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = new ArrayList<>();
        }

        // 그래프 표현
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            arr[s].add(new Node(e, v));
        }

        // 최단거리 초기화
        for (int i = 1; i <= n; i++) {
            results[i] = Integer.MAX_VALUE;
        }

        Queue<Node> q = new PriorityQueue<>();
        q.add(new Node(start, 0));
        // 시작 노드는  최단거리값을 0으로 초기화
        results[start] = 0;
        while (!q.isEmpty()) {
            Node now = q.poll();
            int now_node = now.node;
//            int value = now.value;
            if (visited[now_node]) {
                continue;
            }
            visited[now_node] = true;
            for (Node next : arr[now_node]) {
                int next_node = next.node;
                int value = next.value;
                // 현재 루트가 다음 노드로 가는 최단 루트일 경우에만 탐색 큐에 추가
                if (results[next_node] > results[now_node] + value) {
                    results[next_node] = results[now_node] + value;
//                    다음 노드의 최단 경로값 = 시작노드부터 현재 노드까지의 최단값 + 가중치여야 하는데
//                    아래의 경우 다음 노드의 최단 경로값이 가중치가 되어버림
//                    q.add(next);
                    q.add(new Node(next_node, results[next_node]));
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            if (visited[i]) {
                System.out.println(results[i]);
            } else {
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

        public int compareTo(Node node) {
            return this.value - node.value;
        }
    }
}
