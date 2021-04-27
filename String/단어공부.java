package String;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 단어공부 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		input = input.toLowerCase();
		int[] countArr = new int[26];// a-z까지 갯수를 넣음.
		int maxNum = 0;
		for (int i = 0; i < 26; i++) {
			int count = 0;
			for (int j = 0; j < input.length(); j++) {
				if (input.charAt(j) == (char) 97 + i) {
					count++;
				}
			}
			countArr[i] = count;
			maxNum = Math.max(maxNum, count);
		}
		int count = 0;
		int index = 0;
		for (int i = 0; i < countArr.length; i++) {
			if (maxNum == countArr[i]) {
				index = i;
				count++;
			}
		}

		if (count > 1) {
			System.out.println("?");
		} else {
			System.out.println((char) (65 + index));
		}
	}
}
