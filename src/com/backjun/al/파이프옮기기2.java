package com.backjun.al;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 파이프옮기기2 {
	static long answer;
	static int[] dr = { 0, 1, 1 };
	static int[] dc = { 1, 1, 0 };

	static class pipe {
		int r, c, current;

		public pipe(int r, int c, int cur) {
			this.r = r;
			this.c = c;
			this.current = cur;
		}

		@Override
		public String toString() {
			return "pipe [r=" + r + ", c=" + c + ", current=" + current + "]";
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] map = new int[N][N];
		long[][][] D = new long[3][N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		D[0][0][1] = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (j + 1 < N && map[i][j + 1] == 0)
					D[0][i][j + 1] += D[0][i][j] + D[1][i][j];
				if (i + 1 < N && map[i + 1][j] == 0)
					D[2][i + 1][j] += D[2][i][j] + D[1][i][j];
				if (j + 1 < N && i + 1 < N && map[i][j + 1] == 0 && map[i + 1][j] == 0 && map[i + 1][j + 1] == 0)
					D[1][i + 1][j + 1] += D[0][i][j] + D[1][i][j] + D[2][i][j];
			}
		}
//		for (int k = 0; k < D.length; k++) {
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < N; j++) {
//					System.out.print(D[k][i][j]+" ");
//				}
//				System.out.println();
//			}
//			System.out.println();
//		}
		
		answer = D[0][N - 1][N - 1] + D[1][N - 1][N - 1] + D[2][N - 1][N - 1];
		System.out.println(answer);
	}

}
