package com.backjun.al;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 빵집 {
	static char[][] map;
	static int[] loc;
	static int R, C, Ans;
	static int[] dr = { -1, 0, 1 };
	static int[] dc = { 1, 1, 1 };
	static boolean pipe;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R + 1][C + 1];
		loc = new int[C+1];
		for (int i = 1; i <= R; i++) {
			String s = br.readLine();
			for (int j = 1; j <= C; j++) {
				map[i][j] = s.charAt(j - 1);
			}
		}
		for (int i = 1; i <= R; i++) {
			pipe = false;
			loc[0] = i;
			map[i][1] = 'x';
			DFS(i, 1);
		}
		System.out.println(Ans);
	}

	private static void DFS(int r, int c) {
		if (c == C && !pipe) {
			pipe = true;
			Ans++;
			return;
		}
		if (pipe)
			return;
		for (int i = 0; i < 3; i++) {
			if (pipe)
				return;
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (nr <= 0 || nc <= 0 || nr > R || nc > C || map[nr][nc] == 'x')
				continue;
			map[nr][nc] = 'x';
			DFS(nr, nc);
		}
	}

}
