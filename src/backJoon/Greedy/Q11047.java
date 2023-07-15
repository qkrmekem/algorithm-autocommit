package backJoon.Greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Q11047 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        int money = sc.nextInt();
        List<Integer> list = new ArrayList<Integer>();
        for (int i=0; i<cnt; i++){
            list.add(sc.nextInt());
        }
        Collections.reverse(list);
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += money / list.get(i);
            money = money % list.get(i);
        }
        System.out.println(sum);
        sc.close();
    }
}
