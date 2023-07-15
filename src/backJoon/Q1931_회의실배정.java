package backJoon;

import java.io.*;
import java.util.*;

public class Q1931_회의실배정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        // 끝나는 시간이 같을 수 있으므로 그럴 경우
        // 회의의 시작시간을 기준으로 오름차순 정렬
        PriorityQueue<Node> q = new PriorityQueue<>((a, b) -> {
            if (a.e == b.e) {
                return a.s - b.s;
            }
            return a.e - b.e;
        });

        int s = 0;
        int e = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            q.add(new Node(s, e));
        }
        int before = 0;
        int cnt = 0;
        while (!q.isEmpty()) {
            Node now = q.remove();
            if (before <= now.s) {
                cnt++;
                before = now.e;
            }
        }
        System.out.println(cnt);
    }

    // 회의의 시작과 끝을 저장할 객체
    static class Node{
        int s;
        int e;

        public Node(int s, int e) {
            this.s = s;
            this.e = e;
        }
    }
}
