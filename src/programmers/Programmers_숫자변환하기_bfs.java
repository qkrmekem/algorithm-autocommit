package programmers;

import java.util.*;

class Programmers_숫자변환하기_bfs {
    public static int solution(int x, int y, int n) {
        Queue<Number> queue = new LinkedList<>();
        queue.add(new Number(y,0));
        while (!queue.isEmpty()){
            Number number = queue.poll();
            int value = number.getValue();
            int count = number.getCount();

            if(value==x){
                return count;
            }

            if(value%2==0){
                queue.add(new Number(value/2,count+1));
            }

            if(value%3==0){
                queue.add(new Number(value/3,count+1));
            }

            if(value-n>=x){
                queue.add(new Number(value-n,count+1));
            }
        }

        return -1;
    }

    static class Number{
        int value;

        int count;

        Number(int value,int count){
            this.value = value;
            this.count = count;
        }

        public int getCount() {
            return count;
        }

        public int getValue() {
            return value;
        }
    }
}