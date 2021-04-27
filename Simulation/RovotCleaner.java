package Simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RovotCleaner {
	static int[][] field;
	static int direction;
	static int cleanArea = 1;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int RovotI = Integer.parseInt(st.nextToken());
		int RovotJ = Integer.parseInt(st.nextToken());
		direction = Integer.parseInt(st.nextToken());
		// 0: 위, 1: 오른쪽, 2 : 아래, 3 : 왼쪽
		field = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				field[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		SearchField(RovotI, RovotJ);
		System.out.println(cleanArea);
	}

	public static void SearchField(int currentI, int currentJ) {
		field[currentI][currentJ] = 3;// 첫 로봇의 위치 방문햇다고 표시.
		while (true) {
			// 현재 방향을 기준으로 왼쪽 탐색.
			int changedDirection = direction;
			// System.out.println("direction : "+direction);
			boolean canMove = false;
			for (int i = 0; i < 4; i++) {
				int[] position = getLeftPosition(currentI, currentJ, changedDirection);
				changedDirection = (changedDirection - 1) < 0 ? 3 : changedDirection - 1;
				int tempI = position[0];
				int tempJ = position[1];
				if (field[tempI][tempJ] == 0) {// 방문 가능.
					cleanArea++;
					field[tempI][tempJ] = 3;
					currentI = tempI;
					currentJ = tempJ;
					direction = changedDirection;
					canMove = true;

					break;
				}
			}
			if (!canMove) {// 사방이 벽 혹은 청소가 되어진 곳이다. => 후진을 한다.
				int[] position = getBackPosition(currentI, currentJ, direction);
				int tempI = position[0];
				int tempJ = position[1];
				if (field[tempI][tempJ] == 1) {
					return;
				} else if (field[tempI][tempJ] == 3) {
					currentI = tempI;
					currentJ = tempJ;
				}
			}
		}
	}

	public static int[] getLeftPosition(int i, int j, int direction) {
		if (direction == 0) {
			return new int[] { i, j - 1 };
		} else if (direction == 1) {
			return new int[] { i - 1, j };
		} else if (direction == 2) {
			return new int[] { i, j + 1 };
		} else if (direction == 3) {
			return new int[] { i + 1, j };
		}
		return null;
	}

	public static int[] getBackPosition(int i, int j, int direction) {
		if (direction == 0) {
			return new int[] { i + 1, j };
		} else if (direction == 1) {
			return new int[] { i, j - 1 };
		} else if (direction == 2) {
			return new int[] { i - 1, j };
		} else if (direction == 3) {
			return new int[] { i, j + 1 };
		}
		return null;
	}
}
