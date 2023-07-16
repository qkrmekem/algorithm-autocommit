package backJoon;

import java.io.*;
import java.util.*;

public class Q1976_여행가자 {

    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int[][] city = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                city[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[] route = new int[m + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= m; i++) {
            route[i] = Integer.parseInt(st.nextToken());
        }

        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (city[i][j] == 1) {
                    union(i, j);
                }
            }
        }

        int start = find(route[1]);
        boolean result = true;
        for (int i = 1; i < route.length; i++) {
            if (find(route[i]) != start) {
                result = false;
                break;
            }
        }

        if (result) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (parent[b] != a) {
            parent[b] = a;
        }
    }

    public static int find(int a) {
        if (parent[a] == a) {
            return a;
        }else {
            return parent[a] = find(parent[a]);
        }
    }
}
