package com.swea.d4;

import java.util.Scanner;
import java.io.FileInputStream;

class 은비의_동전_뒤집기 {
	static int N;
	static long[] select = new long[1001];
	static long Ans, sum;

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/은비의동전뒤집기.txt"));
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			Ans = 0;
			sum = 0;
			long a = Solution(N);
			System.out.println("#" + test_case + " " + a);
		}
	}

	private static long Solution(int num) {
		if (num == 1) {
			return 0;
		}
		if (select[num] != 0)
			return select[num];

		long ans = num / 2;
		for (int i = 1; i < num; i++) {
			ans = (ans*i)% 1000000007;
		}
		select[num] = (ans + num * Solution(num - 1)) % 1000000007;
		return select[num];
	}
}