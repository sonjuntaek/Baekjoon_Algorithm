package BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BipartiteGraph {
	static int[] colors;
	static ArrayList<Integer>[] adjList;
	static boolean isBipartiteGraph = true;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCaseN = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < testCaseN; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int vertexN = Integer.parseInt(st.nextToken());
			int edgeN = Integer.parseInt(st.nextToken());
			isBipartiteGraph = true;

			colors = new int[vertexN + 1];// 1~N까지 무슨 색인지 체크하는 배열. 0 : 미방문, 1 : 빨, -1 : 파

			adjList = new ArrayList[vertexN + 1];// 인접리스트 초기화.
			for (int j = 1; j < adjList.length; j++) {
				adjList[j] = new ArrayList<Integer>();
			}

			// 간선 입력받음
			for (int j = 0; j < edgeN; j++) {
				st = new StringTokenizer(br.readLine());
				int v1 = Integer.parseInt(st.nextToken());
				int v2 = Integer.parseInt(st.nextToken());
				adjList[v1].add(v2);
				adjList[v2].add(v1);
			}

			// 각 정점에 대해서 BFS or DFS 수행하면서 이분 그래프 만족하는지 안하는지 살펴봄.
			for (int j = 1; j <= vertexN; j++) {
				if (!isBipartiteGraph) {// 이미 이분그래프가 아니라고 결정되면 루프 종료.
					break;
				}
				if (colors[j] == 0) {
					// 방문하지 않은것들이 있을 수 있음.(비연결 그래프) 걔네들은 방문이 안되니까 따로 해줘야함.
					BFS(j);
					//DFS(j,1);
				}
			}
			if (isBipartiteGraph) {
				sb.append("YES\n");
			} else {
				sb.append("NO\n");
			}
		}
		System.out.println(sb);
	}

	public static void BFS(int startVertex) {
		Queue<Integer> que = new LinkedList<Integer>();
		que.add(startVertex);
		colors[startVertex] = 1;// 처음 방문한 걸 빨강으로 칠함.
		while (!que.isEmpty()) {
			int pollNum = que.poll();
			for (int i : adjList[pollNum]) {
				if (colors[i] == 0) {
					// 인접 정점 중 방문을 안한 녀석이라면, 나와 다른 색으로 칠해주고 que에 넣어줌.
					colors[i] = colors[pollNum] * -1;
					que.add(i);
				} else if (colors[pollNum] + colors[i] != 0) {
					// 나와 다른 색이라면,
					isBipartiteGraph = false;
					return;
				}
				// 같은 색이면(방문이 되어있는 녀석) 그냥 넘어감.
			}
		}
	}

	public static void DFS(int startVertex, int color) {
		colors[startVertex] = color;
		for (int i = 0; i < adjList[startVertex].size(); i++) {
			if (colors[adjList[startVertex].get(i)] == 0) {
				// 인접 정점 중 방문을 안한 녀석이라면, 뭘로 칠해야되는지 색깔과 함께 재귀호출.
				DFS(adjList[startVertex].get(i), color * -1);
			} else if (color + colors[adjList[startVertex].get(i)] != 0) {
				// 나와 다른 색이라면,
				//System.out.println(startVertex);
				isBipartiteGraph = false;
				return;
			}
		}
	}
}
