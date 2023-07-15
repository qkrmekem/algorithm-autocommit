package programmers;

import java.util.Arrays;
import java.util.PriorityQueue;

public class HotelReservation {
    // 호텔 대실
    public int solution(String[][] book_time) {
        int[][] arr = new int[book_time.length][book_time[0].length];
        for(int i = 0; i < book_time.length; i++){
            int start = Integer.parseInt(book_time[i][0].replace(":", ""));
            int end = Integer.parseInt(book_time[i][1].replace(":",""));

            end+=10;

            if(end % 100 >= 60){
                end+=40;
            }

            arr[i][0] = start;
            arr[i][1] = end;
        }
        Arrays.sort(arr, (a, b) ->{
            if(a[0]==b[0]){
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        PriorityQueue<Integer> rooms = new PriorityQueue<>();


        for(int i = 0; i < arr.length; i++){
            if(rooms.size() == 0){
                rooms.add(arr[i][1]);
                continue;
            }

            if(arr[i][0] >= rooms.peek()){
                rooms.poll();
                rooms.add(arr[i][1]);
            }else{
                rooms.add(arr[i][1]);
            }
        }


        int answer = rooms.size();
        return answer;
    }
}
