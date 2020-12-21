package programmers.hash;

import java.util.*;

class Solution42578 {
	public int solution(String[][] clothes) {
		int cross = 1;

		Map<String, Integer> hm = new HashMap<>();

		for (String[] clo : clothes) {
			hm.put(clo[1], hm.getOrDefault(clo[1], 1) + 1);
		}

		for (String key : hm.keySet()) {
			cross *= hm.get(key);
		}

		return cross - 1;
	}
}