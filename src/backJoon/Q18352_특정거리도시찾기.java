package backJoon;

import java.io.*;
import java.util.*;

public class Q18352_특정거리도시찾기 {

    // 각 노드의 연결 정보를 저장할 배열
    static ArrayList<Integer>[] arr;

    // 방문 노드의 깊이를 저장할 배열
    static int[] visited;

    // 깊이가 k이상인 노드를 저장할 배열
    static List<Integer> result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        // 노드 배열과 방문 배열 초기화
        visited = new int[n + 1];
        arr = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = new ArrayList<>();
            // 모든 노드의 배열 정보를 -1로 초기화
            visited[i] = -1;
        }

        // 각 엣지 정보 입력
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr[s].add(e);
        }
        // 너비 우선 탐색 시작
        bfs(x);

        // 깊이가 k이상인 노드를 저장할 배열 초기화
        result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            // 노드 i의 깊이가 k 이상이면 result에 추가
            if (visited[i] == k) {
                result.add(i);
            }
        }

        // result가 비었다면 깊이가 k인 노드가 없다는 말이므로 -1 출력
        if (result.isEmpty()) {
            System.out.println(-1);
        // 아니라면
        } else {
            // 오름차순으로 깊이가 k인 노드를 모두 출력해야 하므로 정렬
            Collections.sort(result);
            for (int i : result) {
                System.out.println(i);
            }
        }
    }

    public static void bfs(int node) {
        Queue<Integer> q = new LinkedList<>();
        // 시작 노드를 큐에 먼저 집어 넣고
        q.add(node);
        // 시작 노드의 깊이를 1증가 시킴
        visited[node]++;
        while (!q.isEmpty()) {
            int now = q.poll();
            // 현재 노드와 연결된 노드를 탐색
            for (int i : arr[now]) {
                // 현재 노드와 연결된 각 노드를 방문하지 않았다면
                if (visited[i] == -1) {
                    // 연결된 노드를 큐에 추가하고
                    q.add(i);
                    // 연결된 노드의 깊이를 현재 노드의 깊이 + 1로 저장
                    // 이렇게 함으로
                    visited[i] = visited[now] + 1;
                }
            }
        }
    }
}
