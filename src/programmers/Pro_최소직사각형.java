package programmers;

public class Pro_최소직사각형 {
    public int solution(int[][] sizes) {
        int answer = 0;
        int min = 0;
        int max = 0;
        int tmp_min = 0;
        int tmp_max = 0;
        for(int i = 0; i < sizes.length; i++){
            tmp_min = Math.min(sizes[i][0], sizes[i][1]);
            tmp_max = Math.max(sizes[i][0], sizes[i][1]);
            if(tmp_min > min){
                min = tmp_min;
            }
            if(tmp_max > max){
                max = tmp_max;
            }

        }
        answer = min * max;
        return answer;
    }
}
