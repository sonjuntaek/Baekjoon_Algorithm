package BFS;

import java.util.ArrayList;
import java.util.LinkedList;

public class TimeTest {
	public static void main(String[] args) {
		//arraylist의 get(i) 함수를 통해 접근하는 것은 오래걸림. 실제 그 인덱스에 대한 접근 시간이 필요.
		//하지만 순차적으로 그냥 이용할거면 향상된 for문을 쓰는 것이 그 인덱스에 접근하는데 드는 시간이 덜 든다.
		//Iterator처럼 다음 인덱스를 바로 이용할 수 있게 설계된 것임.
		
		
		
		ArrayList<Integer> arrlist1 = new ArrayList<Integer>();
		for (int i = 0; i < 25000; i++) {
			arrlist1.add(i);
		}
		
		LinkedList<Integer> arrlist = new LinkedList<Integer>();
		for (int i = 0; i < 25000; i++) {
			arrlist.add(i);
		}
		
		long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
		
		for(int i : arrlist) {
			System.out.print(i+" ");
		}
		System.out.println();
		
		long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
		long secDiffTime = (afterTime - beforeTime); //두 시간에 차 계산
		System.out.println("시간차이(m) : "+secDiffTime);
		
		beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
		
		for(int i : arrlist1) {
			System.out.print(i+" ");
		}
		System.out.println();
		
		afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
		secDiffTime = (afterTime - beforeTime); //두 시간에 차 계산
		System.out.println("시간차이(m) : "+secDiffTime);
		
	}
}
