package programmers.heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class Solution42628 {
	public int[] solution(String[] operations) { // String[] operations = {"I 16","D 1"};

		DoubleQueue dq = new DoubleQueue(operations.length);

		for (String s : operations) {
			String[] op = s.split(" ");

			switch (op[0]) {
				case "I":
					dq.queue(Integer.parseInt(op[1]));
					break;
				case "D":
					if (op[1].equals("1")) dq.dequeueMax();
					else dq.dequeueMin();
					break;
			}
		}

		return dq.maxMin();

		// int[] answer = new int[2];
		// PriorityQueue<Integer> pq = new PriorityQueue<>();
		// TreeMap<Integer, Integer> treeMap = new TreeMap<>();
		//
		// for (String operation : operations) {
		// 	String[] s = operation.split(" ");
		//
		// 	switch (s[0]) {
		// 		case "I" :
		// 			treeMap.put(Integer.valueOf(s[1]), Integer.valueOf(s[1]));
		// 			// pq.add(Integer.valueOf(s[1]));
		// 			break;
		// 		case "D" :
		//
		// 			if (!treeMap.isEmpty()) {
		// 				if (s[1].equals("-1")) {
		// 					treeMap.pollFirstEntry();
		// 				} else {
		// 					treeMap.pollLastEntry();
		// 				}
		// 			}
		// 			break;
		//
		// 		default:
		// 			break;
		// 	}
		// }
		//
		// // 처리한 후 큐가 비어있으면 [0,0] 비어있지 않으면 [최댓값, 최솟값]
		// if (treeMap.isEmpty()) {
		// 	answer[0] = 0;
		// 	answer[1] = 0;
		// } else {
		// 	answer[0] = treeMap.lastEntry().getValue();
		// 	answer[1] = treeMap.firstEntry().getValue();
		// }
		// return answer;
	}
}

class DoubleQueue {
	PriorityQueue<Integer> max;
	PriorityQueue<Integer> min;
	int size = 0;
	int cap;

	public DoubleQueue(int cap) {
		this.cap = cap;

		min = new PriorityQueue<Integer>();
		max = new PriorityQueue<Integer>(Comparator.reverseOrder());
	}

	void queue(int n) {
		this.size++;
		this.max.add(n);
		this.min.add(n);
	}

	private void clear() {
		this.max.clear();
		this.min.clear();
	}

	int dequeueMax() {
		int ret = this.max.poll();
		if (--size == 0) clear();

		return ret;
	}

	int dequeueMin() {
		int ret = this.min.poll();
		if (--size == 0) clear();
		return ret;
	}

	int[] maxMin() {
		if (size == 0) return new int[]{0, 0};

		int minVal = min.peek();
		int maxVal = max.peek();
		return new int[]{maxVal, minVal};
	}
}

