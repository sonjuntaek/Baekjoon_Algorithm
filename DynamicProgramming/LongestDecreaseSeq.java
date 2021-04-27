package DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LongestDecreaseSeq {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] valueArr = new int[N + 1];
		int[] dp = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			valueArr[i] = Integer.parseInt(st.nextToken());
		}

		int maxDp = 1;
		dp[1] = 1;
		for (int i = 2; i <= N; i++) {
			int temp = 0;
			for (int j = i - 1; j >= 1; j--) {
				if (valueArr[i] < valueArr[j] && temp < dp[j]) {
					temp = dp[j];
				}
			}
			dp[i] = temp + 1;
			maxDp = Math.max(maxDp, dp[i]);
		}

		System.out.println(maxDp);
	}
}
