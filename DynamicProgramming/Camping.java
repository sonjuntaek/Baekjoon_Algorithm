package DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Camping {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int Case = 0;
		StringBuilder sb = new StringBuilder();
		
		while (true) {
			Case++;
			StringTokenizer st = new StringTokenizer(br.readLine());
			int L = Integer.parseInt(st.nextToken());
			int P = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			if (L == 0 && P == 0 && V == 0) {
				break;
			}
			int answer = (V / P * L) + ((V % P) >= L ? L : V % P);
			sb.append("Case " + Case + ": " + answer + "\n");
		}
		System.out.println(sb);
	}
}
