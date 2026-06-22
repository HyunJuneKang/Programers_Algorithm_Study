import java.util.*;
class Solution {
    public int[] solution(int[] numlist, int n) {
        Integer[] numArr = new Integer[numlist.length];
        for(int i = 0; i < numlist.length;i++){
            numArr[i] = numlist[i];
        }
        
        Arrays.sort(numArr, (a, b) -> {
            int diff = Math.abs(a - n) - Math.abs(b - n);
            if (diff == 0 ){
                return b-a;
            } 
            return diff;
        }); 
        
        int[] answer = new int[numArr.length];
        for(int i = 0; i < numlist.length;i++){
            answer[i] = numArr[i];
        }
        return answer;
    }
}