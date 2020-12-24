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
			chs = new char[i]; // char[1], char[2], char[3]
			perm(0, i, len, numbers); // perm(0, 1, 전체 자릿수, 타겟), perm(0, 2, 전체 자릿수, 타겟), perm(0, 3, 전체 자릿수, 타겟)
		}

		return set.size();

	}
	public static void perm(int start, int r, int n, String numbers) {
		if(start == r) { // 새로 넣은 숫자가 r과 같으면
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
			chs[start] = numbers.charAt(i);// 첫째수에 numbers의 숫자들 순회해서 넣기
			perm(start+1, r, n, numbers); // start는 새로 넣은 숫자 카운팅
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
