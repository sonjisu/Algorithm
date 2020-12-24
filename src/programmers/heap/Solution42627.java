package programmers.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution42627 {
	public int solution(int[][] jobs) { // [[0, 3], [1, 9], [2, 6]]
		int answer = 0;
		int len = jobs.length;
		int time = 0;
		int idx = 0;

		// 작업의 처리시간을 오름차순으로 정렬하는 우선순위 큐
		Queue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));

		//  jobs 요청이 들어온 순서대로 정렬
		Arrays.sort(jobs, Comparator.comparingInt(o -> o[0]));

		while (idx < len || !q.isEmpty()) { // idx = 0,1,2 || q가 차있음
			while (idx < len && jobs[idx][0] <= time){ // 최소 작업시간 찾아서
				q.offer(jobs[idx++]); // 큐에 삽입합니다
			}

			if (q.isEmpty()) { //  시작할 수 있는 작업이 없다면 해야 할 작업 중 가장 먼저 해야 할 작업의 요청 시간으로 현재 시간을 바꿈
				time = jobs[idx][0];

			} else { // 큐가 비어있지 않으면
				int[] job = q.poll(); // 가장 작은 소요시간을 가진 잡을 꺼내서
				answer += time - job[0] + job[1]; // time - 시작시간 + 소요시간
				time += job[1]; // 소요시간 더하기 // 3 9 18
			}
		}

		return answer / len; // 평균 처리시간
	}
}
