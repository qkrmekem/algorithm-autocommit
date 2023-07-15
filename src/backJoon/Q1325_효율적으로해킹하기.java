package backJoon;

import java.io.*;
import java.util.*;

public class Q1325_효율적으로해킹하기 {

    static ArrayList<Integer>[] arr;
    static boolean visited[];
    static int result[];
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        // 에지 정보를 담을 배열
        arr = new ArrayList[n + 1];

        // 해킹할 수 있는 컴퓨터 수를 누적할 배열
        result = new int[n + 1];

        // 방문 정보를 저장할 배열
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = new ArrayList<>();
        }

        // 에지 정보 초기화
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr[s].add(e);
        }

        // 반복문을 돌면서 각 노드에서 출발할 때 이어져 있는 컴퓨터를
        for (int i = 1; i <= n; i++) {
            // 모든 노드가 하나로 연결되어 있지 않을 수 있으므로
            // 사이클이 발생하지 않은 이상 모든 노드를 점검해야 함
            if (!visited[i]) {
                dfs(i);
                visited = new boolean[n+1];
            }
        }

        max = 0;
        for (int i = 1; i <= n; i++) {
            if (max < result[i]) {
                max = result[i];
            }
        }

        for (int i = 1; i <= n; i++) {
            if (result[i] == max) {
                System.out.print(i + " ");
            }
        }
    }

    public static void dfs(int node) {
        visited[node] = true;
        result[node]++;
        for (int next : arr[node]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
}