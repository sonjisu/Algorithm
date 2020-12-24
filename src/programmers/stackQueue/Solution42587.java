package programmers.stackQueue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution42587 {
	public int solution(int[] priorities, int location) {
		int answer = 0;
		int target = priorities[location]; // 3

		Queue<Document> documentQueue = new LinkedList<>();

		for (int i = 0; i < priorities.length; i++) {
			documentQueue.add(new Document(priorities[i], i));
		}

		Arrays.sort(priorities);

		while (documentQueue.peek().priority != priorities[priorities.length-1]){
			documentQueue.add(documentQueue.remove());
		}

		while (!documentQueue.isEmpty()) {
			if (documentQueue.remove().location != target) {
				answer++;
			} else {
				break;
			}
		}


		return answer;
	}
}

class Document {
	int priority;
	int location;

	public Document(int priority, int location) {
		this.priority = priority;
		this.location = location;
	}

}