package Queue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Dummy {
	static int[][] board;
	static Deque<Pos> que;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		board = new int[N + 1][N + 1];

		// 사과 위치 설정
		int appleN = Integer.parseInt(br.readLine());
		for (int i = 0; i < appleN; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int appleI = Integer.parseInt(st.nextToken());
			int appleJ = Integer.parseInt(st.nextToken());
			board[appleI][appleJ] = 1;
		}

		// 방향 전환 시점 저장.
		int dirN = Integer.parseInt(br.readLine());
		HashMap<Integer, Character> hm = new HashMap<Integer, Character>();
		for (int i = 0; i < dirN; i++) {// 사과 위치 설정
			StringTokenizer st = new StringTokenizer(br.readLine());
			int time = Integer.parseInt(st.nextToken());
			char dir = st.nextToken().charAt(0);
			hm.put(time, dir);
		}

		que = new LinkedList<Pos>();
		int time = 0;
		int direction = 0;// 0 : 오른쪽, 1 : 아래, 2 : 왼쪽, 3 : 위쪽
		que.add(new Pos(1, 1));
		int prevI = 1;
		int prevJ = 1;
		while (true) {
			time++;
			int nextI = prevI;
			int nextJ = prevJ;
			if (direction == 0) {
				nextJ += 1;
			} else if (direction == 1) {
				nextI += 1;
			} else if (direction == 2) {
				nextJ -= 1;
			} else if (direction == 3) {
				nextI -= 1;
			}
			// 다음 이동 방향이 꼬리를 만났는지, 벽을 만났는지 확인.
			if (isFinished(nextI, nextJ)) {
				break;
			}

			if (board[nextI][nextJ] == 1) {// 다음 이동 방향이 사과라면,
				board[nextI][nextJ] = 0;
				que.add(new Pos(nextI, nextJ));
			} else {
				que.poll();
				que.add(new Pos(nextI, nextJ));
			}
			if (hm.containsKey(time)) {
				char temp = hm.get(time);
				if (temp == 'D') {
					direction = (direction + 1) % 4;
				} else if (temp == 'L') {
					direction = (direction - 1) >= 0 ? (direction - 1) : 3;
				}
			}
		}
		System.out.println(time);
	}

	public static boolean isFinished(int i, int j) {// 꼬리를 만났는지, 벽을 만났는지 확인.
		if (i <= 0 || j <= 0 || i >= board.length || j >= board.length) {
			return true;
		}
		for (Pos p : que) {
			if (p.i == i && p.j == j) {
				return true;
			}
		}
		return false;
	}
}

class Pos {
	int i;
	int j;

	public Pos(int i, int j) {
		this.i = i;
		this.j = j;
	}
}