package String;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _2진수8진수 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		StringBuilder answer = new StringBuilder();
		int sum = 0;
		if (s.length() % 3 == 2) {
			sum += (s.charAt(0) - '0') * 2;//해당 위치에 1이면 1이 나오고,0이면 0이나옴.
			sum += (s.charAt(1) - '0') * 1;
			answer.append(sum);
			s = s.substring(2);
		}
		if (s.length() % 3 == 1) {
			sum += (s.charAt(0) - '0') * 1;
			answer.append(sum);
			s = s.substring(1);
		}

		for (int i = 0; i <= s.length() - 3; i += 3) {
			sum = 0;

			sum += (s.charAt(i) - '0') * 4;
			sum += (s.charAt(i + 1) - '0') * 2;
			sum += (s.charAt(i + 2) - '0') * 1;

			answer.append(sum);
		}

		System.out.println(answer);
	}
}
