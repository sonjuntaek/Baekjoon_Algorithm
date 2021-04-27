package DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 점프 {
	static int[][] field;
	static long[][] dp;
	static int N;
	static int[] dI = { 0, 1 };
	static int[] dJ = { 1, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		field = new int[N + 1][N + 1];
		dp = new long[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				field[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1;
			}
		}
		DFS(1, 1);
		System.out.println(dp[1][1]);
	}

	public static long DFS(int startI, int startJ) {
		if (startI == N && startJ == N) {
			return 1;
		}
		if (dp[startI][startJ] != -1) {// 방문여부를 dp로 체크, -1이 아니란건 이미 방문되었다는 것. 경우의 수가 계산되었다는 것.
			return dp[startI][startJ];
		}
		dp[startI][startJ] = 0;
		for (int i = 0; i < 2; i++) {
			int nextI = startI + dI[i] * field[startI][startJ];
			int nextJ = startJ + dJ[i] * field[startI][startJ];
			if (nextI <= 0 || nextJ <= 0 || nextI >= field.length || nextJ >= field[0].length) {
				continue;
			}
			dp[startI][startJ] += DFS(nextI, nextJ);
		}
		return dp[startI][startJ];
	}
}
