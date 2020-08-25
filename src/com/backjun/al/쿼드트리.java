package com.backjun.al;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 쿼드트리 {
	static int N;
	static int[] dr = { 0, 0, 1, 1 };
	static int[] dc = { 0, 1, 0, 1 };
	static String[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tr = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tr.nextToken());
		map = new String[N][N];
		for (int i = 0; i < N; i++) {
			tr = new StringTokenizer(br.readLine());
			String s = tr.nextToken();
			for (int j = 0; j < N; j++) {
				map[i][j] = Character.toString(s.charAt(j));
			}
		}
		Comp();
	}

	private static void Comp() {
		for (int l = 1; l < N; l *= 2) {
			for (int j = 0; j < N; j += 2 * l) {
				for (int k = 0; k < N; k += 2 * l) {
					String s = "";
					char[] c = new char[4];
					for (int i = 0; i < 4; i++) {
						c[i] = map[j + dr[i] * l][k + dc[i] * l].charAt(0);
					}
					if (c[0] == c[1] && c[1] == c[2] && c[2] == c[3] && (c[0] == '0' || c[0] == '1'))
						s = c[0] + "";
					else
						s = "(" + map[j + dr[0] * l][k + dc[0] * l] + map[j + dr[1] * l][k + dc[1] * l] + map[j + dr[2] * l][k + dc[2] * l]
								+ map[j + dr[3] * l][k + dc[3] * l] + ")";
					map[j][k] = s;
				}
			}

		}

		System.out.print(map[0][0]);

	}

}
