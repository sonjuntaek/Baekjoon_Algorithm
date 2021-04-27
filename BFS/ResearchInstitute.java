package BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ResearchInstitute {
	static int[][] makedMap;
	static int[][] board;
	static int[] dI = { 1, -1, 0, 0 };
	static int[] dJ = { 0, 0, -1, 1 };
	static int answer = Integer.MIN_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		board = new int[N][M];

		// 연구소의 판을 만듦.
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// makedMap = board.clone();
		makeThreeWall(0, 0);
		System.out.println(answer);
	}

	public static void makeThreeWall(int start, int depth) {
		if (depth == 3) {
			makedMap = new int[board.length][board[0].length];
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board[0].length; j++) {
					makedMap[i][j] = board[i][j];
					//System.out.print(makedMap[i][j] + " ");
				}
				//System.out.println();
			}
			// System.out.println();
			// System.out.println();
			makeVirusSpread();
			return;
		}

		for (int i = start; i < board.length * board[0].length; i++) {
			int I = i / board[0].length;
			int J = i % board[0].length;
			if (board[I][J] == 0) {
				board[I][J] = 1;
				makeThreeWall(i + 1, depth + 1);// i번째꺼 뽑앗다는 가정하에 i+1부터 탐색.
				board[I][J] = 0;
			}
		}
	}

	public static void makeVirusSpread() {
		for (int i = 0; i < makedMap.length; i++) {
			for (int j = 0; j < makedMap[0].length; j++) {
				if (makedMap[i][j] == 2) {
					BFS(i, j);
				}
			}
		}
		countNum();
	}

	public static void BFS(int currentI, int currentJ) {
		Queue<Rposition> que = new LinkedList<Rposition>();
		que.add(new Rposition(currentI, currentJ));
		makedMap[currentI][currentJ] = -2;
		while (!que.isEmpty()) {
			Rposition pollPos = que.poll();
			for (int i = 0; i < 4; i++) {
				int nextI = pollPos.i + dI[i];
				int nextJ = pollPos.j + dJ[i];
				if (nextI < 0 || nextJ < 0 || nextI >= makedMap.length || nextJ >= makedMap[0].length) {
					continue;
				}
				if (makedMap[nextI][nextJ] == 0) {
					makedMap[nextI][nextJ] = -2;
					que.add(new Rposition(nextI, nextJ));
				}
			}
		}
	}

	public static void countNum() {
		int count = 0;
		for (int i = 0; i < makedMap.length; i++) {
			for (int j = 0; j < makedMap[0].length; j++) {
				if (makedMap[i][j] == 0) {
					count++;
				}
			}
		}
		// System.out.println("0의 갯수 : " + count);
		answer = Math.max(answer, count);
	}
}

class Rposition {
	int i;
	int j;

	public Rposition(int i, int j) {
		this.i = i;
		this.j = j;
	}
}