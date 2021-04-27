package Stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Editer {// 백준 1406번
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String content = br.readLine();
		int inputN = Integer.parseInt(br.readLine());

		// 커서를 기준으로 왼쪽 오른쪽 스택으로 나뉨.
		Stack<String> leftStack = new Stack<String>();
		Stack<String> rightStack = new Stack<String>();
		for (int i = 0; i < content.length(); i++) {
			leftStack.add(content.charAt(i) + "");
		}
		for (int i = 0; i < inputN; i++) {
			String command = br.readLine();
			if (command.startsWith("P")) {
				String[] temp = command.split(" ");
				String inputStr = temp[1];
				leftStack.add(inputStr.charAt(0) + "");
			} else if (command.startsWith("L")) {
				if (!leftStack.isEmpty()) {// 제일 왼쪽으로 커서 가있을 경우를 대비.
					rightStack.add(leftStack.pop());
				}
			} else if (command.startsWith("D")) {
				if (!rightStack.isEmpty()) {
					leftStack.add(rightStack.pop());
				}
			} else if (command.startsWith("B")) {
				if (!leftStack.isEmpty()) {
					leftStack.pop();
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		while (!leftStack.isEmpty()) {
			rightStack.add(leftStack.pop());
		}
		while (!rightStack.isEmpty()) {
			sb.append(rightStack.pop());
		}
		System.out.println(sb);
	}
}
