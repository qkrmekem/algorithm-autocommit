package programmers;

public class Pro_다트게임 {
    public int solution(String dartResult) {
        int answer = 0;

        // 1번
        int[] arr = new int[3];
        int pos = -1;
        for(int i = 0; i < dartResult.length(); i++){
            char tmp = dartResult.charAt(i);
            // 2번조건
            if(tmp >= '0' && tmp <= '9'){
                pos++;
                if(tmp == '1' && dartResult.charAt(i+1) == '0'){
                    arr[pos] = 10;
                    i = i + 1;
                }else{
                    arr[pos] = Integer.parseInt(String.valueOf(tmp));
                }
            }

            // 3번조건
            else if(tmp == 'D'){
                arr[pos] = arr[pos] * arr[pos];
            }else if(tmp == 'T'){
                arr[pos] = arr[pos] * arr[pos] * arr[pos];
            }

            // 4번조건
            else if(tmp == '*'){
                // 5번조건
                if(pos == 0){
                    arr[pos] = arr[pos] *2;
                }else{
                    arr[pos] = arr[pos] *2;
                    arr[pos-1] = arr[pos-1] * 2;
                }
            }else if(tmp == '#'){
                arr[pos] = arr[pos] * -1;
            }

        }
        answer = arr[0] + arr[1] + arr[2];
        return answer;
    }
}
