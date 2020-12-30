package programmers.dp;

public class Solution43105 {
	public int solution(int[][] triangle) {
		// 1. 기본값 초기화
		int[][] dp = new int[triangle.length][triangle.length];
		dp[0][0] = triangle[0][0];
		for(int i = 1; i < triangle.length; i++) {
			dp[i][0] = dp[i - 1][0] + triangle[i][0]; // 왼쪽 끝 값
			dp[i][i] = dp[i - 1][i - 1] + triangle[i][i]; // 오른쪽 끝 값
		}
		/**
		 * 7  0  0 0 0
		 * 10 15 0 0 0
		 * 18 0 15 0 0
		 * 20 0 0 19 0
		 * 24 0 0 0 24
		 */

		// 2. DP
		for(int i = 2; i < triangle.length; i++) {
			for (int j = 1; j < i; j++) {
				dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j];
			}
		}

		/**
		 * 7   0  0  0  0
		 * 10 15  0  0  0
		 * 18 16 15  0  0
		 * 20 25 20 19  0
		 * 24 30 27 26 24
		 */

		// 3. 최대값 반환
		int max = 0;
		for(int i = 0; i < dp.length; i++)
			max = Math.max(max, dp[dp.length - 1][i]);

		return max;
	}
}
