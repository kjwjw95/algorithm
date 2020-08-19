package com.swea.d2;
import java.util.Scanner;
import java.io.FileInputStream;

class 가랏_rc카_1940 {
	public static void main(String args[]) throws Exception {
		 System.setIn(new FileInputStream("res/가랏_rc카.txt"));
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int sum = 0;
			int v = 0;
			for (int i = 0; i < N; i++) {
				int num = sc.nextInt();
				switch (num) {
				case 0:
					break;
				case 1:
					v += sc.nextInt();
					break;
				case 2:
					v -= sc.nextInt();
					break;
				}
				if (v < 0)
					v = 0;
				sum += v;
			}
			System.out.println("#" + test_case + " " + sum);
		}
	}
}