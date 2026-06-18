// 열렸으면 반드시 닫혀야 한다 -> 짝 맞추기 -> 스택

// 이 문제는 괄호 종류가 ( ) 한 종류뿐이라 사실 스택 대신 정수 카운터 하나로도 풀 수 있음

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    boolean solution(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);          // 열린 괄호는 쌓는다
            } else {                    // c == ')'
                if (stack.isEmpty()) {  // 규칙 1: 닫을 짝이 없음
                    return false;
                }
                stack.pop();            // 짝을 맞춰 하나 제거
            }
        }
        return stack.isEmpty();         // 규칙 2,3: 남은 게 없어야 true
    }
}
