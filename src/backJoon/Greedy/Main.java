package backJoon.Greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //재배열을 한다고 했을 때
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (int i=0; i<cnt; i++){
            list1.add(sc.nextInt());
        }
        for (int i=0; i<cnt; i++){
            list2.add(sc.nextInt());
        }
        sc.close();
        Collections.sort(list1);
        Collections.sort(list2);

        int result = 0;
        for (int i = 0; i<cnt; i++){
            result += list1.get(i) * list2.get(cnt-1-i);
        }
        System.out.println(result);
    }
}
