/*

*/
import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        int posCamera = Integer.MIN_VALUE;
        Arrays.sort(routes,(a,b)->a[1]-b[1]);
        for(int i = 0 ; i < routes.length; i++){
            if (routes[i][0] > posCamera){
                answer++;
                posCamera = routes[i][1];
            }
        }
        
        return answer;
    }
}