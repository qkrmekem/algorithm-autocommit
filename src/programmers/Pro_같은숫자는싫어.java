package programmers;

import java.util.*;

public class Pro_같은숫자는싫어 {
    public Integer[] solution(int []arr) {
        int[] answer = {};

        int last = -1;

        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < arr.length; i++){
            if(arr[i] != last){
                last = arr[i];
                list.add(arr[i]);
            }
        }

        return list.toArray(new Integer[0]);
    }
}
