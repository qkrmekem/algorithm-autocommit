package backJoon.Greedy;

import java.util.*;

public class Q11399 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < cnt; i++) {
            list.add(sc.nextInt());
        }
        Collections.sort(list);
        int result = 0;
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            result += list.get(i)+sum;
            sum+= list.get(i);
        }
        System.out.println(result);
        sc.close();
    }
}
