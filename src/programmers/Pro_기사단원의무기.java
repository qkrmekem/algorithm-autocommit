package programmers;

public class Pro_기사단원의무기 {
    //     내 풀이
//     public int solution(int number, int limit, int power) {
//         int answer = 0;
//         boolean check;
//         int cnt;

//         for(int i = 1; i <= number; i++){
//             cnt = 1;
//             for(int y = 1; y <= i/2; y++){
//                 if(i%y == 0){
//                     cnt++;
//                     if(cnt > limit){
//                         cnt = power;
//                         break;
//                     }
//                 }
//             }
//             answer += cnt;
//         }
//         return answer;
//     }

    // 알고리즘 최적화
    public int solution(int number, int limit, int power) {
        int answer = 0;
        int cnt;
        for(int i = 1; i <= number; i++){
            cnt = 0;
            for(int y = 1; y*y<=i; y++){
                if(y*y == i){
                    cnt++;
                }else if(i%y == 0){
                    cnt+=2;
                }
            }
            if(cnt > limit){
                cnt = power;
            }
            answer+=cnt;
        }
        return answer;
    }
}
