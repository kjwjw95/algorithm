package com.backjun.al;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 벽_부수고_이동하기 {
	static int N, M, Ans;
	static int[][] map;
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };
	static boolean[][][] select;
	static boolean isFirst;

	static class Loc {
		int row, col, wall, step;

		public Loc(int r, int c, int w, int s) {
			this.row = r;
			this.col = c;
			this.wall = w;
			this.step = s;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		select = new boolean[N][M][2];
		isFirst = true;
		Ans = -1;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		BFS();
		System.out.println(Ans);
	}

	private static void BFS() {
		Queue<Loc> q = new LinkedList<Loc>();
		q.add(new Loc(0, 0, 0, 1));
		select[0][0][0] = true;
		select[0][0][1] = true;
		while (!q.isEmpty()) {
			Loc loc = q.poll();
			if (loc.row == N - 1 && loc.col == M - 1) {
				if (isFirst)
					Ans = loc.step;
				else {
					isFirst = false;
					Ans = Math.min(Ans, loc.step);
				}
				break;
			}
			for (int i = 0; i < 4; i++) {
				int nr = loc.row + dr[i];
				int nc = loc.col + dc[i];
				if (nr < 0 || nc < 0 || nr >= N || nc >= M)
					continue;
				if (map[nr][nc] == 0 && !select[nr][nc][loc.wall]) {
					select[nr][nc][loc.wall] = true;
					q.add(new Loc(nr, nc, loc.wall, loc.step + 1));
				} else if (map[nr][nc] == 1 && loc.wall == 0) {
					select[nr][nc][1] = true;
					q.add(new Loc(nr, nc, 1, loc.step + 1));
				}
			}
		}
	}

}
