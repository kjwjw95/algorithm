package com.backjun.al;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 색종이_만들기 {
	static int N, Ans,Blue,White;
	static int[] dr = {0, 0, 1, 1 };
	static int[] dc = {0, 1, 1, 0 };
	static int[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		Blue=0;
		White=0;
		Solution(1);
		System.out.println(White);
		System.out.println(Blue);
	}

	private static void Solution(int n) {
		if (n == N) {
			return;
		}
		for (int i = 0; i < N; i+=n*2) {
			for (int j = 0; j < N; j+=n*2) {
				int blue=0;
				int white=0;
				for (int k = 0; k < 4; k++) {
					int nr=i+dr[k]*n;
					int nc=j+dc[k]*n;
					if(map[nr][nc]==1)	blue++;
					else if(map[nr][nc]==0)	white++;
				}
				if(white!=4 && blue!=4) {
					Blue+=blue;
					White+=white;
					map[i][j]=2;
				}
			}
		}
		Solution(n*2);
	}

}
