package backJoon;

import java.util.*;

public class Q1033_칵테일 {
    static ArrayList<Node>[] arr;
    static long lcm;
    static boolean visited[];
    static long d[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new ArrayList[n];
        visited = new boolean[n];
        d = new long[n];
        lcm = 1;
        for (int i = 0; i < n; i++) {
            arr[i] = new ArrayList<Node>();
        }
        // 1. 모든 재료들의 최소공배수를 구함
        for (int i = 0; i < n - 1; i++) {
            // 각 노드의 인덱스
            int a = sc.nextInt();
            int b = sc.nextInt();
            // a와 b의 비율값
            // a의 비율
            int p = sc.nextInt();
            // b의 비율
            int q = sc.nextInt();
            // 각 노드에 간선을 추가
            arr[a].add(new Node(b, p, q));
            arr[b].add(new Node(a, q, p));
            //각 재료들의 최소 공배수를 구함
            lcm *= (p * q / gcd(p, q));
        }
        // 2. 임의의 시작점을 지정하고 1에서 구한 최대공배수를 기준값으로
        // 각 노드의 값들을 구하기 위해 dfs 시작
        // 여기서는 0번째 노드를 기준값으로 설정
        d[0] = lcm;
        dfs(0);
        // 4. 모든 노드의 최대공약수를 구하기
        // 최대 공약수를 구하기 위해 일단 임의의 값을 최대공약수로 설정
        long mgcd = d[0];
        for (int i = 1; i < n; i++) {
            // 현재 저장된 최대공약수와 다음 노드의 값의 최대공약수를 구함
            mgcd = gcd(mgcd, d[i]);
        }
        // 위의 반복문을 통해 전체 노드의 최대 공약수가 구해졌으므로
        // 5. 각 노드의 값을 최대공약수로 나눠 최소값을 구함
        for (int i = 0; i < n; i++) {
            // 최소값을 출력해야 하므로
            // 각 노드의 값과 최대공약수를 나눠 최소값을 출력
            System.out.print(d[i]/mgcd + " ");
        }
    }

    public static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

    public static void dfs(int node) {
        // 현재노드를 방문한 것으로 설정
        visited[node] = true;
        for (Node i : arr[node]) {
            // 다음 노드
            int next = i.b;
            // 3. 앞선 노드의 값을 기준으로 앞 노드와 다음 노드의 비율을 계산해
            // 다음 노드의 값을 구해줌
            if (!visited[next]) {
                // 현재노드의 값 * 다음 노드의 비율 / 현재노드의 비율
                d[next] = d[node] * i.q / i.p;
                dfs(next);
            }
        }
    }
}

class Node{
    int b;
    int p;
    int q;

    public Node(int b, int p, int q) {
        this.b = b;
        this.p = p;
        this.q = q;
    }
}
