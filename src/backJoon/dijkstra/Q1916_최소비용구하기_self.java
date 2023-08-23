package backJoon.dijkstra;

import java.io.*;
import java.util.*;

public class Q1916_최소비용구하기_self {

    static ArrayList<Node>[] arr;
    static int[] result;
    static boolean[] visited;

    public static void main(String[] arge) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        arr = new ArrayList[n+1];
        result = new int[n+1];
        visited = new boolean[n+1];

        for (int i = 1; i <= n; i++){
            arr[i] = new ArrayList<>();
            result[i] = Integer.MAX_VALUE;
        }
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
        Queue<Node> q = new PriorityQueue<>();
        q.add(new Node(start, 0));
        result[start] = 0;
        while (!q.isEmpty()) {
            Node tmp1 = q.poll();
            int now = tmp1.target;
            if (visited[now]) {
                continue;
            }
            visited[now] = true;
            for (Node next : arr[now]){
                int target = next.target;
                int value = next.value;
                if (result[target] > result[now] + value){
                    result[target] = result[now] + value;
                    q.add(new Node(target, result[now] + value));
                }
            }
        }
        System.out.println(result[end]);
    }

    static class Node implements Comparable<Node>{
        int target;
        int value;

        public Node(int target, int value) {
            this.target = target;
            this.value = value;
        }

        public int compareTo(Node o){
            return this.value - o.value;
        }
    }
}
