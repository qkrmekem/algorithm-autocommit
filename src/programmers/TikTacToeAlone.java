package programmers;

public class TikTacToeAlone {
    public int solution(String[] board) {
        int answer = -1;

        int cnto = 0;
        int cntx = 0;

        boolean o = false;
        boolean x = false;

        int[] arro = {0,0,0};
        int[] arr = {0,0,0};

        int tmpl = 0;
        int tmpr = 0;
        int tmpxl = 0;
        int tmpxr = 0;

        for(int i = 0; i < board.length; i++){
            // 각 행이 정답인지 확인
            if(board[i].equals("XXX")){
                x=true;
            }else if(board[i].equals("OOO")){
                o = true;
            }
            // 대각선 정답이 있는지 확인
            if(board[i].charAt(i)=='O'){
                tmpl ++;
            }else if(board[i].charAt(i)=='X'){
                tmpxl++;
            }
            if(board[i].charAt(2-i) == 'O'){
                tmpr++;
            }else if(board[i].charAt(2-i) =='X'){
                tmpxr++;
            }
            // ox의 개수를 세기 위한 반복문
            for(int y = 0; y < board.length; y++){
                if(board[i].charAt(y) == 'O'){
                    arro[y]+=1;
                    cnto++;
                }else if(board[i].charAt(y) == 'X'){
                    arr[y]+=1;
                    cntx++;
                }
            }
        }
        // 각 열이 3개면 정답
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 3){
                x = true;
            }
            if(arro[i] == 3){
                o = true;
            }
            // 대각선에 3개가 있으면 정답
        }
        if(tmpl == 3 || tmpr == 3){
            o = true;
        }else if(tmpxl == 3 || tmpxr == 3){
            x = true;
        }

        if(cnto==cntx+1 && x == false){
            answer = 1;
        }else if(cnto == cntx){
            if(o==false){
                answer = 1;
            }else{
                answer = 0;
            }
        }else{
            answer = 0;
        }
        return answer;
    }
}
