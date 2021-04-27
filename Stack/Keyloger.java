package Stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Keyloger {//백준 5397번.

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCaseN = Integer.parseInt(br.readLine());
		Stack<String> leftStack = new Stack<String>();
		Stack<String> rightStack = new Stack<String>();
		StringBuilder sb= new StringBuilder();
		for (int i = 0; i < testCaseN; i++) {
			String input = br.readLine();
			for (int j = 0; j < input.length(); j++) {
				if (input.charAt(j) == '<') {// 왼쪽으로 이동.
					if (!leftStack.isEmpty()) {
						rightStack.add(leftStack.pop());
					}
				} else if (input.charAt(j) == '>') {// 오른쪽으로 이동.
					if (!rightStack.isEmpty()) {
						leftStack.add(rightStack.pop());
					}
				} else if (input.charAt(j) == '-') {// 커서기준 왼쪽 지우기.
					if (!leftStack.isEmpty()) {
						leftStack.pop();
					}
				} else {// 일반 문자 입력. 커서기준 왼쪽에 입력해줌.
					leftStack.add(input.charAt(j) + "");
				}
			}
			
			while(!leftStack.isEmpty()) {
				rightStack.add(leftStack.pop());
			}
			while(!rightStack.isEmpty()) {
				sb.append(rightStack.pop());
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
