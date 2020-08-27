package com.backjun.al;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 오목 {
	static int[][] map = new int[20][20];
	static int[] dr = { 0, 1, 1, -1 };
	static int[] dc = { 1, 1, 0, 1 };
	static int Ans = 0;
	static boolean[][][] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 1; i < 20; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j < 20; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		visit = new boolean[20][20][4];
		for (int j = 1; j < 20; j++) {
			for (int i = 1; i < 20; i++) {
				if (map[i][j] != 0) {
					for (int k = 0; k < dr.length; k++) {
						int doll = map[i][j];
						int cnt = 1;
						int nr = i + dr[k] * cnt;
						int nc = j + dc[k] * cnt;
						while (nr > 0 && nc > 0 && nr < 20 && nc < 20 && map[nr][nc] == doll && !visit[nr][nc][k]) {
							visit[nr][nc][k] = true;
							cnt++;
							nr = i + dr[k] * cnt;
							nc = j + dc[k] * cnt;
						}
						if (cnt == 5) {
							System.out.printf("%d \n%d %d", doll, i, j);
							return;
						}
					}
				}
			}
		}
		System.out.println(0);
	}

}
