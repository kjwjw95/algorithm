package com.kakao.blind2021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map.Entry;

public class s2 {

	public static void main(String[] args) {
		String[] ss = { "ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH" };
		int[] course = { 2, 3, 4 };
		Solution2 s2 = new Solution2();
		String[] res = s2.solution(ss, course);
		for (int i = 0; i < res.length; i++) {
			System.out.print(res[i] + " ");
		}
		System.out.println();

		String[] ss2 = { "ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD" };
		int[] course2 = { 2, 3, 5 };
		String[] res2 = s2.solution(ss2, course2);
		for (int i = 0; i < res2.length; i++) {
			System.out.print(res2[i] + " ");
		}
		System.out.println();

		String[] ss3 = { "XYZ", "XWY", "WXA" };
		int[] course3 = { 2, 3, 4 };
		String[] res3 = s2.solution(ss3, course3);
		for (int i = 0; i < res3.length; i++) {
			System.out.print(res3[i] + " ");
		}
		System.out.println();
	}

}

class Solution2 {
	static ArrayList<String> Find;

	class Course {
		Integer cnt;
		String menu;

		public Course(int cnt, String menu) {
			super();
			this.cnt = cnt;
			this.menu = menu;
		}

		@Override
		public String toString() {
			return "Course [cnt=" + cnt + ", menu=" + menu + "]";
		}
	}

	class AscendingInteger implements Comparator<Course> {
		@Override
		public int compare(Course a, Course b) {
			return b.cnt.compareTo(a.cnt);
		}
	}

	public String[] solution(String[] orders, int[] course) {
		String[] answer = {};
		ArrayList<String> ans = new ArrayList<String>();
		ArrayList<Course> Courses;
		for (int i = 0; i < course.length; i++) { // 코스 숫자 순서대로
			int n = course[i]; // n은 코스의 갯수
			Courses = new ArrayList<Course>();
			for (int j = 0; j < orders.length - 1; j++) { // 첫번째 손님
				String temp = orders[j];
				Find = new ArrayList<String>();
				if (temp.length() < n)
					continue; // 만약 코스의 숫자보다 작으면 컨티뉴
				Combination(temp, n, "", 0); // n만큼 조합
				for (int k = 0; k < Find.size(); k++) { // 조합된 배열만큼
					String find = Find.get(k); // 조합된 배열 순서대로
					for (int l = j + 1; l < orders.length; l++) { // 두번째 손님과 비교
						String next = orders[l];
						int cnt = 0;
						for (int m = 0; m < find.length(); m++) {
							if (next.contains(find.charAt(m) + "")) {
								cnt++;
							}
						}
						if (cnt == find.length()) {
							boolean b = false;
							int N = 0;
							for (int m = 0; m < Courses.size(); m++) {
								if (Courses.get(m).menu.equals(find)) {
									b = true;
									N = m;
									break;
								}
							}
							if (!b)
								Courses.add(new Course(2, find));
							else
								Courses.get(N).cnt += 1;
							break;
						}
					}
				}
			}
			if (Courses.size() == 0)
				continue;
			Collections.sort(Courses, new AscendingInteger());
			int max = Courses.get(0).cnt;
			for (int j = 0; j < Courses.size(); j++) {
				if (Courses.get(j).cnt < max)
					break;
				String s = Courses.get(j).menu;
				char[] c = new char[s.length()];
				for (int k = 0; k < c.length; k++) {
					c[k] = s.charAt(k);
				}
				Arrays.sort(c);
				String r = "";
				for (int k = 0; k < c.length; k++) {
					r += c[k];
				}
				ans.add(r);
			}
		}
		answer = new String[ans.size()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = ans.get(i);
		}
		Arrays.sort(answer);
		return answer;
	}

	private void Combination(String temp, int n, String result, int idx) {
		if (result.length() == n) {
			// System.out.println(result);
			Find.add(result);
			return;
		}
		for (int i = idx; i < temp.length(); i++) {
			String s = result + temp.charAt(i);
			Combination(temp, n, s, i + 1);
		}
	}

}