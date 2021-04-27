package Stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class AlienGuitar {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int Num = Integer.parseInt(st.nextToken());
		int Plat = Integer.parseInt(st.nextToken());
		Stack<Integer>[] stackArr = new Stack[Num + 1];

		// 각 줄마다 스택을 구성해둠,
		for (int i = 1; i < stackArr.length; i++) {
			stackArr[i] = new Stack<Integer>();
		}

		// 한줄씩 읽어서 스택에 조건에 맞게 넣으며 횟수 세어줌.
		int count = 0;
		for (int i = 0; i < Num; i++) {
			st = new StringTokenizer(br.readLine());
			int Nth = Integer.parseInt(st.nextToken());
			int platN = Integer.parseInt(st.nextToken());
			if (stackArr[Nth].isEmpty()) {
				count++;
				stackArr[Nth].add(platN);
			} else {
				if (stackArr[Nth].peek() < platN) {// 앞에 누르던 것들을 뗄 필요가 없음.
					count++;
					stackArr[Nth].add(platN);
				} else if (stackArr[Nth].peek() > platN) {// 앞에 누르던 것들을 뗄 필요가 있음.
					while (!stackArr[Nth].isEmpty()) {
						if (stackArr[Nth].peek() <= platN) {
							break;
						} else {
							stackArr[Nth].pop();
							count++;
						}
					}
					if (stackArr[Nth].isEmpty()) {// 비었으면 넣어주면 됨.
						count++;
						stackArr[Nth].add(platN);
					} else if (stackArr[Nth].isEmpty() || stackArr[Nth].peek() < platN) {// 작은게 나왔으면 새롭게 누르는거니추가.
						count++;
						stackArr[Nth].add(platN);
					} else {// 같은것이 나왔다면 이미 누르고 있는 상태 유지.

					}
				} else {// 이미 누르고 있는 코드일 경우 아무일도 일어나지 않음.

				}
			}
		}
		System.out.println(count);
	}
}
