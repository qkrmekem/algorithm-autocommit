package backJoon.queue;

import java.util.*;
import java.io.*;

public class Q11286_절대값힙 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> q = new PriorityQueue<>((o1,o2) -> {
            int first = Math.abs(o1);
            int second = Math.abs(o2);
            if (first == second){
                return o1 > o2 ? 1 : -1;
            }else {
                return first - second;
            }
        });
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < n; i++){
            int x = Integer.parseInt(br.readLine());
            if (x == 0){
                if (q.isEmpty()){
                    bw.write("0" + "\n");
                }else {
                    bw.write(q.poll() + "\n");
                }
            }else {
                q.add(x);
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
