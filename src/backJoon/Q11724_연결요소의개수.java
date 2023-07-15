package backJoon;

import java.io.*;
import java.util.*;

public class Q11724_연결요소의개수 {

    static ArrayList<Integer>[] arr;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new ArrayList[n+1];
        // 1.방문 배열 초기화 하기
        visited = new boolean[n + 1];

        // 2.인접리스트 표헌하기
        for (int i = 1; i < n+1; i++) {
            arr[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr[s].add(e);
            arr[e].add(s);
        }
        // 연결체가 몇개인지 저장할 변수
        int cnt = 0;
        // 3.시작노드 스택에 담기
        // 여기서는 스택 대신에 재귀함수를 통해 호출
        for (int i = 1; i < n + 1; i++) {
            // 해당 노드에 방문하지 않았다면
            if (!visited[i]) {
                // 앞선 연결체와 연결되어있지 않다는 뜻이므로 cnt + 1
                cnt++;
                // 현재 연결체를 확인하기 위해 dfs 재귀호출
                dfs(i);
            }
        }
        System.out.println(cnt);
    }

    static void dfs(int idx) {
        // 현재 노드가 방문한 노드라면 재귀호출을 끝내고 return
        if (visited[idx]) {
            return;
        }
        // 현재 노드의 방문을 true로 저장
        visited[idx] = true;
        // 현재 연결체와 연결된 노드를 하나씩 꺼내서 재귀함수 호출
        for (int i : arr[idx]) {
            if (visited[i] == false) {
                // dfs는 현재 노드의 끝 노드까지 먼저 훑어야 하므로 재귀호출을 통해
                // 현재 노드의 아래 레벨에 있는 노드를 호출
                dfs(i);
            }
        }
    }
}
