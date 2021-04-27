package DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ConstructBridge {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		int[][] dp = new int[31][31];

		dp[1][1] = 1;
		dp[1][0] = 1;
		for (int i = 2; i < dp.length; i++) {
			dp[i][0] = 1;
			for (int j = 1; j < dp[0].length; j++) {
				dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
				//System.out.print(dp[i][j] + " ");
			}
			//System.out.println();
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < testCase; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			sb.append(dp[M][N]+"\n");
		}
		System.out.println(sb);
	}
}
