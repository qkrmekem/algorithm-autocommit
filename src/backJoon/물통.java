package backJoon;

import java.io.*;
import java.util.*;

public class 물통 {

    static int[] sender = {0, 0, 1, 1, 2, 2};
    static int[] receiver = {1, 2, 0, 2, 0, 1};
    static boolean[][] visited;
    static boolean[] result;
    static int[] now;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 각 물통의 최대값을 저장할 배열
        now = new int[3];
        StringTokenizer st = new StringTokenizer(br.readLine());
        now[0] = Integer.parseInt(st.nextToken());
        now[1] = Integer.parseInt(st.nextToken());
        now[2] = Integer.parseInt(st.nextToken());
        // 각 물통의 리터를 배열로 저장
        // visited에는 a,b물통의 리터를 저장
        visited = new boolean[201][201];
        // result에는 c물통의 리터를 저장
        result = new boolean[201];
        bfs();
        // result가 true라는 뜻은
        // bfs를 거치며 a물통이 비어졌을 때 물통 c의 값이라는 뜻이므로
        // result의 인덱스 값을 출력
        for (int i = 0; i < result.length; i++) {
            if (result[i]){
                System.out.print(i + " ");
            }
        }
    }

    public static void bfs() {
        Queue<AB> q = new LinkedList<>();
        // a와 b가 비어있는 상태이므로 c의 값을 결과에 저장
        q.add(new AB(0, 0));
        visited[0][0] = true;
        result[now[2]] = true;
        while (!q.isEmpty()) {
            AB node = q.poll();
            int a = node.a;
            int b = node.b;
            int c = now[2] - a - b;
            for (int k = 0; k < 6; k++) {
                int[] next = {a, b, c};
                next[receiver[k]] += next[sender[k]];
                next[sender[k]] = 0;
                // 물이 넘치면(물을 옮겨담은 결과가 물통의 최대값보다 크면)
                if (next[receiver[k]] > now[receiver[k]]) {
                    // 물이 들어있던 통에 붓고 남은 물을 저장
                    next[sender[k]] = next[receiver[k]] - now[receiver[k]];
                    // 물을 옮긴 통을 최대값으로 설정
                    next[receiver[k]] = now[receiver[k]];
                }
                // a물통과 b물통의 양이 기존에 나오지 않았던 값이면
                if (!visited[next[0]][next[1]]) {
                    visited[next[0]][next[1]] = true;
                    q.add(new AB(next[0], next[1]));
                    // a물통이 비어졌다면 결과 배열에 c물통의 값을 저장
                    if (next[0] == 0) {
                        result[next[2]] = true;
                    }
                }
            }
        }
    }
}
class AB{
    int a;
    int b;
    public AB(int a, int b) {
        this.a = a;
        this.b = b;
    }
}
