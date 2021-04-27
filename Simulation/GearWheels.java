package Simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GearWheels {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] wheels = new String[5];
		wheels[1] = br.readLine();
		wheels[2] = br.readLine();
		wheels[3] = br.readLine();
		wheels[4] = br.readLine();
		int K = Integer.parseInt(br.readLine());
		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			// 과거 값을 기준으로 현재 탐색 중인 톱니와 비교가 이루어질 것이기 때문에 저장해둠.
			int target = Integer.parseInt(st.nextToken());
			int targetDirection = Integer.parseInt(st.nextToken());
			int targetLeftNS = wheels[target].charAt(6);
			int targetRightNS = wheels[target].charAt(2);
			// 저장 값 저장하고, 중점을 회전 시킴.
			if (targetDirection == 1) {
				wheels[target] = rotateRight(wheels[target]);
			} else if (targetDirection == -1) {
				wheels[target] = rotateLeft(wheels[target]);
			}

			// 왼쪽 탐색
			int prevLeftNS = targetLeftNS;
			int prevDirection = targetDirection;
			for (int j = target - 1; j > 0; j--) {
				int currentRightNS = wheels[j].charAt(2);
				if (prevLeftNS != currentRightNS) {// 회전 가능.
					int currentDirection = -prevDirection;// 이 전과 반대방향으로 방향을 바꿔줌.
					prevLeftNS = wheels[j].charAt(6);
					if (currentDirection == 1) {
						wheels[j] = rotateRight(wheels[j]);
					} else if (currentDirection == -1) {
						wheels[j] = rotateLeft(wheels[j]);
					}
					prevDirection = currentDirection;
				} else {
					break;
				}
			}

			// 오른쪽 탐색
			int prevRightNS = targetRightNS;
			prevDirection = targetDirection;
			for (int j = target + 1; j < wheels.length; j++) {
				int currentLeftNS = wheels[j].charAt(6);
				if (prevRightNS != currentLeftNS) {// 회전 가능.
					int currentDirection = -prevDirection;// 이 전과 반대방향으로 방향을 바꿔줌.
					prevRightNS = wheels[j].charAt(2);
					if (currentDirection == 1) {
						wheels[j] = rotateRight(wheels[j]);
					} else if (currentDirection == -1) {
						wheels[j] = rotateLeft(wheels[j]);
					}
					prevDirection = currentDirection;
				} else {
					break;
				}
			}
		}
		int answer = 0;

		for (int i = 1; i < wheels.length; i++) {
			System.out.println(wheels[i]);
			if (wheels[i].charAt(0) != '0') {
				if (i == 1) {
					answer += 1;
				} else if (i == 2) {
					answer += 2;
				} else if (i == 3) {
					answer += 4;
				} else if (i == 4) {
					answer += 8;
				}
			}
		}
		System.out.println(answer);
	}

	public static String rotateRight(String str) {
		return str.charAt(str.length() - 1) + str.substring(0, str.length() - 1);
	}

	public static String rotateLeft(String str) {
		return str.substring(1, str.length()) + str.charAt(0);
	}
}
