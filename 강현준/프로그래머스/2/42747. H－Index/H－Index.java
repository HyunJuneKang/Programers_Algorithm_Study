/*
n = size 
h-index <= size
 6 6 6 h-index = 3 why 
 1 2 3 h-index = 2 why
 0 1 3 5 6 
 
 Arrays.sort(citations)
 남은 개수  = size - 현재 index
 현재 value = arr[i]
 
 value 보다 작은것들.... ,value, value보다 큰것들....
 value는 남은개수 보다 크다 h-index가 아님 검사 ㄴ
 value가 남은개수 보다 작다 h-index 맞다 계속 검사
    ex) 1 10 10 10
        1은 통과 but 10은 작음 값은 4가 나와야함 그럼? 남은개수가 h-index가 되겠다<<<< 답
        10일때에는 위 if문에 걸리므로 위 if에 남은 size를 반환하면 답이 나온다.
 1 10 10 10
*/
import java.util.*;
class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        for ( int i = 0 ; i < citations.length ; i++){
            int curValue = citations[i]; //현재 값
            int leftCnt = citations.length - i - 1; //남은개수
            System.out.println("값 : " + curValue + " 남은 개수 " + leftCnt);
            if ( curValue >= leftCnt+1){
                answer = leftCnt+1;
                break;
            }
        }
        return answer;
    }
}