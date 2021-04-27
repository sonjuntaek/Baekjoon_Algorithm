package Simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Dice {
	static int[] rightPos = { 1, 2, 3, 5, 1 };
	static int[] leftPos = { 1, 5, 3, 2, 1 };
	static int[] upPos = { 0, 5, 4, 2, 0 };
	static int[] downPos = { 0, 2, 4, 5, 0 };
	static int[][] board;
	static int[] dicePos;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		// 지도 완성
		board = new int[N][M];
		for (int i = 0; i < board.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < board[0].length; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 주사위가 움직여야 하는 명령어 세팅
		int[] command = new int[K];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			command[i] = Integer.parseInt(st.nextToken());
		}

		// 주사위 전개도를 보고 계산해야하므로 주사위 세팅
		// ----0----
		// --1 2 3--
		// ----4----
		// ----5---- 이런 형태이다. 주사위의 상단은 항상 dice 인덱스의 2, 바닥은 5해당됨
		dicePos = new int[6];

		// 명령에 맞게 시행 ㄱㄱ
		StringBuilder sb = new StringBuilder();

		// 첫 시작 위치 출력하고 명령어 시행.
//		if (board[X][Y] == 0) {// 0이면 주사위 바닥면 -> 지도
//			board[X][Y] = dicePos[5];
//		} else {// 0이 아니면 지도 -> 주사위 바닥면
//			dicePos[5] = board[X][Y];
//		}
		for (int i = 0; i < command.length; i++) {
			int nextX = X;// i
			int nextY = Y;// j
			int direction = command[i];
			if (direction == 1) {
				nextY = Y + 1;
			} else if (direction == 2) {
				nextY = Y - 1;
			} else if (direction == 3) {
				nextX = X - 1;
			} else if (direction == 4) {
				nextX = X + 1;
			}
			if (isPossible(nextX, nextY)) {// 이동 가능한 위치임?
				X = nextX;
				Y = nextY;
				if (direction == 1) {
					moveRight(dicePos);
				} else if (direction == 2) {
					moveLeft(dicePos);
				} else if (direction == 3) {
					moveUp(dicePos);
				} else if (direction == 4) {
					moveDown(dicePos);
				}
				if (board[X][Y] == 0) {// 0이면 주사위 바닥면 -> 지도
					board[X][Y] = dicePos[5];
				} else {// 0이 아니면 지도 -> 주사위 바닥면
					dicePos[5] = board[X][Y];
					board[X][Y] = 0;
				}
				sb.append(dicePos[2] + "\n");
			}
		}
		System.out.println(sb);
	}

	public static boolean isPossible(int x, int y) {
		if (x < 0 || y < 0 || x >= board.length || y >= board[0].length) {
			return false; // 범위를 벗어나면 스킵.
		}
		return true;
	}

	// 현재 좌표와 방향에 맞게 움직임.
	public static void moveDice(int x, int y, int Direction) {

	}

	public static void moveRight(int[] dice) {

		int[] temp = dice.clone();
		for (int i = 0; i < rightPos.length - 1; i++) {
			dice[rightPos[i + 1]] = temp[rightPos[i]];
		}
	}

	public static void moveLeft(int[] dice) {

		int[] temp = dice.clone();
		for (int i = 0; i < leftPos.length - 1; i++) {
			dice[leftPos[i + 1]] = temp[leftPos[i]];
		}
	}

	public static void moveUp(int[] dice) {

		int[] temp = dice.clone();
		for (int i = 0; i < upPos.length - 1; i++) {
			dice[upPos[i + 1]] = temp[upPos[i]];
		}
	}

	public static void moveDown(int[] dice) {

		int[] temp = dice.clone();
		for (int i = 0; i < downPos.length - 1; i++) {
			dice[downPos[i + 1]] = temp[downPos[i]];
		}
	}
}
