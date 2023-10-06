package programmers;

public class Pro_시저암호 {
    // 내 풀이
    class Solution {
        public String solution(String s, int n) {
            StringBuffer answer = new StringBuffer();
            for(int i = 0; i < s.length(); i++){
                char tmp = s.charAt(i);
                if(tmp == ' '){
                    answer.append(tmp);
                }else if(tmp >= 'A' && tmp <= 'Z'){
                    if(tmp+n > 'Z'){
                        // 아래에서 -1을 한 이유는 tmp가 y(25), 'n'이 4일 떄
                        // 'Z'가 26, 'A'가 1이라고 하면
                        // C(3)가 나와야 하는데 아래의 식에서 -1을 하지 않는다고 하면
                        // 1 + ((25 + 4) - 26) = D(4)가 되어 버린다.
                        // 따라서 -1을 해줘야 한다.
                        answer.append((char)('A' + ((tmp+n) - 'Z')-1));
                        continue;
                    }
                    answer.append((char)(tmp+n));
                }else if(tmp >= 'a' && tmp <= 'z'){
                    if(tmp+n > 'z'){
                        answer.append((char)('a' + ((tmp+n) - 'z')-1));
                        continue;
                    }
                    answer.append((char)(tmp+n));
                }
            }
            return answer.toString();
        }
    }

    // 다른 사람 풀이
    public String solution2(String s, int n) {
        String answer = "";
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ' ') {
                answer += ch;
                continue;
            }

            if (Character.isLowerCase(ch)) {
                // 'a'에 더해야할 수를 먼저 구한 다음
                // 이 수를 알파벳의 개수인 26으로 나머지 연산을 한 뒤
                // 'a'에 더해줌
                // (a에 더해줄 수) % 알파벳개수 + 'a'
                answer += (char) ((ch - 'a' + n) % 26 + 'a');
            } else if (Character.isUpperCase(ch)) {
                answer += (char) ((ch - 'A' + n) % 26 + 'A');
            }
        }
        return answer;
    }
}
