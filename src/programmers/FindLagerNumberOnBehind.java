package programmers;

import java.util.*;

public class FindLagerNumberOnBehind {
    //뒤에 있는 큰 수 찾기
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < numbers.length; i++){
            while(stack.isEmpty() == false && numbers[stack.peek()] < numbers[i]){
                answer[stack.pop()] = numbers[i];
            }
            stack.push(i);
        }

        while(!stack.isEmpty()){
            answer[stack.pop()] = -1;
        }

        return answer;
    }
}
