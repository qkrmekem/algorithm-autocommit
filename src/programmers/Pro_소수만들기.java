package programmers;

public class Pro_소수만들기 {
    public int solution(int[] nums) {
        int answer = 0;

        for(int i = 0; i < nums.length-2; i++){
            for(int y = i+1; y < nums.length-1; y++){
                for(int z = y+1; z < nums.length; z++){
                    int now = nums[i] + nums[y] + nums[z];

                    // 현재 수들의 합 now가 소수인지 확인하기 위한 변수
                    boolean chk = false;

                    // 소수인지 확인하려면 n의 제곱근까지만 확인하면 됨
                    for(int q = 2; q * q <= now; q++){
                        // q의 제곱이 now와 같다면 q가 now의 제곱근이고
                        // now가 소수가 아니라는 뜻이므로
                        // chk를 true로 수정 후 반복을 멈춤
                        if(q*q == now){
                            chk = true;
                            break;
                            // q로 now가 나누어 떨어진다면 now는 소수가 아니라는 뜻이므로
                            // chk를 true로 수정 후 반복을 멈춤
                        }else if(now%q == 0){
                            chk = true;
                            break;
                        }
                    }
                    // chk가 false일 떄 now가 소수라는 뜻이므로 answer+1
                    if(!chk){
                        answer++;
                    }
                }
            }
        }

        return answer;
    }
}
