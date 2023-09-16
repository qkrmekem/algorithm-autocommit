package programmers;

import java.util.*;
import java.util.stream.*;

public class Pro_숫자짝궁 {

    public String solution(String X, String Y) {
        String answer = "";

        int[] x = new int[10];
        int[] y = new int[10];

        for(String tmp : X.split("")){
            x[Integer.parseInt(tmp)]++;
        }

        for(String tmp : Y.split("")){
            y[Integer.parseInt(tmp)]++;
        }

        StringBuffer sb = new StringBuffer();

        for(int i = 9; i >= 0; i--){
            int min = Math.min(x[i],y[i]);
            sb.append(String.valueOf(i).repeat(min));
        }

        if(sb.length() == 0){
            answer = "-1";
        }else if(sb.toString().charAt(0) == '0'){
            answer = "0";
        }else{
            answer = sb.toString();
        }

        return answer;
    }

    // map으로 해결
    public String solution2(String X, String Y) {
        Map<String, Integer> xMap = new HashMap<>();
        Map<String, Integer> yMap = new HashMap<>();

        List<String> list = new ArrayList<>();

        for(String key: X.split("")) {
            xMap.put(key, xMap.getOrDefault(key, 0)+1);
        }

        for(String key: Y.split("")) {
            yMap.put(key, yMap.getOrDefault(key, 0)+1);
        }

        for(String key: xMap.keySet()) {
            if(!yMap.containsKey(key)) continue;

            int length = Math.min(xMap.get(key), yMap.get(key));
            for(int i = 0; i < length; i++) {
                list.add(key);
            }
        }

        String result = list.stream()
                .sorted(Collections.reverseOrder())
                .collect(Collectors.joining());

        if(result.isEmpty()) return "-1";
        if(result.replaceAll("0", "").isEmpty()) return "0";
        return result;
    }

//    틀린 풀이
//    public String solution(String X, String Y) {
//        String answer = "";
//        String start = "";
//        String end = "";
//        if(X.length() < Y.length()){
//            start = X;
//            end = Y;
//        }else{
//            start = Y;
//            end = X;
//        }
//
//        List<Integer> arr = new ArrayList<>();
//        for(int i = 0; i < start.length(); i++){
//            if(start.substring(i,i+1).equals(end.substring(i,i+1))){
//                arr.add(Integer.parseInt(start.substring(i,i+1)));
//                end.replace(start.substring(i,i+1), " ");
//            }
//        }
//        System.out.println(arr.size());
//        return answer;
//    }
}
