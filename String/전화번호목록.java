package String;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 전화번호목록 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCaseN = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= testCaseN; i++) {
			int N = Integer.parseInt(br.readLine());
			String[] phoneNumArr = new String[N];
			for (int j = 0; j < N; j++) {
				phoneNumArr[j] = br.readLine();
			}
			Arrays.sort(phoneNumArr);
			boolean isConsistence = true;
			for (int j = 1; j < N; j++) {
				if (phoneNumArr[j].startsWith(phoneNumArr[j - 1])) {
					isConsistence = false;
					break;
				}
			}
			if(isConsistence) {
				sb.append("YES\n");
			}else {
				sb.append("NO\n");
			}
		}
		System.out.println(sb);
	}
}
