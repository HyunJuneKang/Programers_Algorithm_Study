/*
boolean[x] 
1. 왼쪽 구석 if (j = 0)
             dp[i][j] = dp[i-1][j]
2. 오른쪽 구석
            if (j = triange[i].length-1)
3. dp[i][j] = Math.max(dp[i-1][j-1],dp[i-1][j]) + triangle[i][j];
*/

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int cntState = 0;
        for (int i = 0 ; i < triangle.length;i++){
            cntState += (i+1);
        }
        int[][] dp = new int[triangle.length][triangle[triangle.length-1].length];

        dp[0][0] = triangle[0][0];
            
        for (int i = 1 ; i < triangle.length;i++){
            for (int j = 0 ; j < triangle[i].length;j++){
                if (j == 0)
                    dp[i][j] = dp[i-1][j] + triangle[i][j];
                else if (j == triangle[i].length-1)
                    dp[i][j] = dp[i-1][j-1] + triangle[i][j];
                else
                    dp[i][j] = Math.max(dp[i-1][j-1],dp[i-1][j]) + triangle[i][j];
                
            }
        }
        for (int i = 0; i < dp[triangle.length-1].length;i++){
            answer = Math.max(answer,dp[triangle.length-1][i]);
        }        
        return answer;
    }
}

