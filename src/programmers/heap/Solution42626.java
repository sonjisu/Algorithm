package programmers.heap;

import java.util.PriorityQueue;

public class Solution42626 {
	public int solution(int[] scoville, int K) {

		int answer = 0;
		int newScoville = 0;

		PriorityQueue<Integer> pq = new PriorityQueue();

		for (int s : scoville) {
			pq.add(s);
		}

		while (pq.peek() < K) {
			if(pq.size()==1) {
				answer = -1;
				break;
			}
			if (pq.peek() != null) {
				int first = pq.poll();
				if (pq.peek() != null) {
					int second = pq.poll();
					// 섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
					newScoville = first + (second * 2);
					pq.add(newScoville);
					answer++;
				} else {
					break;
				}
			}
		}

		return answer;
	}
}
