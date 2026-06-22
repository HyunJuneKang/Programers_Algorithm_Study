/*
심사원의 수 time.length
심사원 당 걸리는 시간 time[i]
사람수 n

최악의 경우
time = 가장 오래걸리는 시간 * n / 심사원의 수
Arrays.sort(time)
starttime = 1;
long end = (long) times[0] * n;
절반씩 줄이고 +-1로 범위를 쪼개면서 검사 , starttime >= endtime 이 되면 종료

*/
import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        long startTime = 0;
        long endTime = (long)times[0] * n;
        while(startTime <= endTime){
            System.out.println("startTime : " + startTime + "endTime : " + endTime);
            long midTime = (startTime + endTime) / 2;
            long sum = 0;
            for(int i = 0 ; i < times.length;i++){
                sum += (long)(midTime / times[i]);
            }
            if (sum >= n) {
                endTime = midTime - 1;
            } else {
                startTime = midTime + 1;
            }
        }
        
        return startTime;
    }
}