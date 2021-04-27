package Stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class PostfixNotation {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String content = br.readLine();
		String answer = "";
		Stack<String> stack = new Stack<String>();
		for (int i = 0; i < content.length(); i++) {
			if (content.charAt(i) == '/' || content.charAt(i) == '*') {
				if (!stack.isEmpty() && stack.peek().equals("/")) {
					answer += stack.pop();
					stack.add(content.charAt(i) + "");
					continue;
				} else if (!stack.isEmpty() && stack.peek().equals("*")) {
					answer += stack.pop();
					stack.add(content.charAt(i) + "");
					continue;
				}
				stack.add(content.charAt(i) + "");
			} else if (content.charAt(i) == '+' || content.charAt(i) == '-') {
				while (!stack.isEmpty()) {
					if (!stack.peek().equals("(")) {
						answer += stack.pop();
					}else {
						break;
					}
				}
				stack.add(content.charAt(i) + "");
			} else if (content.charAt(i) == '(') {

				stack.add(content.charAt(i) + "");
			} else if (content.charAt(i) == ')') {
				while (!stack.isEmpty()) {
					if (!stack.peek().equals("(")) {
						answer += stack.pop();
					}else {
						stack.pop();
						break;
					}
				}
				//stack.pop();
			} else {
				answer += content.charAt(i) + "";
			}
		}
		while (!stack.isEmpty()) {
			answer += stack.pop();
		}
		System.out.println(answer);
	}
}
