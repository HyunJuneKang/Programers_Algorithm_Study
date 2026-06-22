import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        StringBuilder sb = new StringBuilder();
        String[] arr = new String[numbers.length];
        for (int i = 0 ; i < numbers.length;i++){
            arr[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b));
        
        if (arr[0].equals("0")) {
            return "0";
        }
        for (int i = 0 ; i < numbers.length;i++){
            sb.append(arr[i]);
        }
        return sb.toString();
    }
}