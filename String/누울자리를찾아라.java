package String;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 누울자리를찾아라 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] field = new int[N][N];
		for (int i = 0; i < N; i++) {
			String inputStr = br.readLine();
			for (int j = 0; j < N; j++) {
				if (inputStr.charAt(j) == 'X') {
					field[i][j] = 1;
				}
			}
		}
		// 가로탐색.
		int horizon = 0;
		for (int i = 0; i < N; i++) {
			boolean find = false;
			int blankCount = 0;
			for (int j = 0; j < N; j++) {
				if (field[i][j] == 1) {
					find = false;
					blankCount = 0;
				} else {
					blankCount++;
					if(blankCount > 1 && find == false) {
						find = true;
						horizon++;
					}
				}
			}
		}
		
		// 세로탐색
		int vertical = 0;
		for (int j = 0; j < N; j++) {
			boolean find = false;
			int blankCount = 0;
			for (int i = 0; i < N; i++) {
				if (field[i][j] == 1) {
					find = false;
					blankCount = 0;
				} else {
					blankCount++;
					if(blankCount > 1 && find == false) {
						find = true;
						vertical++;
					}
				}
			}
		}
		System.out.println(horizon+" "+vertical);
	}
}
