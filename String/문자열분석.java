package String;

import java.util.Scanner;

public class 문자열분석 {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		while (input.hasNextLine()) {
			String str = input.nextLine();
			if(str.isEmpty()) {
				System.out.println(str);
				break;
			}
			String temp = str.replaceAll("[^a-z]", "");
			sb.append(temp.length() + " ");
			temp = str.replaceAll("[^A-Z]", "");
			sb.append(temp.length() + " ");
			temp = str.replaceAll("\\D", "");
			sb.append(temp.length() + " ");
			temp = str.replaceAll("\\S", "");
			sb.append(temp.length() + "\n");
		}
		System.out.println(sb);
	}
}
