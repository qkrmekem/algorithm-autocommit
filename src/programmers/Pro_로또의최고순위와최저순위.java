package programmers;

public class Pro_로또의최고순위와최저순위 {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        boolean[] chk = new boolean[46];
        for(int i = 0; i < win_nums.length; i++){
            chk[win_nums[i]] = true;
        }
        int cnt = 0;
        int zero = 0;
        for(int i = 0; i < lottos.length; i++){
            if(lottos[i] == 0){
                zero++;
                continue;
            }
            if(chk[lottos[i]]){
                cnt++;
            }
        }
        answer[0] = Math.min(rank(cnt),rank(cnt+zero));
        answer[1] = Math.max(rank(cnt),rank(cnt+zero));
        return answer;
    }
    public int rank(int num){
        if(num == 6){
            return 1;
        }else if(num == 5){
            return 2;
        }else if(num == 4){
            return 3;
        }else if(num == 3){
            return 4;
        }else if(num == 2){
            return 5;
        }else{
            return 6;
        }
    }
}
