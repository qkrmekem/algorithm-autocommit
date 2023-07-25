package programmers;

public class Pro_JadenCase문자열만들기 {
    public String solution(String s) {
        String[] arr = s.split(" ");
        // String[] arr = s.toLowerCase().split(" ");
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < arr.length; i++){
            if(arr[i].length()==0){
                sb.append(" ");
                continue;
            }
            sb.append(arr[i].substring(0,1).toUpperCase());
            sb.append(arr[i].substring(1,arr[i].length()).toLowerCase());
            sb.append(" ");
        }

        if(!" ".equals(s.substring(s.length()-1, s.length()))) {
            sb.deleteCharAt(sb.lastIndexOf(" "));
        }

        return sb.toString();
    }
}
