package String;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class _2진수8진수_2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputStr = br.readLine();
		StringBuilder sb = new StringBuilder();
		int sum = 0;
		if (inputStr.length() % 3 == 1) {
			sb.append((inputStr.charAt(0) - '0') * 1);
			inputStr = inputStr.substring(1);
		} else if (inputStr.length() % 3 == 2) {
			sum += 2 * (inputStr.charAt(0) - '0');
			sum += 1 * (inputStr.charAt(1) - '0');
			sb.append(sum);
			inputStr = inputStr.substring(2);
		}

		for (int i = 0; i <= inputStr.length() - 3; i += 3) {
			sum = 0;
			sum += 4 * (inputStr.charAt(i) - '0');
			sum += 2 * (inputStr.charAt(i + 1) - '0');
			sum += 1 * (inputStr.charAt(i + 2) - '0');
			sb.append(sum);
		}
		System.out.println(sb);
	}
}
