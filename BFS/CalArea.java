package BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class CalArea {
	static int[] dI = new int[] { 0, 0, 1, -1 };
	static int[] dJ = new int[] { 1, -1, 0, 0 };
	static int[][] field;
	static ArrayList<Integer> answerList = new ArrayList<Integer>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		field = new int[M][N];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int leftUpJ = Integer.parseInt(st.nextToken());
			int leftUpI = Integer.parseInt(st.nextToken());

			int rightDownJ = Integer.parseInt(st.nextToken());
			int rightDownI = Integer.parseInt(st.nextToken());

			for (int I = leftUpI; I < rightDownI; I++) {
				for (int J = leftUpJ; J < rightDownJ; J++) {
					field[I][J] = -1;
				}
			}
		}
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (field[i][j] == 0) {
					BFS(i, j);
				}
			}
		}
		Collections.sort(answerList);
		StringBuilder sb = new StringBuilder();
		sb.append(answerList.size()+"\n");
		for(int i : answerList) {
			sb.append(i+" ");
		}
		System.out.println(sb);
	}

	public static void BFS(int currentI, int currentJ) {
		Queue<CalAreaPos> que = new LinkedList<CalAreaPos>();
		que.add(new CalAreaPos(currentI, currentJ));
		field[currentI][currentJ] = 1;
		int count = 1;
		while (!que.isEmpty()) {
			CalAreaPos pollPos = que.poll();
			for (int i = 0; i < 4; i++) {
				int nextI = pollPos.i + dI[i];
				int nextJ = pollPos.j + dJ[i];

				if (nextI < 0 || nextJ < 0 || nextI >= field.length || nextJ >= field[0].length) {
					continue;
				}
				if (field[nextI][nextJ] == 0) {// 방문 가능.
					field[nextI][nextJ] = 1;
					que.add(new CalAreaPos(nextI, nextJ));
					count++;
				}
			}
		}
		answerList.add(count);
	}
}

class CalAreaPos {
	int i;
	int j;

	public CalAreaPos(int i, int j) {
		this.i = i;
		this.j = j;
	}
}
