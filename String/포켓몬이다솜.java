package String;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 포켓몬이다솜 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashMap<String, Integer> String_hm = new HashMap<String, Integer>();
		HashMap<Integer, String> Integer_hm = new HashMap<Integer, String>();
		for (int i = 1; i <= N; i++) {
			String name = br.readLine();
			String_hm.put(name, i);
			Integer_hm.put(i, name);
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= M; i++) {
			String input = br.readLine();
			if (input.matches("^\\d+")) {
				sb.append(Integer_hm.get(Integer.parseInt(input))+"\n");
			} else {
				sb.append(String_hm.get(input)+"\n");
			}
		}
		System.out.println(sb);
	}
}
