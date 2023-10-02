package programmers;

public class Pro_비밀지도 {
    class Solution {
        public String[] solution(int n, int[] arr1, int[] arr2) {
            String[] answer = new String[n];
            String tmp;
            for(int i = 0; i < n; i++){
                tmp = "";
                int a = arr1[i];
                String tmp1 = "";
                while(a > 0){
                    tmp1 = a%2 + tmp1;
                    a = a/2;
                }
                int b = arr2[i];
                String tmp2 = "";
                while(b > 0){
                    tmp2 = b%2 + tmp2;
                    b = b/2;
                }
                if(n > tmp1.length()){
                    tmp1 = "0".repeat(n-tmp1.length()) + tmp1;
                }
                if(n > tmp2.length()){
                    tmp2 = "0".repeat(n-tmp2.length()) + tmp2;
                }
                for(int j = 0; j < n; j++){
                    if(tmp1.charAt(j) == '1' || tmp2.charAt(j) == '1'){
                        tmp = tmp + "#";
                    }else{
                        tmp = tmp + " ";
                    }
                }
                answer[i] = tmp;

            }
            return answer;
        }
    }
}
