package programmers;

public class Pro_숫자문자열영단어 {
    public int solution(String s) {
        int answer = 0;
        while(true){
            boolean chk = false;
            if(s.indexOf("zero")>-1){
                s = s.replace("zero", "0");
                chk = true;
            }
            if(s.indexOf("one")>-1){
                s = s.replace("one", "1");
                chk = true;
            }
            if(s.indexOf("two")>-1){
                s = s.replace("two", "2");
                chk = true;
            }
            if(s.indexOf("three")>-1){
                s = s.replace("three", "3");
                chk = true;
            }
            if(s.indexOf("four")>-1){
                s = s.replace("four", "4");
                chk = true;
            }
            if(s.indexOf("five")>-1){
                s = s.replace("five", "5");
                chk = true;
            }
            if(s.indexOf("six")>-1){
                s = s.replace("six", "6");
                chk = true;
            }
            if(s.indexOf("seven")>-1){
                s = s.replace("seven", "7");
                chk = true;
            }
            if(s.indexOf("eight")>-1){
                s = s.replace("eight", "8");
                chk = true;
            }
            if(s.indexOf("nine")>-1){
                s = s.replace("nine", "9");
                chk = true;
            }
            if(chk==false){
                break;
            }
        }
        answer = Integer.parseInt(s);
        return answer;
    }
}
