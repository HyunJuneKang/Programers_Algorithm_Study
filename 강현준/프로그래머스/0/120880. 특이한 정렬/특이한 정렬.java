/*
sort기준을 n을 기준으로 해서 sort해야함
return abs(a-n) - abs (b-n)
abs(a-n) 이 abs(b-n) 이랑 같으면
return b-a
*/
import java.util.*;
class Solution {
    public int[] solution(int[] numlist, int n) {
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0 ; i < numlist.length; i++){
            arr.add(numlist[i]);
        }
        
        Collections.sort(arr,new Comparator<Integer>(){
            @Override
            public int compare(Integer a , Integer b) {
                if (Math.abs(a-n) == Math.abs(b-n))
                    return b-a;
                return Math.abs(a-n) - Math.abs(b-n);
            }
        });
        int [] answer = new int[arr.size()];
        for (int i = 0 ; i < arr.size();i++){
            answer[i] = arr.get(i);
        }
        return answer;
    }
}