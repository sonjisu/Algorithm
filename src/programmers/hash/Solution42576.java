package programmers.hash;

import java.util.*;

class Solution42576 {
	public String solution(String[] participant, String[] completion) {

		int i;

		// [1] 각 배열을 오름차순으로 정렬
		Arrays.sort(participant); // {"leo", "kiki", "eden"}; => {eden, kiki, leo}
		Arrays.sort(completion); // {"eden", "kiki"}; => {eden, kiki}

		// [2] 정렬된 배열을 앞에서부터 비교해서, 달라지는 순간(완주하지 못한 선수 발견) 참가자 이름 리턴
		for (i = 0; i < completion.length; i++) {
			if (!participant[i].equals(completion[i])) {
				return participant[i];
			}
		}
		return participant[i]; // [3] 완주하지 못한 선수가 가장 끝에 있는 경우
	}
}
