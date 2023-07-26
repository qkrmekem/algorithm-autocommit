package programmers;

public class 가운데글자가져오기 {
    class Solution {
        public String solution(String s) {
            String answer = "";
            char[] arr = s.toCharArray();
            int middle = arr.length / 2;
            if(arr.length % 2 == 0){
                answer = String.valueOf(arr[middle-1]) + String.valueOf(arr[middle]);
            }else{
                answer = String.valueOf(arr[middle]);
            }
            return answer;
        }
    }
}
