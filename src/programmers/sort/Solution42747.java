package programmers.sort;

import java.util.Arrays;

public class Solution42747 {
	public int solution(int[] citations) {

		int answer = 0;

		// [1] 전체 논문중 많이 인용된 순으로 정렬한 후
		Arrays.sort(citations); // 0,1,3,5,6

		for (int i = 0; i < citations.length; i++) { // i = 0 1 2 3 4
			int h = citations.length - i; // h = 5 4 3 2 1

			// [2] 피인용수가 논문수와 같아지거나 피인용수가 논문수보다 작아지기 시작하는 숫자가 바로 h
			if ((h <= citations[i])) { // 5,4,3,2,1 <= 0,1,3,5,6
				answer = h;
				break;
			}
		}

		return answer;
	}
}
