package backJoon.slidingwindow;

import java.util.*;
import java.io.*;

public class Q11003_최솟값찾기 {

    static class Node{
        public long idx;
        public long num;

        Node(long idx, long num){
            this.idx = idx;
            this.num = num;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        long n = Long.parseLong(st.nextToken());
        long l = Long.parseLong(st.nextToken());

        Deque<Node> deq = new LinkedList<>();

        st = new StringTokenizer(bf.readLine());

        // StringBuilder, StringBuffer 사용시 시간 초과
        StringBuilder sb = new StringBuilder();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < n; i++){
            long now = Long.parseLong(st.nextToken());
            long start = i-l+1;
            while(!deq.isEmpty() && deq.getLast().num > now){
                deq.removeLast();
            }
            deq.addLast(new Node(i, now));
            if (deq.getFirst().idx < i-l+1){
                deq.removeFirst();
            }
            bw.write(deq.getFirst().num + " ");
        }
        bw.flush();
        bw.close();
        bf.close();
    }
}
