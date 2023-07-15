package backJoon;

import java.io.*;
import java.util.*;

public class Q_1715_카드정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> q = new PriorityQueue<>((a,b) -> {
            return a-b;
        });
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            q.add(Integer.parseInt(st.nextToken()));
        }
        int result = 0;
        while (q.size()!=1) {
            int a = q.remove();
            int b = q.remove();
            result += a+b;
            q.add(a+b);
        }
        System.out.println(result);
    }
}
