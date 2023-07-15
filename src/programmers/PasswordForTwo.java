package programmers;

public class PasswordForTwo {
    // 둘만의 암호
    public String solution(String s, String skip, int index) {
        StringBuilder stb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            char tmp = s.charAt(i);
            for(int y = 0; y < index; y++){
                tmp++;
                if(tmp > 'z'){
                    tmp = 'a';
                }
                if(skip.indexOf(tmp) > -1){
                    y--;
                }
            }
            System.out.println(tmp);
            stb.append(tmp);
        }
        String answer = stb.toString();
        return answer;
    }
}
