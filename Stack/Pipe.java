package Stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Pipe {// 백준 10799번
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		Stack<Integer> stack = new Stack<Integer>();
		// left bracket: 1 ,, right bracket: 1
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == '(') {
				stack.add(1);
			} else {
				stack.add(0);
			}
		}
		int progress = 0;
		int answer = 0;
		while (!stack.isEmpty()) {
			int pop = stack.pop();
			if (pop == 1) {// 왼쪽 괄호 '(' 라면,
				progress--;
				answer++;
			} else {// 오른쪽 괄호 ')' 라면,
				if (stack.peek() == 1) {// 왼쪽 괄호 '(' 라면, 레이져 만남.
					stack.pop();
					answer += progress;
				} else {// 오른쪽 괄호 ')' 라면,
					progress++;
				}
			}
		}
		System.out.println(answer);
	}
}
