package solution;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution {

	static boolean [] visited;
	static List <Integer>[] node;
	public static void main(String[] args) {
		int [][] edge = {{1,2},{1,3},{1,4},{2,4},{3,4}};
		int [][] result = solution(4,5,1,edge);
		System.out.println(Arrays.toString(result[0]));
		System.out.println(Arrays.toString(result[1]));
	}

	private static int[][] solution(int n,int m,int v,int[][] edges) {
		Arrays.sort(edges,(a,b)->a[0]-b[0]);
		ArrayList<Integer> dfsResult = new ArrayList<Integer>();
		ArrayList<Integer> bfsResult = new ArrayList<Integer>();
		node = new ArrayList[n+1];
		visited = new boolean[n+1];
		for (int i = 1 ; i <= n;i++) {
			node[i] = new ArrayList<Integer>();
		}
		for ( int[] edge : edges) {
			node[edge[0]].add(edge[1]);
			node[edge[1]].add(edge[0]);
		}

		visited[v] = true;
		dfsResult.add(v);
		dfs(v,dfsResult);
		for(int i = 0 ; i < n+1; i++) {
			visited[i] = false;
		}
		Deque<Integer> visitList = new ArrayDeque<>();
		visitList.add(v);
		visited[v] = true;
		while(!visitList.isEmpty()) {
			int curNode = visitList.pop();
			bfsResult.add(curNode);
			for (int nextNode : node[curNode]) {
				if(visited[nextNode])
					continue;
				visited[nextNode] = true;
				visitList.offer(nextNode);
			}
		}
		int [][] result = new int[2][];
		result = new int[2][dfsResult.size()];
		
		for(int i = 0 ; i < dfsResult.size();i++) {
			result[0][i] = dfsResult.get(i);
		}
		for(int i = 0 ; i < bfsResult.size();i++) {
			result[1][i] = bfsResult.get(i);
		}
		return result;
	}


	private static void dfs(int curNode, ArrayList<Integer> result) {
		for(int nextNode : node[curNode]) {
			if(visited[nextNode])
				continue;
			else {
				//방문노드에 추가
				result.add(nextNode);
				//방문체크
				visited[nextNode] = true;
				//방문하기
				dfs(nextNode,result);
			}
		}
	}

}
