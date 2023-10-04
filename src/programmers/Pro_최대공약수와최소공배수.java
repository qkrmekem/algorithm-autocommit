package programmers;

public class Pro_최대공약수와최소공배수 {
    // 내 풀이(노가다)
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        int min = Math.min(n,m);
        int max = Math.max(n,m);
        // 최대 공약수 구하기
        for(int i = min; i > 0; i--){
            if(max%i == 0 && min%i == 0){
                answer[0] = i;
                break;
            }
        }
        // 최소 공배수 구하기
        int tmp_min = min;
        int tmp_max = max;
        while(true){
            if(tmp_min == tmp_max){
                answer[1] = tmp_max;
                break;
            }else if(tmp_max > tmp_min){
                tmp_min += min;
            }else if(tmp_max < tmp_min){
                tmp_max += max;
            }
        }
        return answer;
    }

    // 유클리드 호제법
    // 큰수 % 작은수 = 나머지 가 나올때
    // 큰수 = 작은수
    // 작은수 = 나머지
    // 를 대입하여 나머지가 0이 될때 작은수가 최대 공약수가 됨
    public int gcd(int n, int m) {
        int max = Math.max(n,m);
        int min = Math.min(n,m);
        int r;
        while(min > 0) {
            r = max % min;
            max = min;
            min = r;
        }
        return max;
    }

    public int[] solution2(int n, int m) {
        int[] answer = new int[2];

        // 최대공약수 구하기
        answer[0] = gcd(n, m);

        // 최소공배수 구하기
        // 큰수 * 작은수 / 최대공약수
        answer[1] = n * m / answer[0];

        return answer;
    }
}
