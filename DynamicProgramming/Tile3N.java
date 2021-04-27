package DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Tile3N {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N + 1];
		dp[1] = 0;
		if (N % 2 == 0) {
			dp[2] = 3;
			dp[3] = 0;
			for (int i = 4; i <= N; i++) {
				dp[i] += dp[i - 2] * 3 + 2;
				for (int j = i - 4; j >= 2; j -= 2) {
					dp[i] += 2 * dp[j];
				}
			}
			System.out.println(dp[N]);
		} else {
			if (N == 1) {
				System.out.println(0);
			} else if (N == 2) {
				System.out.println(3);
			} else if (N == 3) {
				System.out.println(2);
			}
		}
	}
}
