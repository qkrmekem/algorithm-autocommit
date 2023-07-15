package programmers;

import java.util.*;

public class programmers_개인정보수집유효기간 {
    // 풀이 1
    public Integer[] solution(String today, String[] terms, String[] privacies) {
        Integer[] answer = {};
        List<Integer> list = new ArrayList<>();

        Map<String,Integer> map = new HashMap<>();
        for(int i = 0; i < terms.length; i++){
            String tmp = terms[i].split(" ")[0];
            Integer term = Integer.parseInt(terms[i].split(" ")[1]);
            map.put(tmp, term);
        }

        Integer toDayYear = Integer.parseInt(today.split("\\.")[0])*12*28;
        Integer toDayMonth = Integer.parseInt(today.split("\\.")[1])*28;
        Integer toDayDay = Integer.parseInt(today.split("\\.")[2]);

        Integer toDayTotal = toDayYear + toDayMonth + toDayDay;

        for(int y = 0; y < privacies.length; y++){
            String tmpEx = privacies[y].split(" ")[0];
            Integer years = Integer.parseInt(privacies[y].split(" ")[0].split("\\.")[0])*12*28;
            Integer months = Integer.parseInt(privacies[y].split(" ")[0].split("\\.")[1])*28;
            Integer days = Integer.parseInt(privacies[y].split(" ")[0].split("\\.")[2]);
            String ttmp = privacies[y].split(" ")[1];

            int term = map.get(ttmp)*28;

            Integer expireDay = years + months + days + term;
            if(toDayTotal >= expireDay){
                list.add(y+1);
            }
        }

        answer = list.toArray(new Integer[0]);


        return answer;
    }

    // 풀이 2
    public Integer[] solution2(String today, String[] terms, String[] privacies) {
        Integer[] answer = {};
        List<Integer> list = new ArrayList<>();

        Map<String,Integer> map = new HashMap<>();
        for(int i = 0; i < terms.length; i++){
            String tmp = terms[i].split(" ")[0];
            Integer term = Integer.parseInt(terms[i].split(" ")[1]);
            map.put(tmp, term);
        }

        for(int y = 0; y < privacies.length; y++){
            String tmpEx = privacies[y].split(" ")[0];
            Integer years = Integer.parseInt(privacies[y].split(" ")[0].split("\\.")[0]);
            Integer months = Integer.parseInt(privacies[y].split(" ")[0].split("\\.")[1]);
            Integer days = Integer.parseInt(privacies[y].split(" ")[0].split("\\.")[2]);
            String ttmp = privacies[y].split(" ")[1];

            int term = map.get(ttmp);

            if(term >= 12){
                years += (term/12);
                if((term%12) == 0){
                }else if((term%12)+months>12){
                    years+=1;
                    months = (term%12)+(months-12);
                }else{
                    months += (term%12);
                }
            }else if(term+months>12){
                years += 1;
                months = term + (months - 12);
            }else{
                months += term;
            }
            String tempToDay = today.replace(".","");
            Integer toDayTotal = Integer.parseInt(tempToDay);
            Integer expireDay = (years*10000) + (months*100) + days;
            System.out.println(expireDay-1);
            if(toDayTotal >= expireDay){
                list.add(y+1);
            }
        }

        answer = list.toArray(new Integer[0]);


        return answer;
    }
}
