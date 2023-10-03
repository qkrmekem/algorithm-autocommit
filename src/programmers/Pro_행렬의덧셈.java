package programmers;

public class Pro_행렬의덧셈 {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr1[0].length];
        for(int i = 0; i < arr1.length; i++){
            for(int y = 0; y < arr1[0].length; y++){
                answer[i][y] = arr1[i][y] + arr2[i][y];
            }
        }
        return answer;
    }
}
