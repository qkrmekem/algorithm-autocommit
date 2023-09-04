package programmers;

import java.util.HashMap;
import java.util.Map;

public class Pro_추억점수 {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] result = new int[photo.length];
        Map<String, Integer> list = new HashMap<>();
        for(int i = 0; i < name.length; i++){
            list.put(name[i], yearning[i]);
        }
        for(int i = 0; i < photo.length; i++){
            int tmp = 0;
            for(int y = 0; y < photo[i].length; y++){
                String now = photo[i][y];
                Integer count = list.get(now);
                if(count == null){
                    continue;
                }
                tmp+=count;
            }
            result[i] = tmp;
        }

        return result;
    }
}
