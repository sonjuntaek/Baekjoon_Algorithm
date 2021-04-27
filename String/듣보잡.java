package String;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;

public class 듣보잡 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashSet<String> hs1 = new HashSet<String>();
		HashSet<String> hs2 = new HashSet<String>();
		for (int i = 0; i < N; i++) {
			hs1.add(br.readLine());
		}
		for (int i = 0; i < M; i++) {
			hs2.add(br.readLine());
		}
		ArrayList<String> answerList = new ArrayList<String>();
		StringBuilder sb = new StringBuilder();
		Iterator<String> iter = hs1.iterator();
		while (iter.hasNext()) {
			String str = iter.next();
			if (hs2.contains(str)) {
				answerList.add(str);
			}
		}
		Collections.sort(answerList);
		sb.append(answerList.size()+"\n");
		for(String s : answerList) {
			sb.append(s+"\n");
		}
		System.out.println(sb);
	}
}
