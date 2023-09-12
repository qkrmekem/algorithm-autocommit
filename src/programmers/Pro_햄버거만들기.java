package programmers;

import java.util.*;

public class Pro_햄버거만들기 {

    public int solution(int[] ingredient) {
        int answer = 0;

        Stack<Integer> stack = new Stack<Integer>();

        int now = 0;
        for (int i = 0; i < ingredient.length; i++) {
            now = ingredient[i];
            stack.push(now);

            if (stack.size() >= 4) {
                if (stack.get(stack.size() - 4) == 1
                        && stack.get(stack.size() - 3) == 2
                        && stack.get(stack.size() - 2) == 3
                        && stack.get(stack.size() - 1) == 1) {
                    answer++;
                    stack.pop();
                    stack.pop();
                    stack.pop();
                    stack.pop();
                }
            }
        }
        return answer;
    }

    // 시간 초과
//    public int solution(int[] ingredient) {
//        int answer = 0;
//        boolean[] visited = new boolean[ingredient.length];
//        List<Integer> arr = new ArrayList<>();
//        for(int i = 0; i < ingredient.length; i++){
//            arr.add(ingredient[i]);
//        }
//        // boolean chk = true;
//        int[] pos = new int[4];
//        int idx = 0;
//        String pre = "0";
//        while(idx<arr.size()){
//            if(visited[idx]){
//                idx++;
//                continue;
//            }
//            int now = arr.get(idx);
//            if(now == 1){
//                if(pre.equals("123")){
//                    pos[3] = idx;
//                    answer++;
//                    pre = "0";
//                    visited[pos[0]] = true;
//                    visited[pos[1]] = true;
//                    visited[pos[2]] = true;
//                    visited[pos[3]] = true;
//                    idx = -1;
//                    // for(int i = pos[0]-1; i >= 0; i--){
//                    //     if(arr.get(i) == 1 ){
//                    //         System.out.println(i);
//                    //         idx = i-1;
//                    //         break;
//                    //     }
//                    // }
//                }else{
//                    pre = "1";
//                    pos[0] = idx;
//                }
//            }else if(now == 2){
//                if(pre.equals("1")){
//                    pre+="2";
//                    pos[1] = idx;
//                }else{
//                    pre = "0";
//                }
//            }else if(now == 3){
//                if(pre.equals("12")){
//                    pre+="3";
//                    pos[2] = idx;
//                }else{
//                    pre = "0";
//                }
//            }
//            // if(idx == arr.size()-1){
//            //     break;
//            // }
//            idx++;
//        }
//        return answer;
//    }
}
