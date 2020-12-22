package programmers.bruteForce;

public class Solution42842 {
	public int[] solution(int brown, int yellow) {
		int x = 0, y = 0;

		// [1] (brown+4)/2 은 x+y의 최댓값
		for (y = 3; y <= (int) (brown+4)/2 ; y++) {
			x = ((brown + 4) / 2 ) - y; // 도출가능한 식 1

			if (x < y) { // 제한사항 3
				break;
			}

			int yelloCount = (x - 2) * (y - 2); // 도출가능한 식 2

			if (yellow == yelloCount) {
				break;
			}
		}

		return new int[] {x, y};
	}
}
