package com.swea.d2;

import java.util.Scanner;
import java.io.FileInputStream;

class 달팽이_숫자 {
	static int N, T, C;
	static int[][] Map;
	static boolean[][] isgo;

	public static void main(String args[]) throws Exception {

		System.setIn(new FileInputStream("res/달팽이_숫자.txt"));
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			Map = new int[N][N];
			isgo = new boolean[N * 2][N * 2];
			C = N * N;
			Map[0][0] = 1;
			isgo[0][0] = true;
			Solution(0, 0, 2);
			System.out.println("#" + test_case);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(Map[i][j] + " ");
				}
				System.out.println("");
			}
		}
	}

	private static void Solution(int r, int c, int cnt) {
		if (cnt > C)
			return;
		for (int i = 1; i <= N; i++) {
			if (c + i < N && isgo[r][c + i] == false) {
				Map[r][c + i] = cnt;
				isgo[r][c + i] = true;
				cnt++;
			} else {
				c = c + i - 1;
				break;
			}
		}
		for (int i = 1; i <= N; i++) {
			if (r + i < N && isgo[r + i][c] == false) {
				Map[r + i][c] = cnt;
				isgo[r + i][c] = true;
				cnt++;
			} else {
				r = r + i - 1;
				break;
			}
		}
		for (int i = 1; i <= N; i++) {
			if (c - i >= 0 && isgo[r][c - i] == false) {
				Map[r][c - i] = cnt;
				isgo[r][c - i] = true;
				cnt++;
			} else {
				c = c - i + 1;
				break;
			}
		}
		for (int i = 1; i <= N; i++) {
			if (r - i >= 0 && isgo[r - i][c] == false) {
				Map[r - i][c] = cnt;
				isgo[r - i][c] = true;
				cnt++;
			} else {
				r = r - i + 1;
				break;
			}
		}
		Solution(r, c, cnt);
	}
}