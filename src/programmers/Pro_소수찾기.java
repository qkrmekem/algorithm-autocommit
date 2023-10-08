package programmers;

public class Pro_소수찾기 {
    // 내 풀이(시간 초과)
     public int solution(int n) {
         int answer = 0;
         for(int i = 2; i <= n; i++){
             boolean chk = true;
             for(int y = 2; y <= i/2; y++){
                 if(i%y==0){
                     chk=false;
                     break;
                 }
             }
             if(chk){
                 answer++;
             }
         }
         return answer;
     }

    // 에라스토테네스의 체
    public int solution2(int n) {
        int answer = 0;
        // 주어진 수를 담을 배열을 생성
        int[] arr = new int[n+1];
        // 배열을 각 인덱스의 수로 초기화
        for(int i = 1; i <= n; i++){
            arr[i] = i;
        }
        // 처음 소수인 2부터 시작
        for(int i = 2; i <= n; i++){
            // 현재 인덱스 번호와 실제 값이 일치하면
            if(arr[i] == i){
                // 해당 숫자의 배수는 소수가 아니므로 0으로 수정
                for(int j = i + i; j <= n; j += i){
                    arr[j] = 0;
                }
            }
        }

        // 처음 소수 2부터 n까지 인덱스와 실제 값이 일치하면 소수라는 뜻이므로 answer+1
        for(int i = 2; i <= n; i++){
            if(arr[i] == i){
                answer++;
            }
        }
        return answer;
    }
}
