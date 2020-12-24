package programmers.stackQueue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution42586 {
	public int[] solution(int[] progresses, int[] speeds) {
		int[] answer = {};
		int len = progresses.length;
		int count;

		//완료 작업시간 {5, 10, 1, 1, 20, 1}
		Queue<Integer> q = new LinkedList<>();
		List<Integer> distribute = new ArrayList<>();

		for (int i = 0; i < len; i++) {
			int needDay = (100-progresses[i])/speeds[i];
			if ((100-progresses[i]) % speeds[i] != 0) {
				needDay++;
			}
			q.add(needDay);
		}

		while(!q.isEmpty()) {
			count = 0;
			int first = q.remove();
			count++;

			while (!q.isEmpty() && first >= q.peek()) {
				q.remove();
				count++;
			}

			distribute.add(count);
		}

		answer = new int[distribute.size()];

		for (int i = 0; i < distribute.size(); i++) {
			answer[i] = distribute.get(i);
		}

		return answer;
	}
}
