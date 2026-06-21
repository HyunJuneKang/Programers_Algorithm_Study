/*
1,2,3,2,3

prices[idx] = price
0 1 2 3 4
stk.peek() = curprice
---------------------------------------------------
현재 주식 가격 = 0
주식 리스트 반복
    현재 주식 가격 <= 넣을 주식 가격 1->2->3
        넣기
    현재 주식 가격 > 넣을 주식 가격 3->2
        2보다 작은거 다 빼서 answer에 넣을 idx - 작은 idx 저장
        2 저장
반복끝
    남은 stkIdx는 answer에 길이 - 현재 idx - 1 저장
---------------------------------------------------
*/
import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        ArrayDeque<Integer>stk = new ArrayDeque<>();
        for ( int i = 0 ; i < prices.length ; i++){
            if (stk.isEmpty()){
                stk.push(i);
            } else{
                if (prices[stk.peek()] <= prices[i]){
                    stk.push(i);
                } else{
                    while(!stk.isEmpty() && prices[stk.peek()] > prices[i]){
                        int idx = stk.pop();
                        answer[idx] = i - idx;
                    }
                    stk.push(i);
                }
            }
        }
        
        while (!stk.isEmpty()){
            int idx = stk.pop();
            answer[idx] = prices.length - idx - 1;
        }
        return answer;
    }
}