package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Problem1152 {
	public static void main (String[] args) {
		new Problem1152().solution();
	}

	public void solution() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try{
			String text = br.readLine();
			String[] s = text.split(" ");
			int answer = s.length;


			for (String s1 : s) {
				if (s1.equals("")) {
					answer--;
				}
			}

			System.out.println(answer);

		} catch (Exception e) {

		}
	}
}
