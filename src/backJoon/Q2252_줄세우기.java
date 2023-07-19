package backJoon;

import java.io.*;
import java.util.*;

public class Q2252_줄세우기 {

    static ArrayList<Integer>[] arr;
    static int[] edge;

    static ArrayList<Integer> result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        result = new ArrayList<>();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new ArrayList[n+1];
        edge = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = new ArrayList<>();
        }

        // 에지 정보 추가
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr[s].add(e);
            // 진입차수 추가
            edge[e]++;
        }

        // 진입차수가 0인 노드를 큐에 추가
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (edge[i] == 0) {
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            int now = q.poll();
            System.out.print(now + " ");
            // 큐에서 값을 하나씩 제거하며
            for (int next : arr[now]) {
                // 노드와 연결된 다음 노드의 진입차수를 1씩 감소
                edge[next]--;
                // 진입차수가 0일 경우에만
                if (edge[next] == 0) {
                    // q에 추가
                    q.add(next);
                }
            }
        }
    }
}
