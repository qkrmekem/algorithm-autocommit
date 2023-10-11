package programmers;

import java.util.*;

public class Pro_폰켓몬 {
    public int solution(int[] nums) {
        int answer = 0;

        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < nums.length; i++){
            set.add(nums[i]);
        }

        int n = nums.length / 2;

        if(n>set.size()){
            return set.size();
        }

        return n;
    }
}
