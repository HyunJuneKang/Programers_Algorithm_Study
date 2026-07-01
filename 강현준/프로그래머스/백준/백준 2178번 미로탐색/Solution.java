package solution;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class Solution {

	static boolean [] visited;
	static List <Integer>[] node;
	public static void main(String[] args) {
		int [][] edges = {{1,0,1,1,1,1},{1,0,1,0,1,0},{1,0,1,0,1,1},{1,1,1,0,1,1}};
		int result = solution(4,6,edges);
		System.out.println(result);
	}

	private static int solution(int n,int m,int[][] edges) {
		boolean [][] visited = new boolean[edges.length+1][edges[0].length+1];
		Deque<int[]> visitList = new ArrayDeque<>();
		visitList.offer(new int[] {0,0,1});
		visited[0][0] = true;
		int[] dx = {0, -1, 1, 0};
		int[] dy = {1, 0, 0, -1};
		while(!visitList.isEmpty()) {
			int[] curNode = visitList.poll();
			int curX = curNode[0];
			int curY = curNode[1];
			int depth = curNode[2];
			//목표지점 도달이면 그냥 depth return
			if(curX == n-1 && curY == m-1) {
				return depth;
			}

			// 아래, 왼쪽, 오른쪽, 위 순서
			for (int i = 0; i < 4; i++) {
			    int nx = curX + dx[i];
			    int ny = curY + dy[i];
			    if (nx < 0 || nx >= edges.length) continue;
			    if (ny < 0 || ny >= edges[0].length) continue;
			    if (edges[nx][ny] == 0) continue;
			    if (visited[nx][ny]) continue;

			    visited[nx][ny] = true;
			    visitList.offer(new int[] {nx, ny, depth + 1});
			}
		}
		return -1;
	}



}
