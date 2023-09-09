package programmers;

public class Pro_문자열나누기 {
    public int solution(String s) {
        int answer = 0;
        Character now = null;
        int cnt = 0;
        for(int i = 0; i < s.length(); i++){
            if(now == null){
                answer++;
                now = s.charAt(i);
                cnt++;
                continue;
            }
            if(s.charAt(i) == now){
                cnt++;
            }else{
                cnt--;
            }
            if(cnt==0){
                now = null;
            }

        }
        return answer;
    }
}
