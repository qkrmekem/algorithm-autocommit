package backJoon;

import java.io.*;
import java.util.*;

public class Q13023_ABCDE {
    // 노드 간 관계를 표현할 배열
    static LinkedList<Integer>[] arr;
    // 방문 여부를 체크할 배열
    static boolean[] visited;
    // 관계의 깊이가 5이상인지 아닌지 체크할 변수
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int node = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());
        arr = new LinkedList[node];
        visited = new boolean[node];
        result = 0;

        for (int i = 0; i < node; i++) {
            arr[i] = new LinkedList<>();
        }

        // 인접 리스트로 관계 표현하기
        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            // 관계간의 순서가 따로 정해져 있지 않으므로 각 노드를 서로의 배열에 저장
            arr[s].push(e);
            arr[e].push(s);
        }

        for (int i = 0; i < node; i++) {
            // 시간복잡도를 위해 result가 1이라면 더 이상 반복읋 하지 않음
            if (result == 1) {
                break;
            }
            if (!visited[i]) {
                dfs(i, 1);
            }
        }
        System.out.println(result);
    }

    public static void dfs(int node, int depth) {
        // 깊이가 5라면 더 탐색을 하지 않고 return
        if (depth == 5) {
            result = 1;
            return;
        }
        visited[node] = true;
        for (int i : arr[node]) {
            // 저장중인 노드가 방문하지 않은 노드일 경우에만 재귀함수 호출
            if (visited[i] == false) {
                // 깊이 + 1
                dfs(i,depth + 1);
            }
        }
        // 이 로직까지 왔다는 뜻은 재귀함수를 통해 연결된 끝 노드까지
        // 탐색을 마쳤다는 뜻이므로 다른 경우의 수를 위해 방문 기록을 false로 초기화
        visited[node] = false;
    }
}
