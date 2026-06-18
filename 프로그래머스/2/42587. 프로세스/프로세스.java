// 문제에 실행 대기 큐라고 대놓고 나옴
// 앞에서 꺼내고(poll), 우선순위 낮으면 뒤로 다시 넣는(offer) FIFO + 재삽입 패턴

import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<int[]> queue = new LinkedList<>(); // {원래 인덱스, 우선순위}
        for (int i = 0; i < priorities.length; i++) {
            queue.offer(new int[]{i, priorities[i]});
        }

        int order = 0;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            boolean hasHigher = false;
            for (int[] other : queue) {        // 큐에 남은 것들과 비교
                if (other[1] > cur[1]) {
                    hasHigher = true;
                    break;
                }
            }

            if (hasHigher) {
                queue.offer(cur);              // 우선순위 낮음 → 뒤로
            } else {
                order++;                       // 실행
                if (cur[0] == location) {
                    return order;
                }
            }
        }
        return order; // 도달하지 않음 (location은 항상 존재)
    }
}