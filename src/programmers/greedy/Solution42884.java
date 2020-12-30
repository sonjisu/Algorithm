package programmers.greedy;

import java.util.*;

public class Solution42884 {
	public int solution(int[][] routes) {
		int answer = 0;
		int len = routes.length;
		List<int[]> list = new ArrayList<>();
		Collections.addAll(list, routes);

		// 빨리 나가는 순서대로 정렬
		list.sort(Comparator.comparingInt(a -> a[1]));

		while(!list.isEmpty()) {
			// 첫 번째 차가 빠져나가는 지점
			int position = list.get(0)[1];

			// 카메라에 찍힌 차 빼주기
			for(int i = 0; i < list.size(); i++ ) {
				if(list.get(i)[0] <= position){
					list.remove(i);
					i--;
				}
			}

			// 카메라가 한대 설치
			answer++;
		}
		return answer;
	}
}
