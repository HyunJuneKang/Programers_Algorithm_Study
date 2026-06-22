import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        
        int N = commands.length;
        int [] arrAns = new int[N];
        for (int i = 0; i < N ; i++){
            int startPos = commands[i][0]-1;
            int endPos = commands[i][1]-1;
            int K = commands[i][2];
            int [] arrDivide = new int[endPos-startPos+1];
            
            int j = 0;
            for (int k = startPos; k <= endPos;k++){
                arrDivide[j] = array[k];
                j++;
            }

            Arrays.sort(arrDivide);
            arrAns[i] = arrDivide[K-1];
            
        }
        return arrAns;
    }
}