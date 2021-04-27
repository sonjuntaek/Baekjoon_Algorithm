package DFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Picture {
	static int[][] field;
	static int[] dI = { 1, -1, 0, 0 };
	static int[] dJ = { 0, 0, 1, -1 };
	static int maxPictureSize = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());// 세로 길이
		int m = Integer.parseInt(st.nextToken());// 가로 길이
		field = new int[n][m];

		// 그림판 완성
		for (int i = 0; i < field.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < field[0].length; j++) {
				field[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int pictureCount = 0;
		for (int i = 0; i < field.length; i++) {
			for (int j = 0; j < field[0].length; j++) {
				if (field[i][j] == 1) {
					BFS(i, j);
					pictureCount++;
				}
			}
		}
		System.out.println(pictureCount);
		System.out.println(maxPictureSize);
	}

	public static void BFS(int startI, int startJ) {
		Queue<Pposition> que = new LinkedList<Pposition>();
		que.add(new Pposition(startI, startJ));
		field[startI][startJ] = -1;
		int pictureSize = 0;
		while (!que.isEmpty()) {
			Pposition pollPos = que.poll();
			pictureSize++;
			for (int i = 0; i < 4; i++) {
				int nextI = pollPos.i + dI[i];
				int nextJ = pollPos.j + dJ[i];
				if (nextI < 0 || nextJ < 0 || nextI >= field.length || nextJ >= field[0].length) {
					continue;
				}
				if (field[nextI][nextJ] == 1) {
					field[nextI][nextJ] = -1;
					que.add(new Pposition(nextI,nextJ));
				}
			}
		}
		maxPictureSize = Math.max(maxPictureSize, pictureSize);
	}
}

class Pposition {
	int i;
	int j;

	public Pposition(int i, int j) {
		this.i = i;
		this.j = j;
	}
}
