package BruteForce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 치킨배달 {
	static ArrayList<int[]> homeList;
	static ArrayList<int[]> chickenList;
	static ArrayList<int[]> selectedList;
	static int N;
	static int M;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		homeList = new ArrayList<int[]>();
		chickenList = new ArrayList<int[]>();
		selectedList = new ArrayList<int[]>();
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				int temp = Integer.parseInt(st.nextToken());
				if (temp == 1) {
					homeList.add(new int[] { i, j });
				} else if (temp == 2) {
					chickenList.add(new int[] { i, j });
				}
			}
		}
		go(0);
		System.out.println(min);
	}

	public static void go(int start) {
		if (selectedList.size() == M) {// M개를 뽑았으면 종료.
			min = Math.min(min, calculateSum());
			return;
		}
		for (int i = start; i < chickenList.size(); i++) {
			selectedList.add(chickenList.get(i));
			go(i + 1);
			selectedList.remove(selectedList.size() - 1);
		}
	}

	public static int calculateSum() {
		int sum = 0;
		for (int[] h : homeList) {
			int min = Integer.MAX_VALUE;
			for (int[] a : selectedList) {
				int distance = Math.abs(h[0] - a[0]) + Math.abs(h[1] - a[1]);
				min = Math.min(min, distance);
			}
			sum += min;
		}
		return sum;
	}
}
