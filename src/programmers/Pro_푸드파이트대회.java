package programmers;

public class Pro_푸드파이트대회 {
    public String solution(int[] food) {
        String answer = "0";
        String pre = "";
        String post = "";
        for(int i = 1; i < food.length; i++){
            int now = food[i]/2;
            String tmp = String.valueOf(i);
            pre  = pre + tmp.repeat(now);
            post = tmp.repeat(now) + post;
        }
        answer = pre + answer + post;
        return answer;
    }
}
