package DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 동전2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] costArr = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			costArr[i] = Integer.parseInt(br.readLine());
		}
		int[] dp = new int[100001];
		Arrays.fill(dp, 20000);
		dp[0] = 0;
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < costArr.length; j++) {
				if (i - costArr[j] >= 0) {
					dp[i] = Math.min(dp[i], dp[i - costArr[j]] + 1);
				}
			}
		}
		if(dp[k] >= 20000) {
			System.out.println(-1);
		}else {
			System.out.println(dp[k]);
		}
	}
}
