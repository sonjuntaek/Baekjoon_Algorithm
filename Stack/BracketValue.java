package Stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BracketValue {//백준 2504번.
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String bracket = br.readLine();
		Stack<String> stack = new Stack<String>();
		boolean isOk = true;
		for (int i = 0; i < bracket.length(); i++) {
			if (bracket.charAt(i) == '(' || bracket.charAt(i) == '[') {
				stack.add(bracket.charAt(i) + "");
			} else {
				if (stack.isEmpty()) {
					isOk = false;
					break;
				} else {
					if (bracket.charAt(i) == ')') {
						// 숫자 혹은 다른 괄호, 자신의 짝일 경우.
						int temp = 0;
						while (!stack.isEmpty()) {

							if (stack.peek().equals("[")) {// 에러.(다른괄호일 경우)
								isOk = false;
								break;
							} else if (stack.peek().equals("(")) {// 옳바른 종료.
								stack.pop();
								if (temp == 0)
									temp = 1;
								stack.add(temp * 2 + "");
								break;
							} else { // 숫자일 경우.
								temp += Integer.parseInt(stack.pop());
							}
						}
						if (stack.isEmpty()) {// 결국 짝에 맞는 괄호가 없을 경우.
							isOk = false;
							break;
						}

					} else {// 숫자 혹은 다른 괄호, 본인의 짝일 경우.
						int temp = 0;
						while (!stack.isEmpty()) {
							if (stack.peek().equals("(")) {// 에러(다른괄호일 경우)
								isOk = false;
								break;
							} else if (stack.peek().equals("[")) {// 올바른 종료
								stack.pop();
								if (temp == 0)
									temp = 1;
								stack.add(temp * 3 + "");
								break;
							} else {
								temp += Integer.parseInt(stack.pop());
							}
						}
						if (stack.isEmpty()) {// 결국 짝에 맞는 괄호가 없을 경우.
							isOk = false;
							break;
						}

					}
				}
			}
		}
		int answer = 0;
		while (!stack.isEmpty()) {
			if (stack.peek().equals("[") || stack.peek().equals("(")) {
				isOk = false;
				break;
			}
			answer += Integer.parseInt(stack.pop());
		}
		if (isOk) {
			System.out.println(answer);
		} else {
			System.out.println(0);
		}
	}
}

/*
 * 왼쪽 괄호가 더 많은 경우. 괄호의 순서쌍이 맞지 않는 경우. 오른쪽 괄호가 더 많은 경우.
 * 
 * 
 */
