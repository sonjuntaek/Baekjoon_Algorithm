package DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Tile2N {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N + 1];
		if (N > 2) {
			dp[1] = 1;
			dp[2] = 2;
			for (int i = 3; i <= N; i++) {
				dp[i] = dp[i - 2] % 10007 + dp[i - 1] % 10007;
				System.out.println(dp[i]);
			}
			System.out.println(dp[N] % 10007);
		} else {
			System.out.println(N);
		}
	}
}
