/*
array가 [1, 5, 2, 6, 3, 7, 4], i = 2, j = 5, k = 3
array의 2번째부터 5번째까지 자르면 [5, 2, 6, 3]입니다. arr만들기 i = 2;i < j+1 ;i++
1에서 나온 배열을 정렬하면 [2, 3, 5, 6]입니다.   Arrays.sort()
2에서 나온 배열의 3번째 숫자는 5입니다.    int num = arr[n-1]
*/
import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        ArrayList<Integer>result = new ArrayList<>();
        for ( int i = 0 ; i < commands.length;i++){
            int startPos = commands[i][0]-1;
            int endPos = commands[i][1]-1;
            int targetPos = commands[i][2];
            //자르기
            int []newArr = new int[endPos-startPos+1];
            int index = 0;
            for (int j = startPos; j < endPos+1;j++){
                newArr[index++] = array[j];
            }
            // 정렬
            Arrays.sort(newArr);
            // target 찾기
            int targetNum = newArr[targetPos-1];
            // 결과 저장
            result.add(targetNum);
        }
        
        int[] answer = new int[result.size()];
        for (int i = 0 ; i < result.size(); i++){
            answer[i] = result.get(i);
        }
        return answer;
    }
}