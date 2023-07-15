package backJoon.queue;

import java.util.*;

public class Q2164_카드2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Deque<Integer> q = new LinkedList<>();
        for (int i = 1; i<= n; i++){
            q.add(i);
        }
        while(q.size() != 1){
            q.removeFirst();
            int tmp = q.removeFirst();
            q.addLast(tmp);
        }
        System.out.println(q.getFirst());
    }

}
