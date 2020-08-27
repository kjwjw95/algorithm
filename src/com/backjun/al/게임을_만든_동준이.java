package com.backjun.al;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 게임을_만든_동준이 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
		int ans = 0;
		int[] game = new int[N];
		for (int i = 0; i < game.length; i++) {
			game[i] = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
		}
		for (int i = 1; i < game.length; i++) {
			if (game[N - i] <= game[N - i - 1]) {
				int temp = game[N - i - 1] - game[N - i] + 1;
				game[N - i - 1] -= temp;
				ans += temp;
			}
		}
		System.out.println(ans);
	}

}
