package Stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class StringBomb {
//	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		String originStr = br.readLine();
//		String bombStr = br.readLine();
//		while (originStr.contains(bombStr)) {
//			originStr = originStr.replace(bombStr, "");
//		}
//		if (originStr.equals("")) {
//			System.out.println("FRULA");
//		} else {
//			System.out.println(originStr);
//		}
//	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String originStr = br.readLine();
		String bombStr = br.readLine();
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < originStr.length(); i++) {
			stack.add(originStr.charAt(i));
			boolean isBomb = true;
			if (stack.size() >= bombStr.length() && stack.peek() == bombStr.charAt(bombStr.length() - 1)) {
				// 폭탄인지 비교 이루어짐.
				//System.out.println("before "+stack);
				for (int j = 0; j < bombStr.length() - 1; j++) {
					if (stack.get(stack.size() - bombStr.length() + j) != bombStr.charAt(j)) {
						isBomb = false;
						break;
					}
				}
				if (isBomb) {
					for (int j = 0; j < bombStr.length(); j++) {
						stack.pop();
					}
				}
				//System.out.println("after "+stack);
			}
		}
		StringBuilder sb = new StringBuilder();
		for (Character c : stack) {
			sb.append(c);
		}
		if(sb.length() == 0 ) {
			System.out.println("FRULA");
		}else {
			System.out.println(sb);
		}
	}
}
