package DFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class JumpNumBoard {
	static int[][] board;
	static int[] dI = { 1, -1, 0, 0 };
	static int[] dJ = { 0, 0, 1, -1 };
	static HashSet<String> hs;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = 5;
		board = new int[n][n];
		hs = new HashSet<String>();

		// 숫자판 만듬.
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				DFS(i, j, board[i][j] + "");
			}
		}
		System.out.println(hs.size());
	}

	public static void DFS(int startI, int startJ, String numStr) {
		if (numStr.length() >= 6) {
			hs.add(numStr);
			return;
		}
		for (int i = 0; i < 4; i++) {
			int nextI = startI + dI[i];
			int nextJ = startJ + dJ[i];
			if (nextI < 0 || nextJ < 0 || nextI >= board.length || nextJ >= board[0].length) {
				continue;
			}
			DFS(nextI, nextJ, numStr + board[nextI][nextJ]);
		}

	}
}
