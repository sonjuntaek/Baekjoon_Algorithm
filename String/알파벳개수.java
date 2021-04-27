package String;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 알파벳개수 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 26; i++) {
			int count = 0;
			for (int j = 0; j < str.length(); j++) {
				if (str.charAt(j) == (char) 97 + i) {
					count++;
				}
			}
			sb.append(count + " ");
		}
		System.out.println(sb);
	}
}
