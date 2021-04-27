package DFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ABCDE {
	static ArrayList<Integer>[] adjList;
	static boolean[] visited;
	static boolean find = false;
	static int depth = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		adjList = new ArrayList[N];
		visited = new boolean[N];
		for (int i = 0; i < adjList.length; i++) {
			adjList[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			adjList[v1].add(v2);
			adjList[v2].add(v1);
		}
		

		//어느 특정한 정점을 기준으로 시작하느냐에 따라 깊이가 다르게 나오므로,모든 정점을 기준으로 DFS실행.
		for (int i = 0; i < N; i++) {
			DFS(i, 1);
		}
		System.out.println(0);
	}
	
	
	public static void DFS(int startVertex, int depth) {
		if (depth >= 5) {
			System.out.println(1);
			System.exit(0);
			return;
		}
		visited[startVertex] = true;
		for (int i : adjList[startVertex]) {
			if (visited[i] == false) {
				visited[i] = true;
				DFS(i, depth + 1);
				visited[i] = false;//기존 경로에서 다른 경로에도 갈 경우의 수를 생각해야하므로
				//백 트래킹 개념.
			}
		}
		visited[startVertex] = false;//시작 정점이 모두 다르게 할 것이므로, 시작정점도 초기화 필요.
		//특정 정점마다의 깊이를 봐야하므로
	}
}
