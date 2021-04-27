package String;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _8진수2진수 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String[] binaryArr = new String[8];
		binaryArr[0] = "000";
		binaryArr[1] = "001";
		binaryArr[2] = "010";
		binaryArr[3] = "011";
		binaryArr[4] = "100";
		binaryArr[5] = "101";
		binaryArr[6] = "110";
		binaryArr[7] = "111";
		if (str.charAt(0) == 0) {
			System.out.println(0);
		} else {
			StringBuilder sb = new StringBuilder();
			sb.append(Integer.toBinaryString(Integer.parseInt(str.charAt(0) + "")));
			for (int i = 1; i < str.length(); i++) {
				sb.append(binaryArr[Integer.parseInt(str.charAt(i) + "")]);
			}
			System.out.println(sb);
		}
	}
}
