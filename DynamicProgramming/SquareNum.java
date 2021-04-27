package DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SquareNum {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N + 1];
		dp[1] = 1;
		for (int i = 2; i < dp.length; i++) {
			if ((int) Math.pow((int) Math.sqrt(i), 2) == i) {
				dp[i] = 1;
			} else {
				int sqrtNum = (int) Math.sqrt(i);// 32이라면 sqrtNum은 5부터 2까지감.
				int temp = (int) Math.pow(sqrtNum, 2);
				dp[i] = dp[temp] + dp[i - temp];
				for (int j = sqrtNum - 1; j >= 1; j--) {
					// i가 32라면 temp에는 5제곱부터 2제곱까지 들어가지.
					temp = (int) Math.pow(j, 2);
					dp[i] = Math.min(dp[i], dp[temp] + dp[i - temp]);
				}
			}
		}
		System.out.println(dp[N]);
	}
}
