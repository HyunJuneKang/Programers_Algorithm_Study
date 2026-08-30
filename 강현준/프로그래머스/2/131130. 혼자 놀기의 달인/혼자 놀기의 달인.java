import java.util.*;

class Solution {
    public int solution(int[] cards) {

        HashSet<Integer> saveNum = new HashSet<>();

        ArrayList<Integer>[] arr = new ArrayList[cards.length];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = new ArrayList<>();
        }

        int i = 0;
        int idx = 0;

        while (idx < cards.length) {

            // 이미 다른 그룹에서 사용한 상자면 다음 상자로
            if (saveNum.contains(idx)) {
                idx++;
                continue;
            }

            // 새로운 그룹 시작
            while (true) {

                // 현재 상자를 이미 열었다면 사이클 종료
                if (saveNum.contains(idx)) {
                    break;
                }

                saveNum.add(idx);
                arr[i].add(idx);

                int nextIdx = cards[idx] - 1;

                idx = nextIdx;
            }

            i++;

            // 아직 방문하지 않은 다음 상자 찾기
            idx = 0;

            while (idx < cards.length && saveNum.contains(idx)) {
                idx++;
            }
        }

        int first = 0;
        int second = 0;

        for (ArrayList<Integer> group : arr) {

            int size = group.size();

            if (size > first) {
                second = first;
                first = size;
            } else if (size > second) {
                second = size;
            }
        }

        return first * second;
    }
}