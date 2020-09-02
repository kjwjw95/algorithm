package com.backjun.al;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 색종이_붙이기 {
	static int ans = Integer.MAX_VALUE;
	static boolean fail;
	static int[] colorPaper = { 5, 5, 5, 5, 5 };
	static int[][] map = new int[10][10];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 10; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		Solution(0, 0, 0, 0);
		if (ans == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else
			System.out.println(ans);
	}

	private static void Solution(int Ans, int r, int c, int idx) {
		if (Ans > ans)
			return;
		if (idx == 100) {
			ans = Math.min(ans, Ans);
			return;
		}
		if (map[r][c] == 1) {
			for (int i = 0; i < 5; i++) {
				if (Find(5 - i, r, c, 0) && colorPaper[i]>0) {
					colorPaper[i]--;
					Paint(5 - i, r, c, 0);
					Solution(Ans + 1,(idx + 1) / 10, (idx + 1) % 10, idx + 1);
					colorPaper[i]++;
					Paint(5 - i, r, c, 1);
				}
			}
		} else {
			Solution(Ans, (idx + 1) / 10, (idx + 1) % 10, idx + 1);
		}
	}

//	Solution(Ans,k+1,r,c,idx+1);

	private static void Print(int k, int ans2) {
		System.out.println(k + " " + ans2);
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println(); 
		}
		System.out.println();
	}

	private static void Paint(int size, int r, int c, int k) {
		for (int i = r; i < r + size; i++) {
			for (int j = c; j < c + size; j++) {
				map[i][j] = k;
			}
		}
	}

	private static boolean Find(int size, int r, int c, int n) {
		for (int i = r; i < r + size; i++) {
			for (int j = c; j < c + size; j++) {
				if (i < 0 || j < 0 || i >= 10 || j >= 10)
					return false;
				if (map[i][j] == n)
					return false;
			}
		}
		return true;
	}

}
