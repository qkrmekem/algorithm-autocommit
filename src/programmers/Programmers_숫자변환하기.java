package programmers;

public class Programmers_숫자변환하기 {
    static int MAX = Integer.MAX_VALUE;

    public int solution(int x, int y, int n) {
        int answer = 0;

        int dp[] = new int[y+1];

        for(int i = x+1; i < y+1; i++){
            int a = MAX;
            int b = MAX;
            int c = MAX;

            if(isDivide(i, 2) && ((i/2) >= x)){
                a = dp[i/2];
            }
            if(isDivide(i,3) && ((i/3) >= x)){
                b = dp[i/3];
            }
            if((i-n) >= x){
                c = dp[i-n];
            }

            int min = Math.min(a,b);
            min = Math.min(min,c);

            dp[i] = (min < MAX) ? min+1 : MAX;
        }

        answer = (dp[y] < MAX) ? dp[y] : -1;

        return answer;
    }

    public static boolean isDivide(int i, int n){
        if(i/n > 0 && i%n == 0){
            return true;
        }
        return false;
    }
}
