import java.util.*;

class Solution {

    static boolean[][] visited;
    static int[][] dir = {
        {1, 0},
        {-1, 0},
        {0, 1},
        {0, -1}
    };

    static int[] columnCount;

    public int solution(int[][] land) {

        int height = land.length;
        int width = land[0].length;

        visited = new boolean[height][width];
        columnCount = new int[width];

        // 맵 전체를 한 칸씩 탐색
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {

                // 석유가 아니거나 이미 방문한 석유면 넘어감
                if (land[y][x] == 0 || visited[y][x]) {
                    continue;
                }

                // 새로운 석유 덩어리 발견
                bfs(y, x, land);
            }
        }

        int answer = 0;

        // 각 열에 시추관을 꽂았을 때 얻는 석유량 중 최댓값
        for (int count : columnCount) {
            answer = Math.max(answer, count);
        }

        return answer;
    }

    private void bfs(int startY, int startX, int[][] land) {

        ArrayDeque<int[]> q = new ArrayDeque<>();

        // 현재 석유 덩어리가 어떤 열에 걸쳐 있는지 저장
        Set<Integer> columns = new HashSet<>();

        int oilCount = 0;

        q.offer(new int[]{startY, startX});
        visited[startY][startX] = true;

        while (!q.isEmpty()) {

            int[] cur = q.poll();

            int curY = cur[0];
            int curX = cur[1];

            // 현재 덩어리 크기 증가
            oilCount++;

            // 현재 덩어리가 지나가는 열 기록
            columns.add(curX);

            for (int[] d : dir) {

                int nextY = curY + d[0];
                int nextX = curX + d[1];

                // 범위 밖
                if (nextY < 0 ||
                    nextX < 0 ||
                    nextY >= land.length ||
                    nextX >= land[0].length) {
                    continue;
                }

                // 이미 방문
                if (visited[nextY][nextX]) {
                    continue;
                }

                // 석유가 아님
                if (land[nextY][nextX] == 0) {
                    continue;
                }

                visited[nextY][nextX] = true;
                q.offer(new int[]{nextY, nextX});
            }
        }

        // 이 덩어리가 걸쳐 있던 모든 열에
        // 덩어리 전체 크기를 더함
        for (int col : columns) {
            columnCount[col] += oilCount;
        }
    }
}