package DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Tile2N_2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N + 1];
		if (N > 2) {
			dp[1] = 1;
			dp[2] = 3;
			for (int i = 3; i <= N; i++) {
				dp[i] = dp[i - 1] % 10007 + (2 * dp[i - 2]) % 10007;
			}
			System.out.println(dp[N] % 10007);
		} else {
			if (N == 1) {
				System.out.println(1);
			} else if (N == 2) {
				System.out.println(3);
			}
		}
	}
}
