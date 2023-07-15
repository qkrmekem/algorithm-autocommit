package backJoon.Greedy;

import java.util.*;

public class Q1026 {
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

        //리스트로?
        //개수, 배열a,b값 받고
        //a최소값, b최대값 곱해서 sum에 저장
        //a,b 각 요소 하나씩 삭제
//        Scanner sc = new Scanner(System.in);
//        int len = sc.nextInt();
//        List<Integer> a = new ArrayList<Integer>();
//        List<Integer> b = new ArrayList<Integer>();
//
//        for (int i=0; i<len; i++){
//            a.add(sc.nextInt());
//        }
//        for (int i=0; i<len; i++){
//            b.add(sc.nextInt());
//        }
//        sc.close();
//
//        int sum = 0;
//        for(int i = 0; i<len; i++){
//            int min = Collections.min(a);
//            int max = Collections.max(b);
//            sum += Collections.min(a) * Collections.max(b);
//            a.remove(Integer.valueOf(min));
//            b.remove(Integer.valueOf(max));
//        }
//        System.out.println(sum);
    }
}
