package programmers.greedy;

public class Solution42860 {
	public int solution(String name) { // JEROEN
		int answer = 0;

		// 상하최소
		for (int i = 0; i < name.length(); i++) {
			int right = name.charAt(i)-'A';
			int left = 'Z'-name.charAt(i)+1;

			if (right < left) {
				if (right == 0) {
					continue;
				}
				answer += right;
			} else {
				answer += left;
			}
		}

		//좌우최소: 오른쪽으로 이동 시 'A'아닐 때마다 다음 'A'가 아닌 문자까지 왼쪽으로 계속 이동하여 거리를 구한다
		int minMove = name.length() - 1;
		for(int i = 0 ; i < name.length() ; i++) {
			if(name.charAt(i) != 'A') {
				int next = i+1;
				while(next < name.length() && name.charAt(next) == 'A') {
					next++;
				}
				int move = 2 * i + name.length() - next;
				minMove = Math.min(move, minMove);
			}
		}

		return answer+minMove; // 56
	}
}
