package BruteForce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 감시 {
	static int[][] map;
	static int[][] tempMap;
	static int minSize = 0;
	static int[] cctvCase;
	static ArrayList<int[]> cctvPosList;
	static int c = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		cctvPosList = new ArrayList<int[]>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int value = Integer.parseInt(st.nextToken());
				map[i][j] = value;
				if (value == 0) {
					minSize++;
				} else if (value != 6) {
					cctvPosList.add(new int[] { i, j });
				}
			}
		}
		cctvCase = new int[cctvPosList.size()];
		go(0);
		System.out.println(minSize);
	}

	public static void go(int position) {// 순열이네.
		if (position == cctvPosList.size()) {
			// 0 : 왼쪽, 1: 위, 2: 오른쪽, 3 : 아래
			check();
			return;
		}
		for (int i = 0; i < 4; i++) {
			cctvCase[position] = i;
			go(position + 1);
		}
	}

	public static void check() {
		tempMap = new int[map.length][map[0].length];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				tempMap[i][j] = map[i][j];
			}
		}
		for (int i = 0; i < cctvPosList.size(); i++) {
			int[] pos = cctvPosList.get(i);
			if (tempMap[pos[0]][pos[1]] == 1) {
				caseOne(pos[0], pos[1], cctvCase[i]);
			}
			if (tempMap[pos[0]][pos[1]] == 2) {
				caseTwo(pos[0], pos[1], cctvCase[i]);
			}
			if (tempMap[pos[0]][pos[1]] == 3) {
				caseThree(pos[0], pos[1], cctvCase[i]);
			}
			if (tempMap[pos[0]][pos[1]] == 4) {
				caseFour(pos[0], pos[1], cctvCase[i]);
			}
			if (tempMap[pos[0]][pos[1]] == 5) {
				caseFive(pos[0], pos[1], cctvCase[i]);
			}
		}
		int count = 0;// 사각지대 카운트 
		for (int i = 0; i < tempMap.length; i++) {
			for (int j = 0; j < tempMap[0].length; j++) {
				if (tempMap[i][j] == 0) {
					count++;
				}
			}
		}
		minSize = Math.min(minSize, count);
	}

	public static void caseOne(int startI, int startJ, int direct) {
		if (direct == 0) {// 왼
			checkLeft(startI, startJ, direct);
		}
		if (direct == 1) {// 위
			checkUp(startI, startJ, direct);
		}
		if (direct == 2) {// 오른
			checkRight(startI, startJ, direct);
		}
		if (direct == 3) {// 아래
			checkDown(startI, startJ, direct);
		}
	}

	public static void checkLeft(int startI, int startJ, int direct) {
		for (int j = startJ - 1; j >= 0; j--) {
			if (tempMap[startI][j] == 0) {
				tempMap[startI][j] = -1;
			}
			if (tempMap[startI][j] == 6) {
				break;
			}
		}
	}

	public static void checkRight(int startI, int startJ, int direct) {
		for (int j = startJ + 1; j < tempMap[0].length; j++) {
			if (tempMap[startI][j] == 0) {
				tempMap[startI][j] = -1;
			}
			if (tempMap[startI][j] == 6) {
				break;
			}
		}
	}

	public static void checkUp(int startI, int startJ, int direct) {
		for (int i = startI - 1; i >= 0; i--) {
			if (tempMap[i][startJ] == 0) {
				tempMap[i][startJ] = -1;
			}
			if (tempMap[i][startJ] == 6) {
				break;
			}
		}
	}

	public static void checkDown(int startI, int startJ, int direct) {
		for (int i = startI + 1; i < tempMap.length; i++) {
			if (tempMap[i][startJ] == 0) {
				tempMap[i][startJ] = -1;
			}
			if (tempMap[i][startJ] == 6) {
				break;
			}
		}
	}

	public static void caseTwo(int startI, int startJ, int direct) {
		if (direct == 0 || direct == 2) {// 왼,오
			checkLeft(startI, startJ, direct);
			checkRight(startI, startJ, direct);
		}
		if (direct == 1 || direct == 3) {// 위,아래
			checkUp(startI, startJ, direct);
			checkDown(startI, startJ, direct);
		}
	}

	public static void caseThree(int startI, int startJ, int direct) {
		if (direct == 0) {// 왼
			checkLeft(startI, startJ, direct);
			checkUp(startI, startJ, direct);
		}
		if (direct == 1) {// 위
			checkUp(startI, startJ, direct);
			checkRight(startI, startJ, direct);
		}
		if (direct == 2) {// 오른
			checkRight(startI, startJ, direct);
			checkDown(startI, startJ, direct);
		}
		if (direct == 3) {// 아래
			checkDown(startI, startJ, direct);
			checkLeft(startI, startJ, direct);
		}
	}

	public static void caseFour(int startI, int startJ, int direct) {
		if (direct == 0) {// 왼
			checkLeft(startI, startJ, direct);
			checkUp(startI, startJ, direct);
			checkRight(startI, startJ, direct);
		}
		if (direct == 1) {// 위
			checkUp(startI, startJ, direct);
			checkRight(startI, startJ, direct);
			checkDown(startI, startJ, direct);
		}
		if (direct == 2) {// 오른
			checkRight(startI, startJ, direct);
			checkDown(startI, startJ, direct);
			checkLeft(startI, startJ, direct);
		}
		if (direct == 3) {// 아래
			checkDown(startI, startJ, direct);
			checkLeft(startI, startJ, direct);
			checkUp(startI, startJ, direct);
		}
	}

	public static void caseFive(int startI, int startJ, int direct) {
		checkLeft(startI, startJ, direct);
		checkUp(startI, startJ, direct);
		checkRight(startI, startJ, direct);
		checkDown(startI, startJ, direct);
	}
}
