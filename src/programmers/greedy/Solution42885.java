package programmers.greedy;

import java.util.Arrays;

public class Solution42885 {

	public int solution(int[] people, int limit) {
		int boat = 0;

		Arrays.sort(people);

		int right = people.length - 1;
		int left = 0;

		while (right >= left) {
			if (people[right--] + people[left] <= limit) {
				left++;
			}
			boat++;
		}

		return boat;
	}
}
