package backJoon;

import java.io.*;
import java.util.*;

public class Q1707_이분그래프판별하기 {

    static ArrayList<Integer>[] arr;
    static int[] check;
    static boolean[] visited;

    static boolean result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 테스트 케이스
        int k = Integer.parseInt(st.nextToken());
        int v;
        int e;
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            // 노드 개수
            v = Integer.parseInt(st.nextToken());
            // 에지 개수
            e = Integer.parseInt(st.nextToken());
            // 트리 정보를 저장할 배열
            arr = new ArrayList[v+1];
            // 집합을 저장할 배열
            check = new int[v + 1];
            // 방문 정보를 저장할 배열
            visited = new boolean[v + 1];
            // 사이클을 형성하는 노드가 있는지 확인하는 변수
            result = true;
            for (int j = 1; j <= v; j++) {
                arr[j] = new ArrayList<>();
            }
            for (int j = 1; j <= e; j++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                // 방향이 정해지지 않았으므로 양쪽 노드 모두에 에지 정보 저장
                arr[start].add(end);
                arr[end].add(start);
            }
            for (int j = 1; j <= v; j++) {
                // 그래프가 1개로 연결되어 있는지 보장되지 않으므로 모든 노드를 탐색
                if (result) {
                    dfs(j);
                } else {
                    break;
                }
            }
            // 사이클이 형성되지 않았다면 YES 아니면 NO
            if (result) {
                bw.write("YES\n");
            } else {
                bw.write("NO\n");
            }

        }
        bw.flush();
        br.close();
        bw.close();
    }

    public static void dfs(int node) {
        // 현재 노드 방문 체크
        visited[node] = true;
        for (int next : arr[node]) {
            if (!visited[next]) {
                // 다음 노드의 집합을 현재 노드와 다른 집합으로 설정
                check[next] = (check[node] + 1) % 2;
                dfs(next);
                // 다음 노드를 이미 방문했는데, 현재 노드와 같은 집합이라면
                // 사이클이 형성된 것으로 result를 false로 설정
            } else if (check[next] == check[node]){
                System.out.println();
                result = false;
                return;
            }
        }
    }
}

// 틀린 로직
// dfs에서 노드의 집합을 구분하는 부분에서 문제가 발생

//public class Main {
//
//    static ArrayList<Integer>[] arr;
//    static int[] visited;
//
//    static boolean result;
//
//    static int pos;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        // 테스트 케이스
//        int k = Integer.parseInt(st.nextToken());
//        int v;
//        int e;
//        for (int i = 0; i < k; i++) {
//            st = new StringTokenizer(br.readLine());
//            // 노드 개수
//            v = Integer.parseInt(st.nextToken());
//            // 에지 개수
//            e = Integer.parseInt(st.nextToken());
//            arr = new ArrayList[v+1];
//            visited = new int[v + 1];
//            result = true;
//            for (int j = 1; j <= v; j++) {
//                arr[j] = new ArrayList<>();
//            }
//            for (int j = 1; j <= e; j++) {
//                st = new StringTokenizer(br.readLine());
//                int start = Integer.parseInt(st.nextToken());
//                int end = Integer.parseInt(st.nextToken());
//                arr[start].add(end);
//                arr[end].add(start);
//            }
//            for (int j = 1; j <= v; j++) {
//                if (result) {
//                    dfs(j);
//                } else {
//                    break;
//                }
//            }
//            if (result) {
//                bw.write("YES\n");
////                System.out.println("YES");
//            } else {
//                bw.write("NO\n");
////                System.out.println("NO");
//            }
//
//        }
//        bw.flush();
//        br.close();
//        bw.close();
//    }
//
//    public static void dfs(int node) {
//        이 부분에서 문제 발생
//        visited[node] = pos;
//        if(pos == 1){
//            pos=2;
//        }else{
//            pos=1;
//        }
//        for (int next : arr[node]) {
//            if (visited[next] == 0) {
//                dfs(next);
//            } else if (visited[next] == visited[node]){
//                result = false;
//                return;
//            }
//        }
//    }
//}
