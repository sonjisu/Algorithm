package programmers.hash;

import java.util.*;

class Solution42579 {
	public int[] solution(String[] genres, int[] plays) {
		List<Integer> answer = new ArrayList<>();

		Map<String, Integer> hm = new HashMap<>();

		// 장르별 스트리밍 수 세기: m -> <classic, 1450>, <pop, 3100>
		for (int i = 0; i < genres.length; i++) {
			hm.put(genres[i], hm.getOrDefault(genres[i], 0) + plays[i]);
		}

		// Value 내림차순으로 정렬
		List<String> list = new ArrayList<>(hm.keySet());
		//list.sort(Comparator.reverseOrder());
		list.sort((o1, o2) -> hm.get(o2).compareTo(hm.get(o1)));

		for (String s : list) {
			int idx1 = 0;
			int idx2 = 0;
			int max = 0;

			for (int i = 0; i < genres.length; i++) {
				if (s.equals(genres[i])){
					if (plays[i] > max) {
						max = plays[i];
						idx1 = i;
					}
				}
			}

			max = -1; //장르가 하나일 수 있으므로

			for (int i = 0; i < genres.length; i++) {
				if (s.equals(genres[i])){
					if (i != idx1 && plays[i] > max) {
						max = plays[i];
						idx2 = i;
					}
				}
			}

			answer.add(idx1);
			if (max != -1) {
				answer.add(idx2);
			}

		}

		return answer.stream().mapToInt(Integer::valueOf).toArray();
	}
}
