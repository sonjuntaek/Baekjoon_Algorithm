package BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class MakeBridge {
	static int[][] field;
	static int[] dI = { 1, -1, 0, 0 };
	static int[] dJ = { 0, 0, -1, 1 };
	static ArrayList<Edge> answerlist = new ArrayList<Edge>();
	static int[] parent;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		field = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				field[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int islandNum = makeIsland();// 섬을 넘버링 해주고, 섬의 개수 반환.

		parent = new int[islandNum + 1];// 각 섬의 부모를 나타낼 배열
		for (int i = 1; i < parent.length; i++) {// 처음엔 자신이 부모로.
			parent[i] = i;
		}

		makeAllBridge();// 만들 수 있는 다리 모두 만듬.
		int cost = makeMST(); // 만들어진 모든 다리를 최소비용으로 하여 연결되도록 함.
		int rootParent = getParent(parent, parent[1]);
		for (int i = 2; i < parent.length; i++) {
			if (getParent(parent, parent[i]) != rootParent) {
				cost = -1;
			}
		}
		System.out.println(cost);
	}

	public static int makeIsland() {// 섬을 넘버링 해주고, 섬의 개수 반환.
		int islandCount = 0;
		for (int i = 0; i < field.length; i++) {
			for (int j = 0; j < field[0].length; j++) {
				if (field[i][j] == 1) {
					islandCount++;
					BFS(i, j, islandCount);
				}
			}
		}
		return islandCount;
	}

	public static void BFS(int startI, int startJ, int islandNumber) {
		Queue<MPosition> que = new LinkedList<MPosition>();
		que.add(new MPosition(startI, startJ));
		field[startI][startJ] = -islandNumber;
		while (!que.isEmpty()) {
			MPosition pollPos = que.poll();
			for (int i = 0; i < 4; i++) {
				int nextI = pollPos.i + dI[i];
				int nextJ = pollPos.j + dJ[i];
				if (nextI < 0 || nextJ < 0 || nextI >= field.length || nextJ >= field[0].length) {
					continue;
				}
				if (field[nextI][nextJ] == 1) {
					field[nextI][nextJ] = -islandNumber;
					que.add(new MPosition(nextI, nextJ));
				}
			}
		}
	}

	public static void makeAllBridge() {// 만들 수 있는 모든 다리 리스트에 추가. 정렬도 완료.
		for (int i = 0; i < field.length; i++) {
			for (int j = 0; j < field[0].length; j++) {
				if (field[i][j] != 0) {
					makeBridge(i, j);
				}
			}
		}

		Collections.sort(answerlist);
	}

	public static void makeBridge(int startI, int startJ) {
		int islandNum = field[startI][startJ];
		for (int i = startI + 1; i < field.length; i++) {// 아래로 가는거.
			if (islandNum == field[i][startJ]) {
				break;
			}
			if (field[i][startJ] != 0) {
				if (i - startI - 1 > 1)
					answerlist.add(new Edge(-islandNum, -field[i][startJ], i - startI - 1));
				break;
			}
		}
		for (int j = startJ + 1; j < field[0].length; j++) {// 오른쪽으로 가는거.
			if (islandNum == field[startI][j]) {
				break;
			}
			if (field[startI][j] != 0) {
				if (j - startJ - 1 > 1)
					answerlist.add(new Edge(-islandNum, -field[startI][j], j - startJ - 1));
				break;
			}
		}
	}

	public static int makeMST() {
		int cost = 0;
		for (Edge e : answerlist) { // 최소 값의 간선을 하나씩 받아들임.
			if (!findParent(parent, e.left, e.right)) {
				// 사이클이 형성되는지 확인. 부모가 같다면 이 간선을 추가하면 사이클이 형성되는 것.
				// 같은 집합에 속한다는 건. 같은 최상위 부모를 갖는다는 것. 그런데 특정 간선의 양쪽 정점이 같은 부모를 가르키는데 간선을 추가한다?
				// 사이클이 생긴다는 뜻.
				unionParent(parent, e.left, e.right);
				cost += e.cost;
			}
		}
		return cost;
	}

	public static int getParent(int[] parent, int x) {
		if (parent[x] == x)
			return x;
		return getParent(parent, parent[x]);
	}

	public static void unionParent(int[] parent, int a, int b) {
		int aParent = getParent(parent, a);
		int bParent = getParent(parent, b);
		if (aParent < bParent) {
			parent[bParent] = aParent;
		} else {
			parent[aParent] = bParent;
		}
	}

	public static boolean findParent(int[] parent, int a, int b) {
		if (getParent(parent, a) == getParent(parent, b)) {
			return true;
		} else {
			return false;
		}
	}
}

class MPosition {
	int i;
	int j;

	public MPosition(int i, int j) {
		this.i = i;
		this.j = j;
	}
}

class Edge implements Comparable<Edge> {
	int left;
	int right;
	int cost;

	public Edge(int left, int right, int cost) {
		this.left = left;
		this.right = right;
		this.cost = cost;
	}

	@Override
	public int compareTo(Edge o) {
		// TODO Auto-generated method stub
		return this.cost - o.cost;
	}
}
