package programmers;

public class Pro_이상한문자만들기 {
    public String solution(String s) {
        StringBuffer answer = new StringBuffer();
        String[] arr = s.split("");

        int idx = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i].equals(" ")){
                answer.append(arr[i]);
                idx = 0;
            }else if(idx % 2 == 0){
                answer.append(arr[i].toUpperCase());
                idx++;
            }else if(idx % 2 != 0){
                answer.append(arr[i].toLowerCase());
                idx++;
            }
        }
        return answer.toString();
    }
}
