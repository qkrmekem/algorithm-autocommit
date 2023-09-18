package programmers;

import java.util.*;

public class Pro_성격유형검사하기 {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        Map<String,Integer> map = new HashMap<>();
        map.put("R", 0);
        map.put("T", 0);
        map.put("C", 0);
        map.put("F", 0);
        map.put("J", 0);
        map.put("M", 0);
        map.put("A", 0);
        map.put("N", 0);

        for(int i = 0; i < survey.length; i++){
            String fir = survey[i].split("")[0];
            String sec = survey[i].split("")[1];
            int point = choices[i];
            int tmp = 0;
            if(point == 1){
                tmp = map.get(fir);
                map.put(fir,tmp+3);
            }else if(point == 2){
                tmp = map.get(fir);
                map.put(fir,tmp+2);
            }else if(point == 3){
                tmp = map.get(fir);
                map.put(fir,tmp+1);
            }else if(point == 4){

            }else if(point == 5){
                tmp = map.get(sec);
                map.put(sec,tmp+1);
            }else if(point == 6){
                tmp = map.get(sec);
                map.put(sec,tmp+2);
            }else if(point == 7){
                tmp = map.get(sec);
                map.put(sec,tmp+3);
            }
        }

        StringBuffer sb = new StringBuffer();
        if(map.get("R") > map.get("T")){
            sb.append("R");
        }else if(map.get("R") < map.get("T")){
            sb.append("T");
        }else{
            sb.append("R");
        }

        if(map.get("C") > map.get("F")){
            sb.append("C");
        }else if(map.get("C") < map.get("F")){
            sb.append("F");
        }else{
            sb.append("C");
        }

        if(map.get("J") > map.get("M")){
            sb.append("J");
        }else if(map.get("J") < map.get("M")){
            sb.append("M");
        }else{
            sb.append("J");
        }

        if(map.get("A") > map.get("N")){
            sb.append("A");
        }else if(map.get("A") < map.get("N")){
            sb.append("N");
        }else{
            sb.append("A");
        }

        return sb.toString();
    }
}
