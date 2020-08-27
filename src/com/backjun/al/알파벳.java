package com.backjun.al;

import java.awt.AlphaComposite;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 알파벳 {
	static int R, C, Ans;
	static int[] dr = { 0, -1, 0, 1 };
	static int[] dc = { 1, 0, -1, 0 };
	static char[] alpha;
	static char[][] map;
	static boolean[][] select;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][];
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		select = new boolean[R][C];
		alpha = new char[26];
		alpha[0] = map[0][0];
		Solution(0, 0, 1);
		System.out.println(Ans);
	}

	private static void Solution(int r, int c, int cnt) {
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (nr < 0 || nc < 0 || nr >= R || nc >= C || select[nr][nc])
				continue;
			boolean isSelect = false;
			for (int j = 0; j < cnt; j++) {
				if (alpha[j] == map[nr][nc]) {
					isSelect = true;
					break;
				}
			}
			if (isSelect)
				continue;
			select[nr][nc] = true;
			alpha[cnt] = map[nr][nc];
			Solution(nr, nc, cnt + 1);
			select[nr][nc] = false;
		}
		Ans = Math.max(Ans, cnt);
	}

}
