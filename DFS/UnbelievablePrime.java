package DFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UnbelievablePrime {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		DFS(1, 2 + "", n);
		DFS(1, 3 + "", n);
		DFS(1, 5 + "", n);
		DFS(1, 7 + "", n);
		System.out.println(sb);
	}

	public static void DFS(int depth, String num, int endDepth) {
		if (depth == endDepth) {
			sb.append(num + "\n");
			return;
		}

		for (int i = 0; i < 10; i++) {
			if (isPrimeNum(Integer.parseInt(num + i))) {
				DFS(depth + 1, num + i, endDepth);
			}
		}
	}

	public static boolean isPrimeNum(int x) {
		int end = x;
		for (int i = 2; i < end; i++) {
			if (x % i == 0) {
				return false;
			}
		}
		return true;
	}
}
