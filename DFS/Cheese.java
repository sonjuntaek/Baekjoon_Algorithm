package DFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Cheese {
	static int[] dI = { 0, 0, 1, -1 };
	static int[] dJ = { 1, -1, 0, 0 };
	static int[][] field;
	static int hour = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		field = new int[N][M];
		// 표 완성
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				field[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		BFS(0, 0);
		System.out.println(hour - 1);
	}

	public static void BFS(int startI, int startJ) {
		Queue<CPosition> que = new LinkedList<CPosition>();
		field[startI][startJ] = -1;
		que.add(new CPosition(startI, startJ));
		while (true) {
			hour++;
			ArrayList<CPosition> answerList = new ArrayList<CPosition>();
			while (!que.isEmpty()) {
				CPosition pollPos = que.poll();
				for (int i = 0; i < 4; i++) {
					int nextI = pollPos.i + dI[i];
					int nextJ = pollPos.j + dJ[i];

					if (nextI < 0 || nextJ < 0 || nextI >= field.length || nextJ >= field[0].length) {
						continue;
					}
					if (field[nextI][nextJ] == -1) {
						continue;
					}
					if (field[nextI][nextJ] == 0) {
						field[nextI][nextJ] = -1;
						que.add(new CPosition(nextI, nextJ));
					} else {
						field[nextI][nextJ] += 1;
						if (field[nextI][nextJ] > 2) {
							answerList.add(new CPosition(nextI, nextJ));
						}
					}
				}
			}
			if (answerList.size() == 0) {
				return;
			}
			for (int i = 0; i < answerList.size(); i++) {
				field[answerList.get(i).i][answerList.get(i).j] = -1;
				que.add(answerList.get(i));
			}
		}
	}
}

class CPosition {
	int i = 0;
	int j = 0;

	public CPosition(int i, int j) {
		this.i = i;
		this.j = j;
	}
}
