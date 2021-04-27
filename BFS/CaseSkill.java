package BFS;

import java.util.ArrayList;

public class CaseSkill {
	static int[][] arr = new int[5][5];
	static boolean[][] visited = new boolean[5][5];
	static boolean[][] visited1;

	public static void main(String[] args) {
		// getCase(0, 0);
		int n = 3;
		int depth = 3;
		visited1 = new boolean[n][n];
		getCase1(0, 0, n, new ArrayList<int[]>());
	}

	public static void getCase(int startI, int depth) {// 몇개를 고를 것이냐 depth
		if (depth == 3) {
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr[0].length; j++) {
					System.out.print(visited[i][j] + "  ");
				}
				System.out.println();
			}
			System.out.println();
			System.out.println();
			return;
		}
		// 이렇게 조합이 이루어짐. 각각 왼쪽은 i,오른쪽은 j로 표현되어짐.
		// 여기서 원하는 갯수를 중복없이 뽑으려고하면.
		/*
		 * 0,0 0,1 0,2 0,3 0,4 1,0 1,1 1,2 1,3 1,4 2,0 2,1 2,2 2,3 2,4 3,0 3,1 3,2 3,3
		 * 3,4 4,0 4,1 4,2 4,3 4,4
		 */
		// 조합 구하는법.
		for (int t = 0; t < arr.length * arr[0].length; t++) {
			int i = t / arr[0].length;
			int j = t % arr[0].length;
			if (visited[i][j] == false) {
				visited[i][j] = true;
				getCase(t + 1, depth + 1);
				visited[i][j] = false;
			}
		}
	}

	public static void getCase1(int start, int depth, int n, ArrayList<int[]> arr) {
		// n*n의 배열에서 좌표를 원하는 만큼 구하는 스킬.
		if (depth == 3) {
			for (int i = 0; i < visited1.length; i++) {
				for (int j = 0; j < visited1[0].length; j++) {
					System.out.print(visited1[i][j] + "  ");
				}
				System.out.println();
			}
			System.out.println();

			for (int[] a : arr) {
				System.out.print(a[0] + "," + a[1] + " ");
			}
			System.out.println();
			return;
		}
		// 가능한 경우의 수를 일단 나열.
		for (int t = start; t < n * n; t++) {
			int i = t / n;
			int j = t % n;

			// 하나씩 선택해서 간다.
			visited1[i][j] = true;
			arr.add(new int[] { i, j });
			getCase1(t + 1, depth + 1, n, arr);// 원하는 조건을 넣어서 재귀호출. 조건문 넣어도됨.
			arr.remove(arr.size() - 1);
			visited1[i][j] = false;// 앞에 선택했던 것이 가능한지 안한지 판단 유무.
		}
	}
}
