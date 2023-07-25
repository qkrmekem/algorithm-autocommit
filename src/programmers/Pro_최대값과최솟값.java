package programmers;

public class Pro_최대값과최솟값 {
    public String solution(String s) {
        String[] arr = s.split(" ");
        int max = Integer.parseInt(arr[0]);
        int min = Integer.parseInt(arr[0]);
        for(int i = 0; i < arr.length; i++){
            max = Math.max(max, Integer.parseInt(arr[i]));
            min = Math.min(min, Integer.parseInt(arr[i]));
        }

        String answer = min + " " + max;

        return answer;
    }
}
