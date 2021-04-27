package DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LongestIncreaseSeq {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] dp = new int[N+1];
		int[] numArr = new int[N+1];
		for (int i = 1; i <= N; i++) {
			numArr[i] = Integer.parseInt(st.nextToken());
		}

		dp[1] = numArr[1];
		int totalMaxValue = dp[1];
		for (int i = 2; i < dp.length; i++) {
			int maxValue = 0;
			for (int j = i - 1; j >= 0; j--) {// 자기보다 작은 것중 DP가 제일 큰 것 선택.
				if (numArr[i] > numArr[j] && maxValue < dp[j]) {
					maxValue = dp[j];
				}
			}

			dp[i] = Math.max(numArr[i], maxValue + numArr[i]);
			totalMaxValue = Math.max(totalMaxValue, dp[i]);
		}
//		for(int i = 1 ; i < dp.length ; i++) {
//			System.out.print(dp[i] + " ");
//		}
//		System.out.println();
		// System.out.println();
		System.out.println(totalMaxValue);
	}
}
