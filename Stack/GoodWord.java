package Stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class GoodWord {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		Stack<Character> stack = new Stack<Character>();
		int count = 0;
		for (int i = 0; i < num; i++) {
			stack.clear();
			String inputWord = br.readLine();
			for (int j = 0; j < inputWord.length(); j++) {
				// 스택이 비어있지 않으면
				// peek값과 현재값 비교하고 다르면 넣어주되 크기를 판단하고 넣음.
				if (!stack.isEmpty()) {// 현재 비교값과 같다면 빼주면 됨.
					if (stack.peek() == inputWord.charAt(j)) {
						stack.pop();
					} else {
						stack.add(inputWord.charAt(j));
					}
				} else {// 스택 비어있으면 넣어줘야지. 짝이 없는 상태이므로.
					stack.add(inputWord.charAt(j));
				}
			}
			if (stack.isEmpty()) {
				count++;
			}
		}
		System.out.println(count);
	}
}
