package programmers.bruteForce;

import java.util.HashSet;

public class Solution42839 {
	static char[] chs;
	static boolean[] visited;
	static HashSet<Integer> set;

	public int solution(String numbers) {
		int len = numbers.length();

		visited = new boolean[len];
		set = new HashSet<>();

		for(int i=1; i<=len; i++) {
			chs = new char[i];
			perm(0, i, len, numbers);
		}

		return set.size();

	}
	public static void perm(int start, int r, int n, String numbers) {
		if(start == r) {
			// chs[0]이 0이면 안됨
			if(chs[0] == '0')
				return;

			// 숫자로 변환
			int num = Integer.parseInt(String.valueOf(chs));

			if(isPrimeNumber(num)) {
				set.add(num);
			}
			return;
		}

		for(int i=0; i<n; i++) {
			if(visited[i])
				continue;

			visited[i] = true;
			chs[start] = numbers.charAt(i);
			perm(start+1, r, n, numbers);
			visited[i] = false;
		}
	}

	public static boolean isPrimeNumber(int num) {
		if(num == 1)
			return false;

		for(int i=2; i <= Math.sqrt(num); i++) {
			if(num % i == 0)
				return false;
		}

		return true;
	}
}
