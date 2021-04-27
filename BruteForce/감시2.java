package BruteForce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 감시2 {
	static int[][] map;
	static int minSize = 0;
	static ArrayList<int[]> cctvPosList;
	static int[] caseNum;
	static int CanSEE = 7;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		cctvPosList = new ArrayList<int[]>();
		caseNum = new int[6];//각 케이스의 개수.
		caseNum[1] = 4;
		caseNum[2] = 2;
		caseNum[3] = 4;
		caseNum[4] = 4;
		caseNum[5] = 1;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int value = Integer.parseInt(st.nextToken());
				map[i][j] = value;
				if (value == 0) {
					minSize++;
				} else if (value != 6) {
					cctvPosList.add(new int[] { value, i, j });// cctv type, 좌표
				}
			}
		}
		go(0);
		System.out.println(minSize);
	}

	public static void go(int position) {// 순열이네.
		if (position == cctvPosList.size()) {
			// 0 : 왼쪽, 1: 위, 2: 오른쪽, 3 : 아래
			// check();
			int count = 0;
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[0].length; j++) {
					//System.out.print(map[i][j] + " ");
					if (map[i][j] == 0) {
						count++;
					}
				}
				//System.out.println();
			}
			//System.out.println();
			minSize = Math.min(minSize, count);
			return;
		}

		int[] visitCCTV = cctvPosList.get(position);
		for (int i = 0; i < caseNum[visitCCTV[0]]; i++) {
			draw(visitCCTV, i, CanSEE);
			go(position + 1);
			draw(visitCCTV, i, -CanSEE);
		}
	}

	public static void draw(int[] visitCCTV, int direction, int color) {
		int type = visitCCTV[0];
		if (type == 1) {
			caseOne(visitCCTV[1], visitCCTV[2], direction, color);
		}
		if (type == 2) {
			caseTwo(visitCCTV[1], visitCCTV[2], direction, color);
		}
		if (type == 3) {
			caseThree(visitCCTV[1], visitCCTV[2], direction, color);
		}
		if (type == 4) {
			caseFour(visitCCTV[1], visitCCTV[2], direction, color);
		}
		if (type == 5) {
			caseFive(visitCCTV[1], visitCCTV[2], color);
		}
	}

	public static void checkLeft(int startI, int startJ, int color) {
		for (int j = startJ - 1; j >= 0; j--) {
			if (map[startI][j] > 6 || map[startI][j] == 0) {
				map[startI][j] += color;
			}
			if (map[startI][j] == 6) {
				break;
			}
		}
	}

	public static void checkRight(int startI, int startJ, int color) {
		for (int j = startJ + 1; j < map[0].length; j++) {
			if (map[startI][j] > 6 || map[startI][j] == 0) {
				map[startI][j] += color;
			}
			if (map[startI][j] == 6) {
				break;
			}
		}
	}

	public static void checkUp(int startI, int startJ, int color) {
		for (int i = startI - 1; i >= 0; i--) {
			if (map[i][startJ] > 6 || map[i][startJ] == 0) {
				map[i][startJ] += color;
			}
			if (map[i][startJ] == 6) {
				break;
			}
		}
	}

	public static void checkDown(int startI, int startJ, int color) {
		for (int i = startI + 1; i < map.length; i++) {
			if (map[i][startJ] > 6 || map[i][startJ] == 0) {
				map[i][startJ] += color;
			}
			if (map[i][startJ] == 6) {
				break;
			}
		}
	}

	public static void caseOne(int startI, int startJ, int direct, int color) {
		if (direct == 0) {// 왼
			checkLeft(startI, startJ, color);
		}
		if (direct == 1) {// 위
			checkUp(startI, startJ, color);
		}
		if (direct == 2) {// 오른
			checkRight(startI, startJ, color);
		}
		if (direct == 3) {// 아래
			checkDown(startI, startJ, color);
		}
	}

	public static void caseTwo(int startI, int startJ, int direct, int color) {
		if (direct == 0) {// 왼,오
			checkLeft(startI, startJ, color);
			checkRight(startI, startJ, color);
		}
		if (direct == 1) {// 위,아래
			checkUp(startI, startJ, color);
			checkDown(startI, startJ, color);
		}
	}

	public static void caseThree(int startI, int startJ, int direct, int color) {
		if (direct == 0) {// 왼
			checkLeft(startI, startJ, color);
			checkUp(startI, startJ, color);
		}
		if (direct == 1) {// 위
			checkUp(startI, startJ, color);
			checkRight(startI, startJ, color);
		}
		if (direct == 2) {// 오른
			checkRight(startI, startJ, color);
			checkDown(startI, startJ, color);
		}
		if (direct == 3) {// 아래
			checkDown(startI, startJ, color);
			checkLeft(startI, startJ, color);
		}
	}

	public static void caseFour(int startI, int startJ, int direct, int color) {
		if (direct == 0) {// 왼
			checkLeft(startI, startJ, color);
			checkUp(startI, startJ, color);
			checkRight(startI, startJ, color);
		}
		if (direct == 1) {// 위
			checkUp(startI, startJ, color);
			checkRight(startI, startJ, color);
			checkDown(startI, startJ, color);
		}
		if (direct == 2) {// 오른
			checkRight(startI, startJ, color);
			checkDown(startI, startJ, color);
			checkLeft(startI, startJ, color);
		}
		if (direct == 3) {// 아래
			checkDown(startI, startJ, color);
			checkLeft(startI, startJ, color);
			checkUp(startI, startJ, color);
		}
	}

	public static void caseFive(int startI, int startJ, int color) {
		checkLeft(startI, startJ, color);
		checkUp(startI, startJ, color);
		checkRight(startI, startJ, color);
		checkDown(startI, startJ, color);
	}
}
