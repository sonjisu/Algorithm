package programmers.sort;

import java.util.Arrays;

public class Solution42746 {
	public String solution(int[] numbers) {

		StringBuilder sb = new StringBuilder();
		String[] token = new String[numbers.length];

		for (int n = 0; n < numbers.length; n++) {
			token[n] = String.valueOf(numbers[n]);
		}

		// Arrays.programmers.sort(token, new Comparator<String>()  {
		// 	@Override
		// 	public int compare (String o1, String o2) {
		// 		return (o2+o1).compareTo(o1+o2);
		// 	}
		// }); 이 코드가 한줄로 바뀌는 매직

		Arrays.sort(token, (o1, o2) -> (o2+o1).compareTo(o1+o2));

		if(token[0].equals("0")) {
			sb.append("0");
		} else {
			for (int j = 0; j < token.length; j++) {
				sb.append(token[j]);
			}
		}

		return sb.toString();
	}
}
