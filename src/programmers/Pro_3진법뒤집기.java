package programmers;

import java.util.*;

public class Pro_3진법뒤집기 {
    public int solution(int n) {
        int answer = 0;
        List<Integer> arr = new ArrayList<>();
        while(n > 0){
            arr.add(n%3);
            n = n/3;
        }

        int tmp = 1;
        for(int i = arr.size()-1; i >= 0; i--){
            answer += arr.get(i)*tmp;
            tmp *=3;
        }
        return answer;
    }

    // public int solution(int n) {
    //     int answer = 0;
    //     String ans = "";
    //     while(n != 0) {
    //         ans += n%3;
    //         n /= 3;
    //     }
    //     System.out.println(ans);
    //     return Integer.parseInt(ans, 3);
    // }
}
