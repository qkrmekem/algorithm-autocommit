package backJoon;

import java.io.*;
import java.util.*;

public class Q2178_미로탐색하기 {

    static boolean[][] visited;
    static int[][] arr;
    static int[] posX = {1, 0, -1, 0};
    static int[] posY = {0, 1, 0, -1};
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        visited = new boolean[n+1][m+1];
        arr = new int[n+1][m+1];
        result = 0;

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            String tmp = st.nextToken();
            for (int j = 1; j <= m; j++) {
                arr[i][j] = Integer.parseInt(tmp.substring(j-1, j));
            }
        }
        bfs(1, 1, n, m);
        System.out.println(result);
    }

    static void bfs(int x, int y, int endX, int endY) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x,y,1));
        visited[x][y] = true;
        while (!q.isEmpty()) {
            Node now = q.poll();
            if (now.x == endX && now.y == endY) {
                result = now.count;
                break;
            }
            for (int i = 0; i < 4; i++) {
                int nextX = now.x + posX[i];
                int nextY = now.y + posY[i];
                if (nextX <= endX && nextX > 0 && nextY <= endY && nextY > 0 && visited[nextX][nextY] == false && arr[nextX][nextY] == 1) {
                    q.add(new Node(nextX, nextY, now.count+1));
                    visited[nextX][nextY] = true;
                }
            }
        }

    }
    static class Node{
        int x;
        int y;
        int count;

        public Node(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}
