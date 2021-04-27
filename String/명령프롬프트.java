package String;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 명령프롬프트 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] fileArr = new String[N];
		for (int i = 0; i < N; i++) {
			fileArr[i] = br.readLine();
		}
		int fileNamelen = fileArr[0].length();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < fileNamelen; i++) {
			char currentChar = fileArr[0].charAt(i);
			boolean isSame = true;
			for (int j = 1; j < fileArr.length; j++) {
				if (fileArr[j].charAt(i) != currentChar) {//하나라도 다르면
					isSame = false;
					break;
				}
			}
			if (isSame) {//해당 위치의 문자가 다 똑같다면, 그 문자로
				sb.append(currentChar);
			} else {//해당 위치의 문자가 하나라도 다른게 있다면 ? 로 채운다.
				sb.append("?");
			}
		}
		System.out.println(sb);
	}
}
