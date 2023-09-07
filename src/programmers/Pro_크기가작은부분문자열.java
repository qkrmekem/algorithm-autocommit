package programmers;

public class Pro_크기가작은부분문자열 {
    public int solution(String t, String p) {
        int answer = 0;
        long pn = Long.parseLong(p);
        for(int i = 0; i < t.length()-p.length()+1; i++){
            String sub = t.substring(i,i+p.length());
            long tmp = Long.parseLong(sub);
            // System.out.print(tmp + " ");
            if(tmp <= pn){
                answer++;
            }
        }
        return answer;
    }
}
