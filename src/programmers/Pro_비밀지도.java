package programmers;

public class Pro_비밀지도 {
    // 내 풀이
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        String tmp;
        for(int i = 0; i < n; i++){
            // 각 인덱스마다 이진수로 변환한 문자열을 저장할 임시 변수
            tmp = "";

            // arr1의 각 인덱스에 담긴 수를 임시로 저장할 변수
            int a = arr1[i];
            // arr1의 이진수 문자열을 임시로 저장할 변수
            String tmp1 = "";
            // arr1의 각 인덱스를 이진수로 변환 시작
            while(a > 0){
                tmp1 = a%2 + tmp1;
                a = a/2;
            }

            // arr2의 각 인덱스에 담긴 수를 임시로 저장할 변수
            int b = arr2[i];
            // arr2의 이진수 문자열을 임시로 저장할 변수
            String tmp2 = "";
            // arr1의 각 인덱스를 이진수로 변환 시작
            while(b > 0){
                tmp2 = b%2 + tmp2;
                b = b/2;
            }

            // 각 문자열의 길이가 n보다 작을 경우 그 차이만큼 0으로 채워줌
            if(n > tmp1.length()){
                tmp1 = "0".repeat(n-tmp1.length()) + tmp1;
            }
            if(n > tmp2.length()){
                tmp2 = "0".repeat(n-tmp2.length()) + tmp2;
            }

            // tmp1과 tmp2를 돌며 각 문자가 '1'일 경우 "#"을
            // 아닐 경우 " "을 채움
            for(int j = 0; j < n; j++){
                if(tmp1.charAt(j) == '1' || tmp2.charAt(j) == '1'){
                    tmp = tmp + "#";
                }else{
                    tmp = tmp + " ";
                }
            }
            // 결과 값을 배열 answer의 각 인덱스에 저장
            answer[i] = tmp;

        }
        return answer;
    }

    // Integer.toBinaryString() 사용
    public String[] solution2(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        String tmp;
        for(int i = 0; i < n; i++){
            tmp = "";
            // arr1과 arr2의 각 인덱스를 이진수 문자열로 변환
            String num1 = Integer.toBinaryString(arr1[i]);
            String num2 = Integer.toBinaryString(arr2[i]);

            // 각 문자열의 길이를 n만큼 맞춤(부족한 길이만큼 0으로 채우기)
            if(n > num1.length()){
                num1 = "0".repeat(n-num1.length()) + num1;
            }
            if(n > num2.length()){
                num2 = "0".repeat(n-num2.length()) + num2;
            }

            // 각 문자열을 돌며 하나의 문자열이라도 현재 문자가 '1'이라면 "#"을 아니라면 " "을 채움
            for(int j = 0; j < n; j++){
                if(num1.charAt(j) == '1' || num2.charAt(j) == '1'){
                    tmp += "#";
                }else{
                    tmp += " ";
                }
            }
            // 각 인덱스의 결과를 배열 answer에 저장
            answer[i] = tmp;
        }
        return answer;
    }
}
