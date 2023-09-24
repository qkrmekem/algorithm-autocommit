package programmers;

import java.util.*;

public class Pro_두개뽑아서더하기 {
    public Integer[] solution(int[] numbers) {
        int[] answer = {};
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < numbers.length-1; i++){
            for(int y = i+1; y < numbers.length; y++){
                set.add(numbers[i] + numbers[y]);
            }
        }
        Iterator<Integer> iter = set.iterator();
        List<Integer> arr = new ArrayList<>();
        while(iter.hasNext()){
            arr.add(iter.next());
        }
        Collections.sort(arr);

        return arr.toArray(new Integer[0]);
    }
}
