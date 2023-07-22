package backJoon;

import java.io.*;
import java.util.*;

public class Q1516_게임개발 {

    static int[] input;
    static int[] result;
    static ArrayList<Integer>[] arr;
    static int[] edge;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        input = new int[n + 1];
        result = new int[n + 1];
        arr = new ArrayList[n + 1];
        edge = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = new ArrayList<>();
        }
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            input[i] = Integer.parseInt(st.nextToken());
            while (true) {
                int idx = Integer.parseInt(st.nextToken());
                if (idx == -1) {
                    break;
                }
                arr[idx].add(i);
                edge[i]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (edge[i] == 0) {
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            int now = q.poll();
            for (int next : arr[now]) {
                edge[next]--;
//                result[next] = input[now]+result[now];
                // 동시에 여러 건물을 지을 수 있으므로 진입 노드 중 가장 오래 걸리는 노드로
                // 갱신해줌
                result[next] = Math.max(result[next], result[now] + input[now]);
                if (edge[next] == 0) {
                    q.add(next);
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            System.out.println(input[i]+result[i]);
        }
    }
}
