package programmers;

public class TopCoat {
    // 덧칠하기
    public int solution(int n, int m, int[] section) {
        int answer = 0;

        int tmp = 0;

        for(int i = 0; i < section.length; i++){
            if(section[i] > tmp){
                answer++;
                tmp = section[i] + m - 1;
            }

        }

        return answer;
    }
}
