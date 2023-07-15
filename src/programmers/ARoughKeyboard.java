package programmers;

public class ARoughKeyboard {
    // 대충 만든 키보드
    public int[] solution(String[] wallpaper) {
        int lux=wallpaper.length;
        int luy=wallpaper[0].length();
        int rdx=0;
        int rdy=0;

        int len = wallpaper[0].length();
        for(int i = 0; i< wallpaper.length; i++){
            for(int y = 0; y < len; y++){
                char tmp = wallpaper[i].charAt(y);
                if(tmp == '#'){
                    if(i<lux){
                        lux = i;
                    }
                    if(y<luy){
                        luy=y;
                    }
                    if(i>rdx){
                        rdx=i;
                    }
                    if(y>rdy){
                        rdy=y;
                    }
                }
            }
        }

        int[] answer = {lux,luy,rdx+1,rdy+1};
        return answer;
    }
}
