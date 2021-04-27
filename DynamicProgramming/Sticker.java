package DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sticker {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testN = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < testN; i++) {
			int n = Integer.parseInt(br.readLine());
			int[][] dp = new int[2][n + 1];
			int[][] stickerArr = new int[2][n + 1];
			for (int t = 0; t < 2; t++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= n; j++) {
					stickerArr[t][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			dp[0][1] = stickerArr[0][1];
			dp[1][1] = stickerArr[1][1];
			for (int j = 2; j < dp[0].length; j++) {
				dp[0][j] = Math.max(dp[1][j - 1], dp[1][j - 2]) + stickerArr[0][j];
				dp[1][j] = Math.max(dp[0][j - 1], dp[0][j - 2]) + stickerArr[1][j];
			}
			sb.append(Math.max(dp[0][n], dp[1][n])+"\n");
		}
		System.out.println(sb);
	}
}
