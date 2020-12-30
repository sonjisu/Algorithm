package baekjoon;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Problem1157 {
	public static void main (String[] args) {
		new Problem1152().solution();
	}

	public void solution() {
		Scanner sc = new Scanner(System.in);


		try{
			String word = sc.nextLine();
			String s = word.toUpperCase();

			Map<Character, Integer> hm = new HashMap<>();

			if (s.length() == 1) {
				System.out.println(s);
				return;
			}

			for (int i = 0; i < s.length(); i++) {
				hm.put(s.charAt(i), hm.getOrDefault(s.charAt(i), 0) +1);

			}

			List<Character> keySet = new ArrayList<>(hm.keySet());

			keySet.sort((o1, o2) -> hm.get(o2) - hm.get(o1));



			if (!hm.get(keySet.get(0)).equals(hm.get(keySet.get(1)))) {
				System.out.println(keySet.get(0));
			}

			if (hm.get(keySet.get(0)).equals(hm.get(keySet.get(1)))) {
				System.out.println("?");
			}


		} catch (Exception e) {

		}
	}
}

/**
 try{

 for (String value : s) {
 hm.put(value, hm.getOrDefault(value, 0) + 1);
 }

 List<String> keySet = new ArrayList<>(hm.keySet());

 keySet.sort((o1, o2) -> hm.get(o2) - hm.get(o1));


 if (!hm.get(keySet.get(0)).equals(hm.get(keySet.get(1)))) {
 System.out.println(keySet.get(0));
 }

 if (hm.get(keySet.get(0)).equals(hm.get(keySet.get(1)))) {
 System.out.println("?");
 }


 } catch (Exception e) {

 }
 */