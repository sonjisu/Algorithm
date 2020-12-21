package programmers.hash;

import java.util.*;

class Solution42579 {
	public int[] solution(String[] genres, int[] plays) {
		List<Integer> answer = new ArrayList<>();

		// 장르별 스트리밍 수 세기: m -> <classic, 1450>, <pop, 3100>
		Map<String, Integer> m = new HashMap<>();
		for (int i = 0; i < genres.length; i++) {
			m.put(genres[i], m.getOrDefault(genres[i], 0) + plays[i]);
		}

		// Value 내림차순으로 정렬
		ArrayList<String> al = new ArrayList<>(m.keySet());
		al.sort((o1, o2) -> (m.get(o2).compareTo(m.get(o1))));

		for (String TempGenres : al) {
			int firstIdx = 0;
			int secondIdx = 0;
			int max = 0;

			for (int j = 0; j < genres.length; j++) {    // 첫번째 값 구하기
				if (TempGenres.equals(genres[j])) {
					if (plays[j] > max) {
						max = plays[j];
						firstIdx = j;
					}
				}
			}

			max = -1; //장르가 하나일 수 있으므로

			for (int j = 0; j < genres.length; j++) {    // 두번째 값 구하기
				if (TempGenres.equals(genres[j])) {
					if (j != firstIdx && plays[j] > max) {
						max = plays[j];
						secondIdx = j;
					}
				}
			}

			answer.add(firstIdx);

			if (max != -1) {
				answer.add(secondIdx);
			}
		}
		return answer.stream().mapToInt(Integer::valueOf).toArray();
	}
}
