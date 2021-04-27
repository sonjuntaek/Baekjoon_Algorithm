package DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UphillNum {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] dp = new int[1001][10];

		for (int i = 0; i < dp[0].length; i++) {
			dp[1][i] = 1;
		}
		//dp[i][j] i자리의 숫자에서 j로 끝나는 수의 개수.
		for (int i = 2; i < dp.length; i++) {// 2 ~ 1000자리까지 구함.
			for (int j = 0; j < 10; j++) {// 뒤에가 뭘로 끝나느냐.
				int sum = 0;
				for (int t = j; t >= 0; t--) {
					sum += dp[i - 1][t] % 10007;
				}
				dp[i][j] = sum  % 10007;
			}
		}
		int answer = 0;
		for (int i = 0; i < 10; i++) {
			answer += dp[N][i];
		}
		System.out.println(answer % 10007);
	}
}
