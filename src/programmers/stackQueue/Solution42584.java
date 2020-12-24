package programmers.stackQueue;

import java.util.ArrayList;
import java.util.List;

public class Solution42584 {
	public int[] solution(int[] prices) {
		int len = prices.length;
		int[] answer = new int[len];
		int count = 0;
		int num = 0;

		List<Integer> arr = new ArrayList<>();

		for (int i = 0; i < len - 1 ; i++) {
			count = 0;
			for (int j = i + 1; j < len; j++){

				if (prices[i] <= prices[j]) {
					count++;
				} else {
					count += 1;
					break;
				}
			}
			arr.add(count);
		}
		arr.add(0);


		for (Integer n : arr) {
			answer[num++] = n.intValue();
		}

		return answer;
	}
}
