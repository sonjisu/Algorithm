package programmers.sort;

import java.util.Arrays;

public class Solution42748 {
	public int[] solution(int[] array, int[][] commands) {

		int[] answer = new int[commands.length];
		int[] copy = {};
		int i = 0;

		for (int[] command : commands) {
			copy = Arrays.copyOfRange(array, command[0]-1, command[1]);
			Arrays.sort(copy);
			answer[i++] = copy[command[2]-1];
		}

		return answer;
	}
}
