package backJoon;

import java.io.*;
import java.util.*;

public class Q1167_트리의지름 {

    static ArrayList<Node>[] arr;
    static boolean[] visited;
    static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        arr = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            arr[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            while (true) {
                int e = Integer.parseInt(st.nextToken());
                if (e == -1) {
                    break;
                }
                arr[s].add(new Node(e, Integer.parseInt(st.nextToken())));
            }
        }
        distance = new int[n + 1];
        visited = new boolean[n + 1];

        // 일단 임의의 노드와 거리가 가장 먼 노드를 구함
        // 현재 가장 먼 두 개의 노드가 무엇인지 모르므로 임의의 노드를 지정해
        // 그 노드와 가장 멀리있는 노드부터 찾음
        bfs(1);
        int max = 1;
        for (int i = 2; i <= n; i++) {
            if (distance[max] < distance[i]) {
                max = i;
            }
        }
        // 거리 배열과 방문 배열을 초기화
        distance = new int[n + 1];
        visited = new boolean[n + 1];

        // 앞에서 찾은 가장 멀리 있는 노드를 기준으로
        // 그 노드와 가장 멀리 떨어져있는 노드를 찾음
        bfs(max);
        Arrays.sort(distance);
        System.out.println(distance[n]);

    }

    public static void bfs(int idx) {
        Queue<Integer> q = new LinkedList<>();
        q.add(idx);
        visited[idx] = true;
        while (!q.isEmpty()) {
            int now = q.poll();
            for (Node i : arr[now]) {
                int next = i.next;
                int val = i.distance;
                if (!visited[next]) {
                    visited[next] = true;
                    q.add(next);
                    distance[next] = distance[now] + val;
                }
            }
        }
    }

    static class Node {
        int next;
        int distance;

        public Node(int next, int distance) {
            this.next = next;
            this.distance = distance;
        }
    }
}
