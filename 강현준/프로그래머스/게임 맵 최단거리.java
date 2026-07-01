import java.util.*;
class Solution {
    static class Status{
        int x;
        int y;
        int distance; //depth

        Status(int x ,int y, int distance){
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
    static boolean[][] isVisited;
    static int[] dx = {1 , 0 , -1 , 0};
    static int[] dy = {0 , 1 ,  0 , -1};
    
    
    
    
    
    // 해당 좌표의 depth 무조건 최단 cost? 라 하겠습니
    // 필요한 정보 좌표
    public int solution(int[][] maps) {
        isVisited = new boolean[maps.length][maps[0].length];
        Deque<Status> dq = new ArrayDeque<>();
        dq.offer(new Status(0, 0, 1));
        isVisited[0][0] = true;
        while(!dq.isEmpty()){
            Status curPos = dq.poll();
            if(curPos.x == maps.length-1 && curPos.y == maps[0].length-1 ){
                return curPos.distance;
            }
            //for문을 안쓰면 

            for(int i = 0; i < 4; i++){
                int nx = curPos.x + dx[i]; 
                int ny = curPos.y + dy[i];
                
                if(nx < 0 || nx >= maps.length || ny < 0 || ny >= maps[0].length) 
	                continue;
                if(isVisited[nx][ny]) continue;
                if(maps[nx][ny] == 0) continue;
                
                dq.offer(new Status(nx,ny,curPos.distance+1));
                isVisited[nx][ny] = true;
            }
        }
        return -1;
    }
}