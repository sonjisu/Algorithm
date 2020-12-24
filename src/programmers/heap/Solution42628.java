package programmers.heap;

import java.util.PriorityQueue;
import java.util.TreeMap;

public class Solution42628 {
	public int[] solution(String[] operations) { // String[] operations = {"I 16","D 1"};
		int[] answer = new int[2];
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		TreeMap<Integer, Integer> treeMap = new TreeMap<>();

		for (String operation : operations) {
			String[] s = operation.split(" ");

			switch (s[0]) {
				case "I" :
					treeMap.put(Integer.valueOf(s[1]), Integer.valueOf(s[1]));
					// pq.add(Integer.valueOf(s[1]));
					break;
				case "D" :

					if (!treeMap.isEmpty()) {
						if (s[1].equals("-1")) {
							treeMap.pollFirstEntry();
						} else {
							treeMap.pollLastEntry();
						}
					}
					break;

				default:
					break;
			}
		}

		// 처리한 후 큐가 비어있으면 [0,0] 비어있지 않으면 [최댓값, 최솟값]
		if (treeMap.isEmpty()) {
			answer[0] = 0;
			answer[1] = 0;
		} else {
			answer[0] = treeMap.lastEntry().getValue();
			answer[1] = treeMap.firstEntry().getValue();
		}
		return answer;
	}
}
