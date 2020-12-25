package programmers.greedy;

import java.util.ArrayList;
import java.util.List;

public class Solution42862 {
	public int solution(int n, int[] lost, int[] reserve) {
		int answer = n;
		List<Student> students = new ArrayList<>();

		// n개의 학생 객체
		for (int i = 0; i < n ; i++) {
			Student student = new Student(1);
			students.add(student);
		}

		// 여분의 체육복이 있는 학생
		for (int i : reserve) {
			students.get(i-1).clothes++;
		}

		// 잃어버린 학생
		for (int i : lost) {
			students.get(i-1).clothes--;
		}

		// 빌려주기 시작
		for (int i = 0; i < n; i++) {
			// 학생이 체육복이 없으면
			if (students.get(i).clothes == 0) {
				if (i==0) { // 1번 학생은 다음 학생에게만 빌림
					if (students.get(i+1).clothes > 1) {
						students.get(i).clothes++;
						students.get(i+1).clothes--;
					}
				} else if (i==n-1) { // 마지막 학생은 전 학생에게만 빌림
					if (students.get(i-1).clothes > 1) {
						students.get(i).clothes++;
						students.get(i-1).clothes--;
					}
				} else { // 가운데 번호인 학생들은 양쪽에게 빌림
					if (students.get(i-1).clothes > 1) {
						students.get(i).clothes++;
						students.get(i-1).clothes--;
					} else if (students.get(i+1).clothes > 1) {
						students.get(i).clothes++;
						students.get(i+1).clothes--;
					}
				}
			}
		}

		// 전체 학생 수에서 체육복 없는 학생들 지워주기
		for (Student s : students) {
			if (s.clothes == 0) {
				answer--;
			}
		}

		return answer; // 체육 수업들을 수 있는 학생 최댓값 리턴
	}
}

class Student {
	int clothes; // 갖고 있는 옷의 수

	public Student(int clothes) {
		this.clothes = clothes;
	}

}
