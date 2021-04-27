package String;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class _30 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int sum = 0;
		Integer[] numArr = new Integer[str.length()];
		int zeroCount = 0;
		for (int i = 0; i < str.length(); i++) {
			int num = Integer.parseInt(str.charAt(i) + "");
			if(num == 0) {
				zeroCount++;
			}
			sum += num;
			numArr[i] = num;
		}
		Arrays.sort(numArr, Comparator.reverseOrder());

		StringBuilder sb = new StringBuilder();
		if (zeroCount > 0 && sum % 3 == 0) {
			for (int i = 0; i < numArr.length; i++) {
				if (numArr[i] != 0) {
					sb.append(numArr[i]);
				}
			}
			for (int i = 0; i < zeroCount; i++) {
				sb.append("0");
			}
		} else {
			System.out.println(-1);
		}
		System.out.println(sb);
	}
}
