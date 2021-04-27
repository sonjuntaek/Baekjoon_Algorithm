package BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class AvoidTrash {
	static int[][] field;
	static int[] dI = { 1, -1, 0, 0 };
	static int[] dJ = { 0, 0, 1, -1 };
	static int maxSize = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		field = new int[N + 1][M + 1];

		// 음식물 쓰레기 좌표 설정.
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int I = Integer.parseInt(st.nextToken());
			int J = Integer.parseInt(st.nextToken());
			field[I][J] = 1;
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (field[i][j] == 1) {
					BFS(i, j);
				}
			}
		}
		System.out.println(maxSize);
	}

	public static void BFS(int startI, int startJ) {
		Queue<Aposition> que = new LinkedList<Aposition>();
		que.add(new Aposition(startI, startJ));
		field[startI][startJ] = -1;
		int count = 0;
		while (!que.isEmpty()) {
			Aposition pollPos = que.poll();
			count++;
			for (int i = 0; i < 4; i++) {
				int nextI = pollPos.i + dI[i];
				int nextJ = pollPos.j + dJ[i];

				if (nextI <= 0 || nextJ <= 0 || nextI >= field.length || nextJ >= field[0].length) {
					continue;
				}
				if (field[nextI][nextJ] == 1) {
					que.add(new Aposition(nextI, nextJ));
					field[nextI][nextJ] = -1;
				}
			}
		}
		maxSize = Math.max(maxSize, count);
	}
}

class Aposition {
	int i;
	int j;

	public Aposition(int i, int j) {
		this.i = i;
		this.j = j;
	}
}