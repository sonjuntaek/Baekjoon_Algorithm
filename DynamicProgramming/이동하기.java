package DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 이동하기 {
	static boolean[][] visited;
	static int[][] maze;
	static int[][] dp;
	static int maxNum = Integer.MIN_VALUE;
	static int N;
	static int M;
	static int[] dI = { 1, 1, 0 };
	static int[] dJ = { 0, 1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		maze = new int[N + 1][M + 1];
		dp = new int[N + 1][M + 1];
		visited = new boolean[N + 1][M + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				maze[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1;
			}
		}
		DFS(1, 1);
//		for (int i = 1; i < dp.length; i++) {
//			for (int j = 1; j < dp[0].length; j++) {
//				System.out.print(dp[i][j]+" ");
//			}
//			System.out.println();
//		}
		System.out.println(dp[1][1]);
	}

	public static int DFS(int startI, int startJ) {
		// 끝나는 지점은 어차피 오른쪽 아래에서 끝나게 되므로 필요 없다.
		// 오른쪽 아래에 끝나는 경우가 발생하지 않는 상황이 있다면, 그땐 종료 구문 넣어줘야지.
		// if (startI == N && startJ == M) {
		// return maze[startI][startJ];
		// }
		if (dp[startI][startJ] != -1) {// 이미 방문한 이력이 있고, dp가 갱신이 되어있다면
			return dp[startI][startJ];
		}

		dp[startI][startJ] = maze[startI][startJ];
		for (int i = 0; i < 3; i++) {
			int nextI = startI + dI[i];
			int nextJ = startJ + dJ[i];
			if (nextI <= 0 || nextJ <= 0 || nextI >= maze.length || nextJ >= maze[0].length) {
				continue;
			}
			dp[startI][startJ] = Math.max(dp[startI][startJ], maze[startI][startJ] + DFS(nextI, nextJ));
		}
		return dp[startI][startJ];
	}
}
