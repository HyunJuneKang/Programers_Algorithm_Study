/*
단방향 그래프
모든 노드 순회
해당 노드로 부터 타고 내려가서 사람이 체크가 되는지
해당 노드로 부터 타고 올라가서 사람이 체크가 되는지
체크가 되는 사람이 자기 빼고 전부다 존재 => result++
*/
import java.util.*;
class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        ArrayList<Integer>[] arr = new ArrayList[n+1];
        ArrayList<Integer>[] reverseArr = new ArrayList[n+1];
        for (int i = 0 ; i < arr.length; i++){
            arr[i] = new ArrayList<>();
            reverseArr[i] = new ArrayList<>();
        }
        // 단방향 그래프 만들기
        for (int i = 0 ; i < results.length;i++){
            arr[results[i][0]].add(results[i][1]);
            reverseArr[results[i][1]].add(results[i][0]);
        }
        for (int i = 1 ; i < n+1 ; i++){
            HashSet<Integer> hs = new HashSet<>();
            boolean[] visited = new boolean[n+1];
            upperDfs(i,hs,reverseArr,visited);
            downDfs(i,hs,arr,visited);
            if(hs.size() == n-1)
                answer++;
        }
        return answer;
    }
    private void upperDfs(int n,HashSet<Integer> hs,ArrayList<Integer>[] arr,boolean[] visited){
        //자신으로부터 위로 올라간다
        for(int nextNode : arr[n]){
            if (visited[nextNode])
                continue;
            hs.add(nextNode);
            visited[nextNode] = true;
            upperDfs(nextNode,hs,arr,visited);
        }
    }
    private void downDfs(int n,HashSet<Integer> hs,ArrayList<Integer>[] arr,boolean[] visited){
        //자신으로부터 위로 올라간다
        for(int nextNode : arr[n]){
            if (visited[nextNode])
                continue;
            hs.add(nextNode);
            visited[nextNode] = true;
            downDfs(nextNode,hs,arr,visited);
        }
    }
}