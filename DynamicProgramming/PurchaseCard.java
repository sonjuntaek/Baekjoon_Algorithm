package DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PurchaseCard {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] priceArr = new int[n + 1];
		int[][] dp = new int[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			priceArr[i] = Integer.parseInt(st.nextToken());
		}

		dp[1][1] = priceArr[1];
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				dp[i][j] = dp[i][j - 1];
				if (i >= j) {// j번째 카드를 반영할 수 있는 경우.
					for (int t = 1; t * j <= i; t++) {// t*j가 j번째 카드로 만들 수 있는 개수임.
						dp[i][j] = Math.max(dp[i][j], dp[i - t * j][j] + priceArr[j] * t);
					}
				}
			}
		}
		System.out.println(dp[n][n]);
	}
}
