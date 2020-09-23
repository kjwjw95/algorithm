package com.backjun.al;

import java.util.Scanner;

public class 파이프옮기기1 {
	static int answer;
	static int[] dr = { 0, 1, 1 };
	static int[] dc = { 1, 1, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] map = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		DFS(0, 1, 0, N, map);
		System.out.println(answer);
	}

	private static void DFS(int row, int col, int cnt, int N, int[][] map) {
		//System.out.println(row+" "+col+" cnt: "+cnt);
		if (row == N - 1 && col == N - 1) {
			answer++;
			return;
		}
		boolean[] cantgo=new boolean[3];
		switch (cnt) {
		case 0:
			cantgo[2]=true;
			break;
		case 2:
			cantgo[0]=true;
			break;
		}
		for (int i = 0; i < 3; i++) {
			int nr=row + dr[i];
			int nc = col + dc[i];
			if (nr>=0 && nr<N && nc>=0 && nc<N && map[nr][nc]==0 && !cantgo[i]) {
				if(i==1) {
					int ar= nr-1;
					int ac= nc-1;
					if(ar<0 || ar>=N || ac<0 || ac>=N || map[nr][ac]==1 || map[ar][nc]==1)
						continue;
				}
				DFS(row + dr[i], col + dc[i], i, N, map);
			}
		}
	}


}
