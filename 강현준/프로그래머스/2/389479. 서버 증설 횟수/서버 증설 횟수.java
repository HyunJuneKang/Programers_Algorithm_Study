/*
게임을 이용하는 사람이 m명 늘어날 때마다 서버 1대가 추가로 필요합니다
예를 들어, k = 5 일 때 10시에 증설한 서버는 10 ~ 15시에만 운영
하루 동안 모든 게임 이용자가 게임을 하기 위해 서버를 최소 몇 번 증설해야 하는지 알고 싶습니다. 
같은 시간대에 서버를 x대 증설했다면 해당 시간대의 증설 횟수는 x회

players[i] / 3 = 필요한 서버의 수
Queue에 서버 넣어
서버의 수 , 넣을때 시간

*/
import java.util.*;
class Server{
    int time;
    int cnt;
    Server(int time,int cnt){
        this.time = time;
        this.cnt = cnt;
    }
}
class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        List<Server> serverList = new LinkedList<>();
        for (int i = 0 ; i < players.length; i++){
            
            if (serverList.size() != 0){
                Server curServer = serverList.get(0);
                if(i - curServer.time == k)
                    serverList.remove(0);
            }
            int totalServer = countServer(serverList);
            int needServer = players[i] / m;
            // 0보다 작으면 작은 값만큼 서버증설 , cnt++
            int resultServer = needServer - totalServer;
            if (resultServer > 0){
                serverList.add(new Server(i,resultServer));
                answer+= resultServer;
            }
        }
        
        return answer;
    }
    public static int countServer(List<Server> serverList){
        int total = 0;
        if(serverList.size() == 0)
            return 0;
        for (int i = 0; i< serverList.size(); i++){
            total += serverList.get(i).cnt;
        }
        return total;
    }
}