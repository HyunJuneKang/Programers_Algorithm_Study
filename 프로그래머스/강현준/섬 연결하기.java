/*
싼거 순서대로 연결하기,  O(n) = costs의 길이 x 그룹 인지 판단
for (int [] land : costs)
    섬이 내 그룹안에 있으면
        연결 x
    섬이 내 그룹안에 없으면
        연결o

*/
import java.util.*;
class Solution {
    int[] parent;
    public int solution(int n, int[][] costs) {
        int answer = 0;
        parent = new int[n];
        for ( int i  = 0 ; i < n; i++){
            parent[i] = i;
        }
        Arrays.sort(costs,(a,b)->a[2]-b[2]);
        
        for(int i = 0 ; i < costs.length; i++){
        
            if (find(costs[i][0]) == find(costs[i][1]))
                continue;
            connect(costs[i][0],costs[i][1],n);
            answer+= costs[i][2];
            
        }
        return answer;
    }
    private int find(int idx){
        return parent[idx]; //부모 번호 반환
    }
    private void connect(int n,int m,int countlands){
        int parentM = find(m);
        for (int i = 0 ; i < countlands; i++){
            if (parent[i] == find(n) || parent[i] == parentM)
                parent[i] = find(n);
        }
        parent[m] = find(n);
    }
}