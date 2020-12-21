package programmers.hash;

import java.util.*;

class Solution42577 {
	public boolean solution(String[] phone_book) {

		Arrays.sort(phone_book);
		int len = phone_book.length;

		for (int i=0; i<len-1; i++) {
			for (int j=i+1; j<len; j++) {
				if (phone_book[j].startsWith(phone_book[i])) {
					return false;
				}
			}
		}
		return true;
	}
}
