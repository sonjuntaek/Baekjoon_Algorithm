package BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class FindTreeParent {
	static int[] answerArr;
	static boolean[] visited;
	static LinkedList<Integer>[] adjList;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		visited = new boolean[n + 1];
		answerArr = new int[n + 1];
		adjList = new LinkedList[n + 1];
		for (int i = 1; i <= n; i++) {
			adjList[i] = new LinkedList<Integer>();
		}
		for (int i = 1; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int e1 = Integer.parseInt(st.nextToken());
			int e2 = Integer.parseInt(st.nextToken());
			adjList[e1].add(e2);
			adjList[e2].add(e1);
		}
		BFS(1);
		for (int i = 2; i < answerArr.length; i++) {
			System.out.println(answerArr[i]+" ");
		}
	}

	public static void BFS(int startNode) {
		Queue<Integer> que = new LinkedList<Integer>();
		que.add(startNode);
		visited[startNode] = true;
		while (!que.isEmpty()) {
			int pollNum = que.poll();
			LinkedList<Integer> visitList = adjList[pollNum];
			for (int i = 0; i < visitList.size(); i++) {
				if (visited[visitList.get(i)] == false) {
					visited[visitList.get(i)] = true;
					answerArr[visitList.get(i)] = pollNum;
					que.add(visitList.get(i));
				}
			}
		}
	}
}
