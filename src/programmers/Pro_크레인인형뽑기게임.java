package programmers;

import java.util.*;

public class Pro_크레인인형뽑기게임 {
    // 내 풀이
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        List<Stack<Integer>> arr = new ArrayList<>();
        Stack<Integer> tmp = null;
        // 먼저 인형 바구니는 정사각형의 배열로 이뤄져 있으므로 각 행마다 스택을 먼저 생성
        for(int i = 0; i < board.length; i++){
            arr.add(new Stack<>());
        }
        // 스택은 LIFO구조이므로 가장 마지막 행부터 인형을 스택에 담아줌
        for(int i = board.length-1; i >=0 ; i--){
            for(int y = 0; y < board[i].length; y++){
                tmp = arr.get(y);
                if(board[i][y] == 0){
                    continue;
                }
                tmp.push(board[i][y]);
            }

        }

        // 욞겨 담을 바구니 스택 생성
        Stack<Integer> result = new Stack<>();
        for(int i = 0; i < moves.length; i++){
            // 현재 열의 스택의 크기가 0이라면 예외가 발생할 수 있으므로 체크
            tmp = arr.get(moves[i]-1);
            if(tmp.isEmpty()){
                continue;
            }
            // 비어있지 않다면 현재 열의 가장 위에 있는 인형 뽑기
            Integer now = tmp.pop();

            // 결과 스택이 비어있다면 그대로 집어넣음
            if(result.isEmpty()){
                result.push(now);
                continue;
            }
            // 비어 있지 않다면 결과 바구니의 맨 위의 인형을 확인
            Integer top = result.peek();

            // 현재 꺼낸 인형과 결과 바구니의 인형이 같다면
            if(now == top){
                // 답을 2 증가시키고 결과 바구니의 맨 위 인형을 제거
                answer += 2;
                result.pop();
                continue;
            }

            // 그 외의 경우에는 결과 바구니에 옮겨 담음
            result.push(now);
        }
        return answer;
    }

    // 다른 풀이
    public static int solution2(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> s = new Stack<Integer>();
        for(int i=0; i<moves.length; i++) {
            for(int j=0; j<board.length; j++) {
                /*
                 * 해당 칸에 인형이 존재하는경우
                 * ↓ 아래로 내려가므로 행의 값이 계속 바껴야함 (0,0), (1,0), (2,0) ...
                 * moves배열에 있는 요소를 board[][] 배열의 '열' 값에 넣어서 비교
                 * 배열의 인덱스는 0부터 시작하므로 -1
                 */
                if(board[j][moves[i]-1] != 0) {

                    // 스택이 비어있는경우 -> 해당 인형 넣기
                    if(s.isEmpty())
                        s.push(board[j][moves[i]-1]);

                        // 스택이 비어있지 않는경우 -> 인형이 동일한지 아닌지 비교
                    else {
                        // 인형이 동일하면 제거 후 사라진 인형개수 +2
                        if(s.peek() == board[j][moves[i]-1]) {
                            s.pop();
                            answer += 2;
                        }
                        // 인형이 동일하지 않으면 스택에 인형 넣기
                        else {
                            s.push(board[j][moves[i]-1]);
                        }
                    }
                    // 해당 작업 끝난 후에는 인형을 빼냈으므로 0으로 만든다.(인형이 없다는 표시)
                    board[j][moves[i]-1] = 0;
                    break;
                }
            }
        }
        return answer;
    }
}
