package programmers;

public class Pro_연속된부분수열의합 {
    public int[] solution(int[] sequence, int k) {

        int n = sequence.length;
        // 시작 인덱스를 저장할 변수
        int left = 0;
        // 끝 인덱스를 저장할 변수
        int right = n;
        // 누적합을 저장할 변수
        int sum = 0;
        // 투포인터의 끝 인덱스를 나타내는 변수
        int r = 0;
        // l은 투포인터의 시작 인덱스를 나타내는 변수
        for(int l = 0; l < n; l++){
            // 일단 첫 인덱스부터 k보다 작을때까지 값을 누적
            while(r < n && sum < k){
                sum += sequence[r];
                r++;
            }

            // 여기서부터는 누적합(sum)이 k보다 크거나 같을 때임

            // sum이 k보다 같을때
            if(sum == k){
                // 현재 구간의 범위
                int range = r - l - 1;
                // 현재 구간의 범위가 기존의 구간 범위보다 작으면
                if((right - left) > range){
                    // 기존 구간 갱신
                    left = l;
                    right = r-1;
                }
            }

            // sum이 k와 같다고 해도 k와 같은 구간합 중에
            // 범위가 가장 적은 것을 구해야 하므로
            // 누적합에서 왼쪽 인덱스 값을 빼줌
            sum -= sequence[l];

        }
        int[] answer = {left, right};
        return answer;

//         시간 초과
//         boolean[] result = new boolean[sequence.length];
//         int min = Integer.MAX_VALUE;
//         int[] answer = new int[2];
//         for(int i = 0; i < sequence.length; i++){
//             int tmp = sequence[i];
//             if(tmp == k){
//                 return new int[]{i,i};
//             }else if(tmp > k){
//                 continue;
//             }
//             for(int y = i+1; y < sequence.length; y++){
//                 tmp+=sequence[y];
//                 if(tmp == k){
//                     result[i]=true;
//                     int len = y-i;
//                     if(min > len){
//                         min = len;
//                         answer[0] = i;
//                         answer[1] = y;
//                     }
//                     break;
//                 }else if(tmp > k){
//                     break;
//                 }
//             }

//         }
    }
}
