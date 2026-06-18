import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Deque<Integer> dq = new ArrayDeque<>();
        
        for (int i = 0; i < progresses.length; i++) {
            int leftDay = (int)Math.ceil((100.0 - progresses[i]) / speeds[i]);
            dq.offer(leftDay);
        }

        ArrayList<Integer> result = new ArrayList<>();
        // 5 10 1 1 20 1 (5)
        // 10 1 1 1 20 1
        //
        int firstNum = dq.pop();
        int function = 1;
        while(!dq.isEmpty()){
            if(firstNum < dq.peek()){
                result.add(function);
                function = 1;
                firstNum = dq.poll();
            } else{
                function++;
                dq.poll();
            }
        }
        result.add(function);
        
        int answer[] = new int[result.size()];
        for(int i = 0 ; i < answer.length; i++){
            answer[i] = result.get(i);
        }
        return answer;
    }
}