/*
1 2 3 4 5 6 7 8 지우기 7 8, 추가 9
2 3 4 5 6 9 만들고 싶은것
minPq
2 3 4 5 6 7 8 9
maxPq 
1 2 3 4 5 6 9
둘 pq가 겹치는거 보여주기 
------------- 불가 --------- 너무 오래걸림
차라리 살아있는거 개수 cnt 2 3 4 5 6 9 >>>
Key Value
 2   1
 3   1
 4   1
 5   1
 6   1
 9   1
------------
추가 둘 pq 추가: map 에 해당 값 map에 갱신 ++ or 1
max 지우기
    이미 min에 의해 지워진 값 map.get(key) == 0 이면 즉 map.getOrDefault(key,0) == 0 이면
        pq.poll();
    else
        pqMax.poll() 의 값 map에 갱신 min(value--,0)
min 지우기 
    이미 min에 의해 지워진 값 map.get(key) == 0 이면 즉 map.getOrDefault(key,0) == 0 이면
        pq.poll();
    else
        pqMin.poll() 의 값 min에 갱신 min(value--,0)

ArrayList 에 값 넣기 value만큼 반복
arr.size == 0 -> [0,0]
else 
arr.sort();
작은 값 : arr.get(0)
큰 값 : arr.get(arr.size()-1)
*/

import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>((a, b) -> b - a);
        HashMap<Integer,Integer> hm = new HashMap<>();
        for (int i = 0 ; i < operations.length; i++){
            char operation = operations[i].charAt(0);
            switch (operation){
                    case 'I'->{
                        //삽입
                        String[] operArr = operations[i].split(" ");
                        int data = Integer.parseInt(operArr[1]);
                        minPQ.offer(data);
                        maxPQ.offer(data);
                        hm.put(data,hm.getOrDefault(data,0) + 1);
                    }
                    case 'D'->{
                        String[] operArr = operations[i].split(" ");
                        if (operArr[1].equals("1")){
                            //최대값 삭제
                            while (!maxPQ.isEmpty() && hm.getOrDefault(maxPQ.peek(),0) == 0){
                                maxPQ.poll();
                            }
                            if(!maxPQ.isEmpty()){
                                int data = maxPQ.poll();
                                hm.put(data,hm.get(data)-1);
                            }
                        } else{
                            //최솟값 삭제
                            while (!minPQ.isEmpty() && hm.getOrDefault(minPQ.peek(),0) == 0){
                                minPQ.poll();
                            }
                            if(!minPQ.isEmpty()){
                                int data = minPQ.poll();
                                hm.put(data,hm.get(data)-1);
                            }
                        }
                    }
            }
        }
        
        ArrayList<Integer> resultArr = new ArrayList<>();
        for(int data : hm.keySet()){
            int cnt = hm.get(data);
            if (cnt != 0){
                for (int i = 0 ; i < cnt; i++){
                    resultArr.add(data);
                }
            }
        }
        Collections.sort(resultArr);
        int[] answer = new int[2];
        if(resultArr.size() == 0){
            answer[0] = 0;
            answer[1] = 0;
        } else{
            answer[0] = resultArr.get(resultArr.size()-1);
            answer[1] = resultArr.get(0);
        }
        return answer;
    }
}