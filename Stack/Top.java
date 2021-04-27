package Stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Top {//백준 2493번.

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int topN = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] heightInfo = new int[topN];
		for (int i = 0; i < topN; i++) {
			heightInfo[i] = Integer.parseInt(st.nextToken());
		}
		Stack<Integer> stack = new Stack<Integer>();
		stack.add(heightInfo.length - 1);//stack에서 꺼내면서 비교 이루어지게 첫 아파트를 넣어둠.
		for (int i = heightInfo.length - 2; i >= 0; i--) {//다음 층부터 검사.
			if (heightInfo[stack.peek()] < heightInfo[i]) {
				while(!stack.isEmpty()) {
					if(stack.isEmpty() || heightInfo[stack.peek()] >= heightInfo[i]) {
						break;
					}else {
						heightInfo[stack.pop()] = i + 1;
					}
				}
				stack.add(i);
			} else {//자신보다 큰 녀석을 못만났으므로 스택에 넣어둠.
				stack.add(i);
			}
		}
		while(!stack.isEmpty()) {
			heightInfo[stack.pop()] = 0;
		}
		for(int i = 0 ; i < heightInfo.length ; i++) {
			System.out.print(heightInfo[i]+" ");
		}
	}
}
