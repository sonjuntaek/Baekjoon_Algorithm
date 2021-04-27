package BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BabyShark {
	static int[] dI = new int[] { -1, 0, 0, 1 };
	static int[] dJ = new int[] { 0, -1, 1, 0 };
	static int[][] field;
	static boolean[][] visited;
	static int sharkSize = 2;
	static int sharkEat = 0;
	static int N;
	static int answer = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		field = new int[N][N];
		visited = new boolean[N][N];

		int startI = 0;
		int startJ = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				field[i][j] = Integer.parseInt(st.nextToken());
				if (field[i][j] == 9) {
					startI = i;
					startJ = j;
				}
			}
		}
		BFS(startI, startJ);
		System.out.println(answer);
	}

	public static void BFS(int currentI, int currentJ) {

		while (true) {
			Queue<Bposition> que = new LinkedList<Bposition>();
			ArrayList<Bposition> answerList = new ArrayList<Bposition>();
			que.add(new Bposition(currentI, currentJ, 0));
			visited[currentI][currentJ] = true;
			while (!que.isEmpty()) {
				Bposition pollPos = que.poll();
				for (int i = 0; i < 4; i++) {
					int nextI = pollPos.i + dI[i];
					int nextJ = pollPos.j + dJ[i];
					if (nextI < 0 || nextJ < 0 || nextI >= field.length || nextJ >= field[0].length) {
						continue;
					}
					if (field[nextI][nextJ] > sharkSize || visited[nextI][nextJ] == true) {
						continue;
					}
					// 범위를 넘거나, 방문을 했거나, 아기상어보다 큰 것들 다 걸러졌음.

					if (field[nextI][nextJ] == 0 || field[nextI][nextJ] == sharkSize) {// 비어있는 공간이면 방문,
						visited[nextI][nextJ] = true;
						que.add(new Bposition(nextI, nextJ, pollPos.count + 1));
					} else if (field[nextI][nextJ] < sharkSize) {// 비어있지 않고 다른 물고기가 있다면 먹어야지.
						visited[nextI][nextJ] = true;
						answerList.add(new Bposition(nextI, nextJ, pollPos.count + 1));
					}
				}
			}
			if (answerList.size() == 0) {
				return;
			} else {
				Collections.sort(answerList);
				int nextI = answerList.get(0).i;
				int nextJ = answerList.get(0).j;
				field[nextI][nextJ] = 9;// 먹었으니 상어의 위치 옮겨줌.
				field[currentI][currentJ] = 0;// 원래 위치는 0으로.
				visited = new boolean[N][N];// 새로운 상어위치에서 방문이 새로 이루어지므로 초기화.
				sharkEat++;// 상어의 먹은 갯수 체크
				if (sharkEat == sharkSize) {// 상어가 성장할 수 있으면 체크해줌.
					sharkSize++;
					sharkEat = 0;
				}
				answer += answerList.get(0).count;
				currentI = nextI;
				currentJ = nextJ;
			}
		}

		// 큐가 비었다면 결국 방문할 곳이 없다는 것. 더 이상 갈 곳이 없으므로 종료되겠지.
	}
}

class Bposition implements Comparable<Bposition> {
	int i;
	int j;
	int count;

	public Bposition(int i, int j, int count) {
		this.i = i;
		this.j = j;
		this.count = count;
	}

	@Override
	public int compareTo(Bposition o) {
		// TODO Auto-generated method stub
		if (this.count > o.count) {
			return 1;
		} else if (this.count < o.count) {
			return -1;
		} else {
			if (this.i > o.i) {
				return 1;
			} else if (this.i < o.i) {
				return -1;
			} else {
				return this.j - o.j;
			}
		}
	}
}