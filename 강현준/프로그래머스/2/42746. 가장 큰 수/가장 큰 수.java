/*
방법 1 완전탐색
정수의 길이! >> 터짐

방법 2 Greedy 최선의 수를 찾자
1.앞의 수가 가장 큰걸 찾는다
6 10 2 , 맨앞자리 찾기 ->> 10^자릿수로 나눠버리기 , 자릿수? 10으로 나눠서 판단 0이 될때까지 나눠버리기
6택하기>2택하기>10택하기 6210
2.앞의수가 같으면?
3 30 34 -> 3 0 4 -> 4 3 0순으로 택하기 어캐만듬? 같은 수 끼리 앞자리수 * 10으로 %하기 3 0 4
=======복잡합================
그냥 이어 붙일때 큰거 순으로 이어 붙이기

*/
import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        ArrayList<Integer>arr = new ArrayList<>();
        for(int i = 0 ; i < numbers.length; i++){
            arr.add(numbers[i]);
        }
        Collections.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                String ab = a + "" + b;
                String ba = b + "" + a;

                return ba.compareTo(ab);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i < arr.size(); i++){
           sb.append(arr.get(i).toString()); 
        }
        String answer = sb.toString();
        if (arr.get(0) == 0)
            return "0";
        else 
            return answer;
    }
}