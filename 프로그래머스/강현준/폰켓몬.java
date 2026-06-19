import java.util.*;
class Solution {
    public int solution(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        for (int value : nums){
            hs.add(value);
        }
        
        int answer = 0;
        return Math.min(hs.size(),nums.length / 2);
    }
}

